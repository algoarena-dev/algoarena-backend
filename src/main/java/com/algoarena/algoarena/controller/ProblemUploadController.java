package com.algoarena.algoarena.controller;

import com.algoarena.algoarena.dto.PresignedUrlResponseDto;
import com.algoarena.algoarena.service.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/problems")
public class ProblemUploadController {
    private final MinioService minioService;

    @GetMapping("/upload-url")
    @ResponseStatus(HttpStatus.OK)
    public PresignedUrlResponseDto getPresignedUrl(@RequestParam String objectName){
        return minioService.getPresignedUrl(objectName);
    }
}
