package org.example.hiro_java.resume.entity;

import jakarta.persistence.*;

@Entity
@Table(name="language")
public class Language {
    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "resume_id")
    @ManyToOne
    private Resume resume;

    private String language;
}
