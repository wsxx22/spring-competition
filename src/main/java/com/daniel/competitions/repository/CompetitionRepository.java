package com.daniel.competitions.repository;

import com.daniel.competitions.entity.Competition;
import com.daniel.competitions.specification.CompetitionSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, Long>, JpaSpecificationExecutor<Competition> {


    List<Competition> findByDateLike (LocalDate date);


}
