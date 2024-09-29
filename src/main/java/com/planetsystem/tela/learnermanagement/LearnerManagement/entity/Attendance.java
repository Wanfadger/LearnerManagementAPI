package com.planetsystem.tela.learnermanagement.LearnerManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private LocalTime attendanceTime;

    @Column(nullable = false)
    private LocalDate attendanceDate;

    @Column(nullable = false)
    private String comment;


    private boolean attendanceStatus;

    @Column(nullable = false)
    private String className;

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

}
