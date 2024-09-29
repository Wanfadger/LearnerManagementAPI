package com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.report;

import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Report;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReportDataDTO {
    private Integer id;
    private String subject;
    private String comment;
    private double marks;
    private String teacher;
    private Integer reportId;
}
