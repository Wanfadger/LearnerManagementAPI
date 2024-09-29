package com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.report;

import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Learner;
import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.ReportData;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NReportDTO {

    @NotBlank(message = "comment is required")
    @NotBlank(message = "comment is required")
    private String comment;


    @NotBlank(message = "className is required")
    @NotBlank(message = "className is required")
    private String className;


    @NotBlank(message = "classTeacher is required")
    @NotBlank(message = "classTeacher is required")
    private String classTeacher;

    @NotBlank(message = "school is required")
    @NotBlank(message = "school is required")
    private String school;


    @NotBlank(message = "schoolDistrict is required")
    @NotBlank(message = "schoolDistrict is required")
    private String schoolDistrict;

    @NotBlank(message = "year is required")
    @NotBlank(message = "year is required")
    private String year;

    @NotBlank(message = "term is required")
    @NotBlank(message = "term is required")
    private String term;

    @NotBlank(message = "learnerId is required")
    @NotBlank(message = "learnerId is required")
    private int learnerId;

    private List<NReportDataDTO> reportData;
}
