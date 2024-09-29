package com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NLearnerDTO {

    @NotBlank(message = "firstName is required")
    @NotBlank(message = "firstName is required")
    private String firstName;

    @NotBlank(message = "lastName is required")
    @NotBlank(message = "lastName is required")
    private String lastName;

    @NotBlank(message = "className is required")
    @NotBlank(message = "className is required")
    private String className;

    @NotBlank(message = "school is required")
    @NotBlank(message = "school is required")
    private String school;

    @NotBlank(message = "schoolDistrict is required")
    @NotBlank(message = "schoolDistrict is required")
    private String schoolDistrict;

    @NotBlank(message = "districtOfBirth is required")
    @NotBlank(message = "districtOfBirth is required")
    private String districtOfBirth;

    @NotBlank(message = "term is required")
    @NotBlank(message = "term is required")
    private String term;

    @NotBlank(message = "year is required")
    @NotBlank(message = "year is required")
    private String year;

    @NotBlank(message = "gender is required")
    @NotBlank(message = "gender is required")
    private String gender;
}
