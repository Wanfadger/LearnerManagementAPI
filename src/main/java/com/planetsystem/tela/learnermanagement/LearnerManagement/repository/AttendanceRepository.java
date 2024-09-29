package com.planetsystem.tela.learnermanagement.LearnerManagement.repository;

import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Attendance;
import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Learner;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    List<Attendance> findAllByAttendanceDate(LocalDate attendanceDate);

    @EntityGraph(attributePaths = {"learner"} ,type = EntityGraph.EntityGraphType.FETCH)
    List<Attendance> findAllByYearIgnoreCaseAndTermIgnoreCaseAndSchoolIgnoreCaseAndClassNameIgnoreCaseAndAttendanceDate(String year , String term , String schoolName , String className , LocalDate attendanceDate);

}
