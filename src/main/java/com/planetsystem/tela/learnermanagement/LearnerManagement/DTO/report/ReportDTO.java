package com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.report;

import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.LearnerDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportDTO {
    private Integer id;
    private String comment;
    private String className;
    private String classTeacher;
    private String school;
    private String schoolDistrict;
    private String term;
    private String year;
    private LearnerDTO learner;

    private List<ReportDataDTO> reportData;


}
