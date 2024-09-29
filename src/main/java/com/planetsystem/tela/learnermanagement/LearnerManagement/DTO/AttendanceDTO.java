package com.planetsystem.tela.learnermanagement.LearnerManagement.DTO;


import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AttendanceDTO {
    private Integer id;
    private LearnerDTO learner;
    private String attendanceDateTime;
    private boolean status;
    private String comment;
}
