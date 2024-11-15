package org.example.hiro_java.resume.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.hiro_java.user.infra.UserEntity;

@Entity
@Table
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Resume {
    @Id
    @Column(name = "resume_id")
    private String id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;

    private Long career;

    @Column(name = "applicant_name")
    private String applicantName;

    @Column(name = "applicant_email")
    private Integer educationLevel;
}
