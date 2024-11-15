package org.example.hiro_java.resume.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FileUploadEvent {
    String resumeId;
    String userId;
    String fileKey;
}
