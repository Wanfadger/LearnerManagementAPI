package com.planetsystem.tela.learnermanagement.LearnerManagement.service;

import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.LearnerDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.SystemResponseDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.NLearnerDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Learner;
import com.planetsystem.tela.learnermanagement.LearnerManagement.repository.LearnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LearnerService {
    final LearnerRepository learnerRepository;

    public SystemResponseDTO<List<Integer>> saveList(List<NLearnerDTO> learners) {
        List<Learner> learnerList = learners.parallelStream().map(learnerDTO -> {
            Learner learner = Learner.builder()
                    .className(learnerDTO.getClassName())
                    .districtOfBirth(learnerDTO.getDistrictOfBirth())
                    .firstName(learnerDTO.getFirstName())
                    .lastName(learnerDTO.getLastName())
                    .school(learnerDTO.getSchool())
                    .schoolDistrict(learnerDTO.getSchoolDistrict())
                    .term(learnerDTO.getTerm())
                    .gender(learnerDTO.getGender())
                    .year(learnerDTO.getYear())
                    .build();
            return learner;
        }).toList();

        List<Integer> ids = learnerRepository.saveAll(learnerList).parallelStream().map(Learner::getId).toList();

        SystemResponseDTO<List<Integer>> stringSystemResponseDTO = new SystemResponseDTO<>();
        stringSystemResponseDTO.setData(ids);
        stringSystemResponseDTO.setStatus(true);
        stringSystemResponseDTO.setMessage("successfully added");
        return stringSystemResponseDTO;
    }



    public SystemResponseDTO<List<LearnerDTO>> fetchList(Map<String , String> queryMap) {

        System.out.println("queryMap "+ queryMap);
        String schoolClass = queryMap.get("className");
        String term = queryMap.get("termName");
        String year = queryMap.get("year");
        String school = queryMap.get("schoolName");

        List<Learner> learners = learnerRepository.allByYear_Term_School_Class(year , term,school, schoolClass);

        List<LearnerDTO> learnerDTOS = learners.parallelStream().map(learner -> {
            LearnerDTO dto = LearnerDTO.builder()
                    .className(learner.getClassName())
                    .school(learner.getSchool())
                    .districtOfBirth(learner.getDistrictOfBirth())
                    .firstName(learner.getFirstName())
                    .lastName(learner.getLastName())
                    .gender(learner.getGender())
                    .id(learner.getId())
                    .term(learner.getTerm())
                    .build();
            return dto;
        }).toList();


        SystemResponseDTO<List<LearnerDTO>> responseDTO = new SystemResponseDTO<>();
        responseDTO.setData(learnerDTOS);
        responseDTO.setStatus(true);
        responseDTO.setMessage("successfully added");
        return responseDTO;
    }



}
