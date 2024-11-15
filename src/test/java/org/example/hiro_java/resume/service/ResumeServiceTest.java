package org.example.hiro_java.resume.service;

import org.example.hiro_java.resume.repository.ResumeJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;

import java.io.ByteArrayInputStream;

import static org.mockito.Mockito.*;

@SpringBootTest
@ActiveProfiles("test")
class ResumeServiceTest {
    @MockBean
    S3Client s3Client;

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @Autowired
    ResumeJpaRepository resumeJpaRepository;

    @MockBean
    FileAnalyzeClient fileAnalyzeClient;

    @Autowired
    ResumeService resumeService;
    @Test
    void test_event_publisher() throws Exception {
        // given
        MultipartFile file = mock(MultipartFile.class);
        when(file.isEmpty()).thenReturn(false);
        when(file.getOriginalFilename()).thenReturn("test.pdf");
        when(file.getSize()).thenReturn(1L);
        when(file.getInputStream()).thenReturn(new ByteArrayInputStream(new byte[1]));

        // when
        resumeService.uploadFile(file, "test");

        // then
        Thread.sleep(2000);
        verify(fileAnalyzeClient, times(1))
                .analyzeFile(anyString(), anyString(), anyString());
    }
}