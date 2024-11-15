package org.example.hiro_java.resume.service.dto;

import java.util.List;

public class ResumesResponse {

    private String resumeId;
    private String applicantName;
    private Long career;
    private Long educationLevel;
    private List<QualificationResponse> qualifications;
    private List<String> domains;
    private List<String> competences;

    public static class QualificationResponse {

        private String name;
        private Long score;

    }
}
