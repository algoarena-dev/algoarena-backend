package com.algoarena.algoarena.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "problems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String difficulty; // easy,medium or hard

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

    @ElementCollection
    @CollectionTable(name = "problem_images", joinColumns = @JoinColumn(name = "problem_id"))
    @Column(name = "image_path")
    private List<String> imagePaths;

    @ElementCollection
    @CollectionTable(name = "problem_tags", joinColumns = @JoinColumn(name = "problem_id"))
    @Column(name = "tag")
    private List<String>tags;
}