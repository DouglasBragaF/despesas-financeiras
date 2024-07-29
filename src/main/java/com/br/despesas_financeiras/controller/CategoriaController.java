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

import com.br.despesas_financeiras.dtos.CategoriaDto;
import com.br.despesas_financeiras.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

  @Autowired
  private CategoriaService categoriaService;

  @GetMapping
  public ResponseEntity<List<CategoriaDto>> getAllCategorias() {
    List<CategoriaDto> categorias = categoriaService.findAll();
    return new ResponseEntity<>(categorias, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoriaDto> getCategoriaById(@PathVariable Long id) {
    Optional<CategoriaDto> categoria = categoriaService.findById(id);
    return categoria.map(ResponseEntity::ok)
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping
  public ResponseEntity<CategoriaDto> createCategoria(@RequestBody CategoriaDto categoriaDto) {
    CategoriaDto createdCategoria = categoriaService.create(categoriaDto);
    return new ResponseEntity<>(createdCategoria, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoriaDto> updateCategoria(@PathVariable Long id, @RequestBody CategoriaDto categoriaDto) {
    Optional<CategoriaDto> updatedCategoria = categoriaService.update(id, categoriaDto);
    return updatedCategoria.map(ResponseEntity::ok)
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
    if (categoriaService.delete(id)) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
