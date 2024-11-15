package org.example.hiro_java.resume.service;

import lombok.RequiredArgsConstructor;
import org.example.hiro_java.global.exceptions.CustomException;
import org.example.hiro_java.resume.entity.Resume;
import org.example.hiro_java.resume.repository.ResumeJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FileAnalyzeClient {
    final static String analyzeUrl = "http://144.24.81.14/api/ai/analyze";

    final RestTemplate restTemplate;
    final ResumeJpaRepository resumeJpaRepository;

    @Transactional
    public void analyzeFile(String resumeId, String userId, String fileKey) {

        Map<String, Object> analyzeReq = new HashMap<>();
        analyzeReq.put("resume_id", resumeId);
        analyzeReq.put("user_id", userId);
        analyzeReq.put("file_path", fileKey);
        var analyzeRes = restTemplate.getForObject(analyzeUrl, Map.class, analyzeReq);
        if(analyzeRes == null) throw new CustomException(500, "Failed to analyze");

        var entity = Resume.builder()
                .id(resumeId)
                .applicantName((String) analyzeRes.get("applicant_name"))
                .userId(userId)
                .career((Integer) analyzeRes.get("career"))
                .educationLevel((Integer) analyzeRes.get("education_level"))
                .build();

        List<String> jobCategories = (List<String>) analyzeRes.get("job_categories");
        for (String jobCategory : jobCategories) {
            entity.addJobCategory(jobCategory);
        }

        List<String> languages = (List<String>) analyzeRes.get("languages");
        for (String language : languages) {
            entity.addLanguage(language);
        }

        resumeJpaRepository.save(entity);
    }
}
