package com.algoarena.algoarena.config;


import io.minio.MinioClient;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class MinioConfig {
    @Value("${spring.minio.url}")
    private String url;

    @Value("${spring.minio.access-key}")
    private String accessKey;

    @Value("${spring.minio.secret-key}")
    private String accessSecret;

    @Value("${spring.minio.bucket-name}")
    private String defaultBuckets;

    @Value("${spring.minio.presigned-url-expiry}")
    private int presignedUrlExpiry;

    @Bean
    public MinioClient minioClient() {
        return MinioClient
                .builder()
                .endpoint(url)
                .credentials(
                        accessKey,
                        accessSecret
                )
                .build();
    }
}
