package org.example.hiro_java.resume.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.MAP;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.hiro_java.resume.repository.ResumeJpaRepository;
import org.example.hiro_java.resume.service.FileAnalyzeClient;
import org.example.hiro_java.resume.service.ResumeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@SpringBootTest
@ActiveProfiles("test")
@Sql(scripts = "classpath:testinit.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class ResumeControllerTest {
    @Autowired
    ResumeService resumeService;

    @Autowired
    ResumeJpaRepository resumeJpaRepository;

    @Mock
    RestTemplate restTemplate;
    FileAnalyzeClient fileAnalyzeClient;



    @Test
    void integTest() {
        var userId = "test";

        var resumes = resumeService.getResumes(userId);

        assertThat(resumes).isNotNull();
        assertThat(resumes).isNotEmpty();
    }

    @Test
    void testFileAnalyze() throws JsonProcessingException {
        fileAnalyzeClient = new FileAnalyzeClient(restTemplate, resumeJpaRepository);

        var resume = resumeService.getResumes("test").get(0);
        var testData = (new ObjectMapper()).readValue("""
                  {
                    "resume_id": "00000000-0000-0000-0000-000000000001",
                    "applicant_name": "김철수",
                    "user_id": "test",
                    "career": "5",
                    "education_level": 3,
                    "job_categories": ["소프트웨어 엔지니어", "데이터 분석가"],
                    "languages": ["한국어", "영어"]
                  }
                """, Map.class);
        when(restTemplate.postForObject(anyString(), any(), any())).thenReturn(testData);
        fileAnalyzeClient.analyzeFile("00000000-0000-0000-0000-000000000001", resume.getUserId(), "test");

        var afterInsert = resumeService.getResumes("test");
        assertThat(afterInsert).isNotNull();
    }
}