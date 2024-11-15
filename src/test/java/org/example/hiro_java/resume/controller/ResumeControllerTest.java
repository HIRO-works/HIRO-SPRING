package org.example.hiro_java.resume.controller;

import org.example.hiro_java.resume.service.ResumeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class ResumeControllerTest {
    @Autowired
    ResumeService resumeService;

    @Test
    void integTest() {
        var userId = "test";
    }
}