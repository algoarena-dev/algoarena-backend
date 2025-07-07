package com.algoarena.algoarena.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemResponseDto {
    private Long id;

    private String name;

    private String difficulty;

    private int timeLimitMillis;
    private int memoryLimitMB;

    private String statementPath;
    private String inputFormatPath;
    private String outputFormatPath;

    private String testCasesPath;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String sampleInput;
    private String sampleOutput;

    private List<String> imagePaths;

    private List<String>tags;
}
