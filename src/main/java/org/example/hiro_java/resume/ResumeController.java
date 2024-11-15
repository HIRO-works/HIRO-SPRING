package org.example.hiro_java.resume;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ResumeController {
    private final S3Client s3Client;

    @Value("${S3_BUCKET}")
    private String bucketName;

    @PostMapping("/api/file/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        if (file == null || file.isEmpty() || file.getOriginalFilename() == null) {
            return "File is empty";
        }

        // Read PDF content (if necessary, using libraries like Apache PDFBox for detailed parsing)
        log.info("File Name: {}", file.getOriginalFilename());
        log.info("File Size: {} bytes", file.getSize());

        // try to save the file at S3
        log.info("Uploading file to S3");
        UUID key = UUID.randomUUID();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key("temp/" + key + ".pdf")
                .build();

        // Save the file locally for processing (optional)
        try {
            s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
        } catch (IOException e) {
            log.error("Error uploading file to S3", e);
            throw new RuntimeException(e);
        }

        return key.toString();
    }

    @GetMapping("/api/resumes/{resumeId}/download")
    public ResponseEntity<byte[]> downloadFile(
            @PathVariable("resumeId") String resumeId
    ) {
        log.info("Downloading file");
        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key("temp/" + resumeId + ".pdf")
                .build();

        // S3에서 파일 가져오기
        try (InputStream s3InputStream = s3Client.getObject(getObjectRequest);
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[8 * 1024]; // 8KB 버퍼
            int bytesRead;
            while ((bytesRead = s3InputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }

            byte[] fileContent = byteArrayOutputStream.toByteArray();
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resumeId + ".pdf")
                    .contentType(MediaType.APPLICATION_OCTET_STREAM) // 파일의 MIME 타입에 맞게 설정할 수 있음
                    .body(fileContent);
        } catch (Exception e) {
            throw new RuntimeException("S3 파일 다운로드 실패", e);
        }
    }
}
