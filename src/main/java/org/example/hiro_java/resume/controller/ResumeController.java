package org.example.hiro_java.resume.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hiro_java.resume.service.ResumeService;
import org.example.hiro_java.resume.service.dto.ResumesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    /**
     * todo user id 받아서 DB에 저장
     * 1. 파일 S3에 업로드(이름 UUID로 변경)
     * 2. eventPublisher 통해 파일 업로드 이벤트 발행 & 응답
     * 3. 해당 이벤트를 받아서 파이썬 api 호출
     * 4. api 응답 결과 & UUID DB에
     */
    @PostMapping("/api/file/upload")
    public String uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestHeader(value = "X-User", defaultValue = "test") String userId) {
        return resumeService.uploadFile(file, userId);
    }

    /**
     * 리팩토링
     * todo user id 받아서 검증
     */
    @GetMapping("/api/resumes/{resumeId}/download")
    public ResponseEntity<byte[]> downloadFile(
            @PathVariable("resumeId") String resumeId
    ) {
        return resumeService.downloadFile(resumeId);
    }

    @GetMapping("/api/resumes/{resumeId}")
    ResumesResponse getResumeInfo(@PathVariable("resumeId") String resumeId) {
        return new ResumesResponse(resumeService.getResumeInfo(resumeId));
    }

    @GetMapping("/api/resumes")
    public List<ResumesResponse> getResumes(@RequestHeader("X-User") String userId) {
        log.info("Getting resumes");
        return resumeService.getResumes(userId);
    }
}
