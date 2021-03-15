package com.javamos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javamos.model.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer>{
	List<Conta> findByUsuarioId(Integer id);
}
