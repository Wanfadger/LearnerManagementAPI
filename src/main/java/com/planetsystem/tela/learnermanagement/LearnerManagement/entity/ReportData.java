package com.planetsystem.tela.learnermanagement.LearnerManagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReportData {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String subject;

    private String comment;

    @Column(nullable = false)
    private double marks;

    @Column(nullable = false)
    private String teacher;

    @ManyToOne(targetEntity = Report.class)
    @JoinColumn(nullable = false)
    private Report report;
}
