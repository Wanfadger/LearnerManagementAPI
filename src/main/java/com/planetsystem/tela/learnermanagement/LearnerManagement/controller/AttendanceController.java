package com.planetsystem.tela.learnermanagement.LearnerManagement.controller;

import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.AttendanceDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.LearnerDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.SystemResponseDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.NAttendanceDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendances")
@CrossOrigin("*")
public class AttendanceController {

    final AttendanceService attendanceService;


    @PostMapping("/list")
    private SystemResponseDTO<List<Integer>> saveList(@RequestBody List<NAttendanceDTO> attendanceDTOS){
        return attendanceService.saveList(attendanceDTOS);
    }

    @GetMapping("/search")
    private SystemResponseDTO<List<AttendanceDTO>> fetchList(@RequestParam Map<String , String> queryMap){
        return attendanceService.fetchList(queryMap);
    }

}
