package com.planetsystem.tela.learnermanagement.LearnerManagement.controller;

import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.report.ReportDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.SystemResponseDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.report.NReportDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reports")
@CrossOrigin("*")
public class ReportController {
    final ReportService reportService;

    @PostMapping("/one")
    private SystemResponseDTO<Integer> save(@RequestBody NReportDTO dto){
        return reportService.save(dto);
    }

    @GetMapping("/search")
    private SystemResponseDTO<List<ReportDTO>> fetchList(@RequestParam Map<String , String> queryMap){
        return reportService.fetchList(queryMap);
    }
}
