package com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NAttendanceDTO {

    @NotBlank(message = "learnerId is required")
    @NotBlank(message = "learnerId is required")
    private int learnerId;

    @NotBlank(message = "className is required")
    @NotBlank(message = "className is required")
    private String className;

    @NotBlank(message = "attendanceDateTime is required")
    @NotBlank(message = "attendanceDateTime is required")
    private String attendanceDateTime;

    private boolean status;

    @NotBlank(message = "comment is required")
    @NotBlank(message = "comment is required")
    private String comment;

    @NotBlank(message = "school is required")
    @NotBlank(message = "school is required")
    private String school;

    @NotBlank(message = "schoolDistrict is required")
    @NotBlank(message = "schoolDistrict is required")
    private String schoolDistrict;

    @NotBlank(message = "term is required")
    @NotBlank(message = "term is required")
    private String term;

    @NotBlank(message = "year is required")
    @NotBlank(message = "year is required")
    private String year;
}
