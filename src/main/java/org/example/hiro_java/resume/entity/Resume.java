package org.example.hiro_java.resume.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hiro_java.user.infra.UserEntity;

import java.util.List;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
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
    private Long career;

    @Column(name = "applicant_name")
    private String applicantName;

    @Column(name = "education_level")
    private Integer educationLevel;

    @OneToMany(mappedBy = "resume")
    List<JobCategory> jobCategories;

    @OneToMany(mappedBy = "resume")
    List<Language> languages;
}
