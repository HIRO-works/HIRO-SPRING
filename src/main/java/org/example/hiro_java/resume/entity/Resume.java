package org.example.hiro_java.resume.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hiro_java.user.infra.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resume {
    @Id
    @Column(name = "resume_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    private UserEntity user;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "career")
    private Integer career;

    @Column(name = "applicant_name")
    private String applicantName;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_size")
    private Long fileSize;

    @Column(name = "education_level")
    private Integer educationLevel;

    @Column(name = "analyze_completed")
    private Boolean analyzeCompleted;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    Set<JobCategory> jobCategories;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    Set<Language> languages;

    public Resume(String resumeId, String userId, String fileOrgName, Long fileSize) {
        this.id = resumeId;
        this.userId = userId;
        this.fileName = fileOrgName;
        this.fileSize = fileSize;
        this.analyzeCompleted = false;
    }

    public void analyzeCompleted(Integer career, String applicantName) {
        this.career = career;
        this.applicantName= applicantName;
        this.analyzeCompleted = true;
    }

    @Transactional
    public void addJobCategory(String jobCategory) {
        this.jobCategories = new HashSet<>();

        JobCategory entity = new JobCategory(null, this, jobCategory);
        this.jobCategories.add(entity);
    }

    @Transactional
    public void addLanguage(String language) {
        this.languages = new HashSet<>();

        Language entity = new Language(null, this, language);
        this.languages.add(entity);
    }
}
