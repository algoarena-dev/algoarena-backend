package com.algoarena.algoarena.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProblemRequestDto {
    private String name;

    private String difficulty;

    private int timeLimitMillis;
    private int memoryLimitMB;

    private String statementPath;
    private String inputFormatPath;
    private String outputFormatPath;

    private String testCasesPath;

    private String sampleInput;
    private String sampleOutput;

    private List<String> imagePaths;

    private List<String>tags;
}
