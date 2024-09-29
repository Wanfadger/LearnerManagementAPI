package com.planetsystem.tela.learnermanagement.LearnerManagement.DTO;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LearnerDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String className;
    private String school;
    private String schoolDistrict;
    private String districtOfBirth;
    private String term;
    private String gender;

}
