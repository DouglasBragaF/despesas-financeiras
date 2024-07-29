package com.br.despesas_financeiras.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.despesas_financeiras.dtos.CategoriaDto;
import com.br.despesas_financeiras.models.Categoria;
import com.br.despesas_financeiras.repository.CategoriaRepository;

@Service
public class CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  public List<CategoriaDto> findAll() {
    return categoriaRepository.findAll().stream()
        .map(CategoriaDto::toDto)
        .collect(Collectors.toList());
  }

  public Optional<CategoriaDto> findById(Long id) {
    return categoriaRepository.findById(id)
        .map(CategoriaDto::toDto);
  }

  public CategoriaDto create(CategoriaDto categoriaDto) {
    Categoria categoria = CategoriaDto.toEntity(categoriaDto);
    categoria = categoriaRepository.save(categoria);
    return CategoriaDto.toDto(categoria);
  }

  public Optional<CategoriaDto> update(Long id, CategoriaDto categoriaDto) {
    return categoriaRepository.findById(id)
        .map(categoria -> {
          categoria.setDescricao(categoriaDto.descricao());
          categoria = categoriaRepository.save(categoria);
          return CategoriaDto.toDto(categoria);
        });
  }

  public boolean delete(Long id) {
    if (categoriaRepository.existsById(id)) {
      categoriaRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
