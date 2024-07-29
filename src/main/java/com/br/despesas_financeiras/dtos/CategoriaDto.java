package com.br.despesas_financeiras.dtos;

import com.br.despesas_financeiras.models.Categoria;

public record CategoriaDto(Long id, String descricao) {

  public static CategoriaDto toDto(Categoria categoria) {
    return new CategoriaDto(categoria.getId(), categoria.getDescricao());
  }

  public static Categoria toEntity(CategoriaDto categoriaDto) {
    Categoria categoria = new Categoria();
    categoria.setId(categoriaDto.id());
    categoria.setDescricao(categoriaDto.descricao());
    return categoria;
  }
}
