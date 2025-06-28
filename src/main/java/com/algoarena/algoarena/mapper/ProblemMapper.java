package com.algoarena.algoarena.mapper;


import com.algoarena.algoarena.dto.ProblemRequestDto;
import com.algoarena.algoarena.dto.ProblemResponseDto;
import com.algoarena.algoarena.entity.Problem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProblemMapper {
    ProblemResponseDto toResponseDto(Problem problem);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Problem toEntity(ProblemRequestDto problemRequestDto);
}
