package com.br.despesas_financeiras.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.despesas_financeiras.dtos.DespesaDto;
import com.br.despesas_financeiras.service.DespesaService;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

  @Autowired
  private DespesaService despesaService;

  @GetMapping
  public ResponseEntity<List<DespesaDto>> getAllDespesas() {
    List<DespesaDto> despesas = despesaService.findAll();
    return new ResponseEntity<>(despesas, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DespesaDto> getDespesaById(@PathVariable Long id) {
    Optional<DespesaDto> despesa = despesaService.findById(id);
    return despesa.map(ResponseEntity::ok)
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<DespesaDto> createDespesa(@RequestBody DespesaDto despesaDto) {
    DespesaDto createdDespesa = despesaService.create(despesaDto);
    return new ResponseEntity<>(createdDespesa, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<DespesaDto> updateDespesa(@PathVariable Long id, @RequestBody DespesaDto despesaDto) {
    Optional<DespesaDto> updatedDespesa = despesaService.update(id, despesaDto);
    return updatedDespesa.map(ResponseEntity::ok)
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteDespesa(@PathVariable Long id) {
    if (despesaService.delete(id)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
