package com.planetsystem.tela.learnermanagement.LearnerManagement.controller;

import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.LearnerDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.SystemResponseDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.NLearnerDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.service.LearnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/learners")
@CrossOrigin("*")
public class LearnerController {

    private final LearnerService learnerService;

    @PostMapping("/list")
    private SystemResponseDTO<List<Integer>> saveList(@RequestBody List<NLearnerDTO> learners){
        return learnerService.saveList(learners);
    }

    @GetMapping("/search")
    private SystemResponseDTO<List<LearnerDTO>> fetchList(@RequestParam Map<String , String> queryMap){
        return learnerService.fetchList(queryMap);
    }

}
