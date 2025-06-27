package com.algoarena.algoarena.controller;


import com.algoarena.algoarena.dto.ProblemRequestDto;
import com.algoarena.algoarena.dto.ProblemResponseDto;
import com.algoarena.algoarena.service.ProblemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/problems")
public class ProblemController {
    private final ProblemService problemService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProblemResponseDto> getAllProblems(){

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProblemResponseDto getProblemById(@PathVariable Long id){

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProblemResponseDto createProblem(@RequestBody ProblemRequestDto problemRequestDto){

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProblemResponseDto updateProblemById(@PathVariable Long id,@RequestBody ProblemRequestDto problemRequestDto){

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProblemById(@PathVariable Long id){

    }
}
