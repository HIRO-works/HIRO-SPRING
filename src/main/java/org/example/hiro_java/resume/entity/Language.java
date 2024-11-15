package org.example.hiro_java.resume.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="language")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Language {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "resume_id")
    @ManyToOne
    private Resume resume;

    private String language;
}
