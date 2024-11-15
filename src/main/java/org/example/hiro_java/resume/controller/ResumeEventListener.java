package org.example.hiro_java.resume.controller;

import lombok.RequiredArgsConstructor;
import org.example.hiro_java.resume.service.FileAnalaizeClient;
import org.example.hiro_java.resume.service.dto.FileUploadEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class ResumeEventListener {
    final FileAnalaizeClient fileAnalaizeClient;

    @Async @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    void FileUploadEventHandler(FileUploadEvent fileUploadEvent) {
        fileAnalaizeClient.analyzeFile(fileUploadEvent.getResumeId(), fileUploadEvent.getUserId(),fileUploadEvent.getFileKey());
    }
}
