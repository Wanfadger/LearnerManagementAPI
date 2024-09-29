package com.planetsystem.tela.learnermanagement.LearnerManagement.service;

import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.AttendanceDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.LearnerDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.SystemResponseDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.DTO.newDTOS.NAttendanceDTO;
import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Attendance;
import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Learner;
import com.planetsystem.tela.learnermanagement.LearnerManagement.repository.AttendanceRepository;
import com.planetsystem.tela.learnermanagement.LearnerManagement.utils.LearnerDatePattern;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
@Repository
@RequiredArgsConstructor
public class AttendanceService {
    final AttendanceRepository attendanceRepository;

    public SystemResponseDTO<List<Integer>> saveList(List<NAttendanceDTO> attendanceDTOS) {

        List<Attendance> attendanceList = attendanceDTOS.parallelStream().map(attendanceDTO -> {
            LocalDateTime localDateTime = LocalDateTime.parse(attendanceDTO.getAttendanceDateTime(), LearnerDatePattern.dateTimePattern24);
            Attendance attendance = Attendance.builder()
                    .attendanceStatus(attendanceDTO.isStatus())
                    .attendanceDate(localDateTime.toLocalDate())
                    .attendanceTime(localDateTime.toLocalTime())
                    .comment(attendanceDTO.getComment())
                    .learner(new Learner(attendanceDTO.getLearnerId()))
                    .className(attendanceDTO.getClassName())
                    .school(attendanceDTO.getSchool())
                    .schoolDistrict(attendanceDTO.getSchoolDistrict())
                    .term(attendanceDTO.getTerm())
                    .year(attendanceDTO.getYear())
                    .build();

            return attendance;
        }).toList();

        List<Attendance> savedList = attendanceRepository.saveAll(attendanceList);

        List<Integer> ids = savedList.parallelStream().map(Attendance::getId).toList();
        SystemResponseDTO<List<Integer>> responseDTO = new SystemResponseDTO<>();
        responseDTO.setMessage("successfully persisted");
        responseDTO.setData(ids);
        responseDTO.setStatus(true);

        return responseDTO;
    }

    public SystemResponseDTO<List<AttendanceDTO>> fetchList(Map<String, String> queryMap) {
        String date = queryMap.get("date");
        String className = queryMap.get("className");
        String schoolName = queryMap.get("school");
        String termName = queryMap.get("term");
        String yearName = queryMap.get("year");

        System.out.println("fetchList "+ queryMap);
        LocalDate localDate = LocalDate.parse(date, LearnerDatePattern.datePattern);
        List<Attendance> allByAttendanceDateTime_date = attendanceRepository.findAllByYearIgnoreCaseAndTermIgnoreCaseAndSchoolIgnoreCaseAndClassNameIgnoreCaseAndAttendanceDate
                (yearName ,termName , schoolName ,className , localDate);

        List<AttendanceDTO> attendanceDTOS = allByAttendanceDateTime_date.parallelStream().map(attendance -> {
            LocalDateTime localDateTime = LocalDateTime.of(attendance.getAttendanceDate(), attendance.getAttendanceTime());

            Learner learner = attendance.getLearner();
            AttendanceDTO dto = AttendanceDTO.builder()
                    .learner(LearnerDTO.builder().id(learner.getId())
                            .className(learner.getClassName())
                            .school(learner.getSchool())
                            .districtOfBirth(learner.getDistrictOfBirth())
                            .firstName(learner.getFirstName())
                            .lastName(learner.getLastName())
                            .gender(learner.getGender())
                            .term(learner.getTerm())
                            .build())
                    .attendanceDateTime(localDateTime.format(LearnerDatePattern.dateTimePattern24))
                    .status(attendance.isAttendanceStatus())
                    .id(attendance.getId())
                    .comment(attendance.getComment())
                    .build();

            return dto;
        }).toList();

        SystemResponseDTO<List<AttendanceDTO>> responseDTO = new SystemResponseDTO<>();
        responseDTO.setStatus(true);
        responseDTO.setData(attendanceDTOS);
        responseDTO.setMessage("successfully done");
        return responseDTO;
    }
}
