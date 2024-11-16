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
        var analyzeRes = restTemplate.postForObject(analyzeUrl, analyzeReq, Map.class);
        if(analyzeRes == null) throw new CustomException(500, "Failed to analyze");

        var optionalResume = resumeJpaRepository.findById(resumeId);
        if(optionalResume.isEmpty()) throw new CustomException(500, "Failed to find resume");

        var entity = optionalResume.get();
        String jobCategory = (String) analyzeRes.get("job_category");
        entity.addJobCategory(jobCategory);

        String language = (String)analyzeRes.get("language");
        entity.addLanguage(language);

        entity.analyzeCompleted((String) analyzeRes.get("years"), (String) analyzeRes.get("applicant_name"));

        resumeJpaRepository.save(entity);
    }
}
