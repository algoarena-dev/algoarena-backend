package com.algoarena.algoarena.service;

import com.algoarena.algoarena.dto.ProblemRequestDto;
import com.algoarena.algoarena.dto.ProblemResponseDto;

import java.util.List;

public interface ProblemService {
    List<ProblemResponseDto> getAllProblems();
    ProblemResponseDto getProblemById(Long id);
    ProblemResponseDto createProblem(ProblemRequestDto problemRequestDto);
    ProblemResponseDto updateProblemById(Long id,ProblemRequestDto problemRequestDto);
    void deleteProblemById(Long id);
}
