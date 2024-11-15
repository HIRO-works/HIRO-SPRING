package org.example.hiro_java.resume.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class FileAnalaizeClient {
    final static String analyzeUrl = "/api/ai/analyze";

    final RestTemplate restTemplate;

    public void analyzeFile(String resumeId, String userId, String fileKey) {

        Map<String, Object> analyzeReq = new HashMap<>();
        analyzeReq.put("resume_id", resumeId);
        analyzeReq.put("user_id", userId);
        analyzeReq.put("file_path", fileKey);
        restTemplate.getForEntity(analyzeUrl, Map.class, analyzeReq);

    }
}
