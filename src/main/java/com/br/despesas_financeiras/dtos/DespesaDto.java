package com.br.despesas_financeiras.dtos;

import com.br.despesas_financeiras.models.Despesa;

public record DespesaDto(
    Long id, String descricao, String prestador, Double valorTitulo, String dataVencimento,
    CategoriaDto categoria, String dataPagamento, Double valorPago) {

  public static DespesaDto toDto(Despesa despesa) {
    return new DespesaDto(
        despesa.getId(),
        despesa.getDescricao(),
        despesa.getPrestador(),
        despesa.getValorTitulo(),
        despesa.getDataVencimento(),
        CategoriaDto.toDto(despesa.getCategoria()),
        despesa.getDataPagamento(),
        despesa.getValorPago());
  }

  public static Despesa toEntity(DespesaDto despesaDto) {
    Despesa despesa = new Despesa();
    despesa.setId(despesaDto.id());
    despesa.setDescricao(despesaDto.descricao());
    despesa.setPrestador(despesaDto.prestador());
    despesa.setValorTitulo(despesaDto.valorTitulo());
    despesa.setDataVencimento(despesaDto.dataVencimento());
    despesa.setCategoria(CategoriaDto.toEntity(despesaDto.categoria()));
    despesa.setDataPagamento(despesaDto.dataPagamento());
    despesa.setValorPago(despesaDto.valorPago());
    return despesa;
  }

}
