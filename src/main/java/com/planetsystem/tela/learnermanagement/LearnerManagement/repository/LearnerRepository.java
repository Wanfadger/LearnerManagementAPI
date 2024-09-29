package com.planetsystem.tela.learnermanagement.LearnerManagement.repository;

import com.planetsystem.tela.learnermanagement.LearnerManagement.entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Integer> {

    @Query("""
            SELECT L FROM Learner  AS L
            WHERE L.term = :term  AND L.className =:schoolClass
            """)
    List<Learner> allByTerm_class(String term, String schoolClass);

//    lower(u.name) like lower(concat('%', ?1,'%'))

//    @Query("""
//            SELECT L FROM Learner  AS L
//            WHERE LOWER(L.term) = LOWER(:term) AND LOWER(L.school) = LOWER(:school)  AND LOWER(L.className) =LOWER(:schoolClass)
//            """)
//    List<Learner> allByTerm_School_Class(String term,String school , String schoolClass);

    @Query("""
            SELECT L FROM Learner  AS L
            WHERE LOWER(L.year) = LOWER(:year) AND LOWER(L.term) = LOWER(:term) AND LOWER(L.school) = LOWER(:school)  AND LOWER(L.className) =LOWER(:schoolClass)
            """)
    List<Learner> allByYear_Term_School_Class(String year , String term,String school , String schoolClass);
}
