package com.br.despesas_financeiras.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.despesas_financeiras.dtos.CategoriaDto;
import com.br.despesas_financeiras.dtos.DespesaDto;
import com.br.despesas_financeiras.models.Despesa;
import com.br.despesas_financeiras.repository.DespesaRepository;

@Service
public class DespesaService {

  @Autowired
  private DespesaRepository despesaRepository;

  public List<DespesaDto> findAll() {
    return despesaRepository.findAll().stream()
        .map(DespesaDto::toDto)
        .collect(Collectors.toList());
  }

  public Optional<DespesaDto> findById(Long id) {
    return despesaRepository.findById(id)
        .map(DespesaDto::toDto);
  }

  public DespesaDto create(DespesaDto despesaDto) {
    Despesa despesa = DespesaDto.toEntity(despesaDto);
    despesa = despesaRepository.save(despesa);
    return DespesaDto.toDto(despesa);
  }

  public Optional<DespesaDto> update(Long id, DespesaDto despesaDto) {
    return despesaRepository.findById(id)
        .map(despesa -> {
          despesa.setDescricao(despesaDto.descricao());
          despesa.setPrestador(despesaDto.prestador());
          despesa.setValorTitulo(despesaDto.valorTitulo());
          despesa.setDataVencimento(despesaDto.dataVencimento());
          despesa.setCategoria(CategoriaDto.toEntity(despesaDto.categoria()));
          despesa.setDataPagamento(despesaDto.dataPagamento());
          despesa.setValorPago(despesaDto.valorPago());
          despesaRepository.save(despesa);
          return DespesaDto.toDto(despesa);
        });
  }

  public boolean delete(Long id) {
    if (despesaRepository.existsById(id)) {
      despesaRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
