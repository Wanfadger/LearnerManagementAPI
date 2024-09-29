package com.planetsystem.tela.learnermanagement.LearnerManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Report {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String className;

    @Column(nullable = false)
    private String classTeacher;

    @Column(nullable = false)
    private String school;

    @Column(nullable = false)
    private String schoolDistrict;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String term;

    @ManyToOne(targetEntity = Learner.class)
    @JoinColumn(nullable = false)
    private Learner learner;

    @OneToMany(targetEntity = ReportData.class , mappedBy = "report" , cascade = {CascadeType.PERSIST})
    private List<ReportData> reportData;

}
