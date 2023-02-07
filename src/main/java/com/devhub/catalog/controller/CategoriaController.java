package com.devhub.catalog.controller;

import com.devhub.catalog.model.Categoria;
import com.devhub.catalog.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/categoria")
public class CategoriaController {


   @Autowired
   public CategoriaService categoriaService;

   @PostMapping
   public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria){

        Categoria category =categoriaService.criarCategoria(categoria);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(categoria.getId())
                .toUri();
        return ResponseEntity.created(uri).body(category);
    }

}
