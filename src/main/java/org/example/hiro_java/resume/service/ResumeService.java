package org.example.hiro_java.resume.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hiro_java.resume.entity.Resume;
import org.example.hiro_java.resume.repository.ResumeJpaRepository;
import org.example.hiro_java.resume.service.dto.FileUploadEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ResumeService {
    private final ApplicationEventPublisher eventPublisher;
    private final S3Client s3Client;
    private final ResumeJpaRepository resumeJpaRepository;

    @Value("${S3_BUCKET}")
    private String bucketName;

    public Resume getResumeInfo(String resumeId){
        return resumeJpaRepository.findById(resumeId).orElse(null);
    }

    public String uploadFile(MultipartFile file, String userId) {
        if (file == null || file.isEmpty() || file.getOriginalFilename() == null) {
            return "File is empty";
        }

        String fileName = file.getOriginalFilename();
        long fileSize = file.getSize();
        // Read PDF content (if necessary, using libraries like Apache PDFBox for detailed parsing)
        log.info("File Name: {}", fileName);
        log.info("File Size: {} bytes", fileSize);

        // try to save the file at S3
        log.info("Uploading file to S3");
        UUID key = UUID.randomUUID();
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(key + ".pdf")
                .build();

        // Save the file locally for processing (optional)
        try {
            log.info("Uploading file to S3 pdf_name: {}", key + ".pdf");
            log.info("user id: {}", userId);
            s3Client.putObject(putObjectRequest, RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
        } catch (IOException e) {
            log.error("Error uploading file to S3", e);
            throw new RuntimeException(e);
        }

        resumeJpaRepository.save(new Resume(key.toString(), userId, fileName, fileSize));

        eventPublisher.publishEvent(new FileUploadEvent(key.toString(), userId, key + ".pdf"));

        return key.toString();
    }

    public List<Resume> getResumes(String userId) {
        return resumeJpaRepository.findResumesByUserIdOrderByCreatedAtDesc(userId);
    }

}
