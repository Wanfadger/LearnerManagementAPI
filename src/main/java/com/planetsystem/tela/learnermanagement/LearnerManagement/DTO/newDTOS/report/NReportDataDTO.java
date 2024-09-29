package com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.report;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NReportDataDTO {

    @NotBlank(message = "subject is required")
    @NotBlank(message = "subject is required")
    private String subject;

    @NotBlank(message = "comment is required")
    @NotBlank(message = "comment is required")
    private String comment;
    private double marks;

    @NotBlank(message = "teacher is required")
    @NotBlank(message = "teacher is required")
    private String teacher;
}
