package com.algoarena.algoarena.service.impl;


import com.algoarena.algoarena.dto.ProblemRequestDto;
import com.algoarena.algoarena.dto.ProblemResponseDto;
import com.algoarena.algoarena.entity.Problem;
import com.algoarena.algoarena.mapper.ProblemMapper;
import com.algoarena.algoarena.repository.ProblemRepository;
import com.algoarena.algoarena.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JpaProblemService implements ProblemService {
    private final ProblemRepository problemRepository;
    private final ProblemMapper problemMapper;

    @Override
    public List<ProblemResponseDto> getAllProblems(){
        List<Problem> problems = problemRepository.findAll();
        return problems.stream()
                .map(problemMapper::toResponseDto)
                .toList();
    }

    @Override
    public ProblemResponseDto getProblemById(Long id){
        Problem problem = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found."));
        return problemMapper.toResponseDto(problem);
    }

    @Override
    public ProblemResponseDto createProblem(ProblemRequestDto problemRequestDto){
        Problem problem = problemMapper.toEntity(problemRequestDto);
        problem.setCreatedAt(LocalDateTime.now());
        problem.setUpdatedAt(LocalDateTime.now());
        Problem savedProblem = problemRepository.save(problem);
        return problemMapper.toResponseDto(savedProblem);
    }

    @Override
    public ProblemResponseDto updateProblemById(Long id,ProblemRequestDto problemRequestDto){
        Problem existingProblem = problemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Problem not found."));

        Problem updatedProblem = problemMapper.toEntity(problemRequestDto);
        updatedProblem.setId(existingProblem.getId());
        updatedProblem.setCreatedAt(existingProblem.getCreatedAt());
        updatedProblem.setUpdatedAt(LocalDateTime.now());


        //existing id, will just change entity
        Problem savedProblem = problemRepository.save(updatedProblem);

        return problemMapper.toResponseDto(savedProblem);
    }

    @Override
    public void deleteProblemById(Long id){
        if (!problemRepository.existsById(id)) {
            throw new RuntimeException("Problem not found.");
        }
        problemRepository.deleteById(id);
    }
}
