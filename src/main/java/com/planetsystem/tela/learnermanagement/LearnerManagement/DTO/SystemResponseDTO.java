package com.planetsystem.tela.learnermanagement.LearnerManagement.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SystemResponseDTO<T> {
    T data;
    String message;
    boolean status;

}
