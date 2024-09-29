package com.planetsystem.tela.learnermanagement.LearnerManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity()
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Learner {
    @Id()
    @GeneratedValue()
    private int id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String className;

    @Column(nullable = false)
    private String school;

    @Column(nullable = false)
    private String schoolDistrict;

    private String districtOfBirth;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private String gender;

    private String lin;
    private String nin;

    @OneToMany(targetEntity = Attendance.class , mappedBy = "learner")
    private List<Attendance> attendances;

    @OneToMany(targetEntity = Attendance.class , mappedBy = "learner")
    private List<Report> reports;

    public Learner(int id) {
        this.id = id;
    }
}
