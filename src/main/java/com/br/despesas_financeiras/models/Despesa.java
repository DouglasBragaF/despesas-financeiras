package com.br.despesas_financeiras.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Despesa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String descricao;

  private String prestador;

  @Column(name = "valor_titulo")
  private Double valorTitulo;

  @Column(name = "data_vencimento")
  private String dataVencimento;

  @ManyToOne
  @JoinColumn(name = "id_categoria", nullable = false)
  private Categoria categoria;

  @Column(name = "data_pagamento")
  private String dataPagamento;

  @Column(name = "valor_pago")
  private Double valorPago;

  public Despesa() {
  }

  public Despesa(Long id, String descricao, String prestador, Double valorTitulo, String dataVencimento,
      Categoria categoria, String dataPagamento, Double valorPago) {
    this.id = id;
    this.descricao = descricao;
    this.prestador = prestador;
    this.valorTitulo = valorTitulo;
    this.dataVencimento = dataVencimento;
    this.categoria = categoria;
    this.dataPagamento = dataPagamento;
    this.valorPago = valorPago;
  }

  public Long getId() {
    return id;
  }

  public String getDescricao() {
    return descricao;
  }

  public String getPrestador() {
    return prestador;
  }

  public Double getValorTitulo() {
    return valorTitulo;
  }

  public String getDataVencimento() {
    return dataVencimento;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public String getDataPagamento() {
    return dataPagamento;
  }

  public Double getValorPago() {
    return valorPago;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public void setPrestador(String prestador) {
    this.prestador = prestador;
  }

  public void setValorTitulo(Double valorTitulo) {
    this.valorTitulo = valorTitulo;
  }

  public void setDataVencimento(String dataVencimento) {
    this.dataVencimento = dataVencimento;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public void setDataPagamento(String dataPagamento) {
    this.dataPagamento = dataPagamento;
  }

  public void setValorPago(Double valorPago) {
    this.valorPago = valorPago;
  }

}
