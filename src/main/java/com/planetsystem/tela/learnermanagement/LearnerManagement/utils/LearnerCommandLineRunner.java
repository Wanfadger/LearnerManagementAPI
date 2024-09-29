package com.planetsystem.tela.learnermanagement.LearnerManagement.utils;

import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.report.NReportDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.report.NReportDataDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.report.ReportDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.report.ReportDataDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.service.AttendanceService;
import com.planetsystem.tela.learnermanagement.LearnerManagement.service.LearnerService;
import com.planetsystem.tela.learnermanagement.LearnerManagement.service.ReportService;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class LearnerCommandLineRunner implements CommandLineRunner {

    private final LearnerService learnerService;
    final AttendanceService attendanceService;

    final ReportService reportService;

    @Override
    public void run(String... args) throws Exception {
//        SystemResponseDTO<List<Integer>> responseDTO = learnerService.saveList(List.of(NLearnerDTO.builder()
//                .className("P.1")
//                .districtOfBirth("Mpigi")
//                .term("Term II")
//                .firstName("first name")
//                .lastName("last name")
//                .schoolDistrict("Kampala")
//                .gender("male")
//                .school("Kabowa parents primary school")
//                .build()));

        LocalDate localDate = LocalDate.parse("29/09/2024", LearnerDatePattern.datePattern);
        LocalTime localTime = LocalTime.of(12, 35);

//        SystemResponseDTO<List<Integer>> responseDTO = attendanceService.saveList(List.of(NAttendanceDTO.builder()
//                .learnerId(1)
//                .comment("comment")
//                .term("Term II")
//                .school("Kabowa parents primary school")
//                .schoolDistrict("Kampala")
//                .attendanceDateTime(LocalDateTime.of(localDate, localTime).format(LearnerDatePattern.dateTimePattern24))
//                .className("P.1")
//                .status(true)
//                .build()));




        NReportDTO reportDTO = NReportDTO.builder()
                .learnerId(1)
                .comment("comment")
                .className("P.1")
                .classTeacher("class teacher")
                .school("Kabowa parents primary school")
                .schoolDistrict("Kampala")
                .term("Term II")
                .build();


        NReportDataDTO nReportDataDTO = NReportDataDTO.builder()
                .subject("MTC")
                .comment("comment")
                .marks(70)
                .teacher("teacher")
                .build();
        reportDTO.setReportData(List.of(nReportDataDTO));


        NReportDTO nReportDTO = reportDTO;
//        reportService.save(nReportDTO);

        System.out.println(learnerService.fetchList(Map.of("schoolName", "Kabowa parents primary school", "className", "P.1", "termName", "term II")));
        System.out.println(attendanceService.fetchList(Map.of( "date" , "29/09/2024" ,"schoolName", "Kabowa parents primary school", "className", "P.1", "termName", "Term II")));
        System.out.println(reportService.fetchList(Map.of( "date" , "29/09/2024" ,"schoolName", "Kabowa parents primary school", "className", "P.1", "termName", "Term II")));

        ReportDTO reportDTO1 = new ReportDTO();
        reportDTO1.setReportData(List.of(new ReportDataDTO()));
        System.out.println(reportDTO1);
    }
}
