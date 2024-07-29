package com.br.despesas_financeiras.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.despesas_financeiras.models.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
