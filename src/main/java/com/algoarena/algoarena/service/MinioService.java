package com.algoarena.algoarena.service;

import com.algoarena.algoarena.config.MinioConfig;
import com.algoarena.algoarena.dto.PresignedUrlResponseDto;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Service
public class MinioService {
    private final MinioConfig minioConfig;
    private final MinioClient minioClient;

    public PresignedUrlResponseDto getPresignedUrl(String objectName) {
        try {
            return new PresignedUrlResponseDto(
                    minioClient.getPresignedObjectUrl(
                            GetPresignedObjectUrlArgs.builder()
                                    .method(Method.PUT)
                                    .bucket(minioConfig.getDefaultBuckets())
                                    .object(objectName)
                                    .expiry(minioConfig.getPresignedUrlExpiry(), TimeUnit.MINUTES)
                                    .build()
                    )
            );
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate presigned URL", e);
        }
    }

}
