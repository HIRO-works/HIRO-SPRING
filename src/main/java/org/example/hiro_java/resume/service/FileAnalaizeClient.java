package org.example.hiro_java.resume.service;

import lombok.RequiredArgsConstructor;
import org.example.hiro_java.global.exceptions.CustomException;
import org.example.hiro_java.resume.entity.JobCategory;
import org.example.hiro_java.resume.entity.Resume;
import org.example.hiro_java.resume.repository.ResumeJpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FileAnalaizeClient {
    final static String analyzeUrl = "/api/ai/analyze";

    final RestTemplate restTemplate;
    final ResumeJpaRepository resumeJpaRepository;

    public void analyzeFile(String resumeId, String userId, String fileKey) {

        Map<String, Object> analyzeReq = new HashMap<>();
        analyzeReq.put("resume_id", resumeId);
        analyzeReq.put("user_id", userId);
        analyzeReq.put("file_path", fileKey);
        var analyzeRes = restTemplate.getForEntity(analyzeUrl, Map.class, analyzeReq).getBody();
        if(analyzeRes == null) throw new CustomException(500, "Failed to analyze");

        var entity = Resume.builder()
                .id((String) analyzeRes.get("resume_id"))
                .applicantName((String) analyzeRes.get("applicant_name"))
                .userId((String) analyzeRes.get("user_id"))
                .career((Long) analyzeRes.get("career"))
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
