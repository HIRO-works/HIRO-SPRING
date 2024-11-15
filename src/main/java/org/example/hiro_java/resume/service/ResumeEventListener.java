package org.example.hiro_java.resume.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.hiro_java.resume.service.dto.FileUploadEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class ResumeEventListener {
    final FileAnalyzeClient fileAnalyzeClient;

    @Async @EventListener
    void FileUploadEventHandler(FileUploadEvent fileUploadEvent) {
        log.info("FileUploadEventHandler: {}", fileUploadEvent);
        fileAnalyzeClient.analyzeFile(fileUploadEvent.getResumeId(), fileUploadEvent.getUserId(),fileUploadEvent.getFileKey());
    }
}
