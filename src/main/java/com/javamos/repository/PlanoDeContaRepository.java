package com.javamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javamos.model.PlanoDeConta;

@Repository
public interface PlanoDeContaRepository extends JpaRepository<PlanoDeConta, Integer>{  
    
}
