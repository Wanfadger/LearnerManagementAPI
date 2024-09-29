package com.planetsystem.tela.learnermanagement.LearnerManagement.repository;

import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {

    @Query("""
            SELECT R FROM Report AS R
            JOIN FETCH R.learner AS L
            JOIN FETCH R.reportData AS RD
            where LOWER(R.year) = LOWER(:yearName) AND LOWER(R.term) = LOWER(:termName) AND Lower(R.school) = LOWER(:schoolName) AND LOWER(R.className) = LOWER(:className)
            """)
    List<Report> allByYear_Term_School_Class(String yearName ,  String termName, String schoolName, String className);

}
