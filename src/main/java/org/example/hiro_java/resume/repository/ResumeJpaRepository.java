package org.example.hiro_java.resume.repository;

import org.example.hiro_java.resume.entity.Resume;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeJpaRepository extends JpaRepository<Resume, String> {
    @EntityGraph(attributePaths = { "jobCategories", "languages" })
    List<Resume> findResumesByUserId(String userId);
}
