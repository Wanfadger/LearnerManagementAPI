package com.planetsystem.tela.learnermanagement.LearnerManagement.service;

import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.LearnerDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.report.ReportDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.SystemResponseDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.report.NReportDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.report.ReportDataDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Learner;
import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Report;
import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.ReportData;
import com.planetsystem.tela.learnermanagement.LearnerManagement.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ReportService {
    final ReportRepository reportRepository;

    public SystemResponseDTO<Integer> save(NReportDTO dto) {
        Learner build = Learner.builder().id(dto.getLearnerId()).build();
        Report report = Report.builder()
                .className(dto.getClassName())
                .classTeacher(dto.getClassTeacher())
                .comment(dto.getComment())
                .school(dto.getSchool())
                .schoolDistrict(dto.getSchoolDistrict())
                .term(dto.getTerm())
                .year(dto.getYear())
                .learner(build)
                .build();

        List<ReportData> reportDataList = dto.getReportData().parallelStream().map(dateDto -> {
            ReportData reportData = ReportData.builder()
                    .report(report)
                    .comment(dateDto.getComment())
                    .marks(dateDto.getMarks())
                    .subject(dateDto.getSubject())
                    .teacher(dateDto.getTeacher())
                    .build();
            return reportData;
        }).toList();

        report.setReportData(reportDataList);

        Report save = reportRepository.save(report);

        SystemResponseDTO<Integer> responseDTO = new SystemResponseDTO();
        responseDTO.setMessage("successfully saved");
        responseDTO.setStatus(true);
        responseDTO.setData(save.getId());

        return responseDTO;

    }

    public SystemResponseDTO<List<ReportDTO>> fetchList(Map<String, String> queryMap) {
        String termName = queryMap.get("termName");
        String yearName = queryMap.get("year");
        String className = queryMap.get("className");
        String schoolName = queryMap.get("schoolName");

        List<Report> reports = reportRepository.allByYear_Term_School_Class(yearName, termName, schoolName, className);
        List<ReportDTO> reportDTOS = reports.parallelStream().map(report -> {
            Learner learner = report.getLearner();
            ReportDTO dto = ReportDTO.builder()
                    .id(report.getId())
                    .comment(report.getComment())
                    .className(report.getClassName())
                    .classTeacher(report.getClassTeacher())
                    .school(report.getSchool())
                    .schoolDistrict(report.getSchoolDistrict())
                    .term(report.getTerm())
                    .year(report.getYear())
                    .learner(LearnerDTO.builder()
                            .gender(learner.getGender())
                            .school(learner.getSchool())
                            .firstName(learner.getFirstName())
                            .lastName(learner.getLastName())
                            .districtOfBirth(learner.getDistrictOfBirth())
                            .term(learner.getTerm())
                            .className(learner.getClassName())
                            .id(learner.getId())
                            .build())
                    .build();

            List<ReportDataDTO> reportDataDTOList = report.getReportData().parallelStream().map(reportData -> {
                ReportDataDTO reportDataDTO = ReportDataDTO.builder()
                        .id(reportData.getId())
                        .subject(reportData.getSubject())
                        .marks(reportData.getMarks())
                        .comment(reportData.getComment())
                        .teacher(reportData.getTeacher())
                        .reportId(report.getId())
                        .build();
                return reportDataDTO;
            }).toList();

            dto.setReportData(reportDataDTOList);

            return dto;
        }).toList();


        SystemResponseDTO<List<ReportDTO>> responseDTO = new SystemResponseDTO<>();
        responseDTO.setData(reportDTOS);
        responseDTO.setStatus(true);
        responseDTO.setMessage("success");

        return responseDTO;
    }
}
