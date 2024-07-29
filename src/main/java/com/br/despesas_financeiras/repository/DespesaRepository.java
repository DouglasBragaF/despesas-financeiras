package com.br.despesas_financeiras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.despesas_financeiras.models.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

}
