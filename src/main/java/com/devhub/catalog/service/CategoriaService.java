package com.devhub.catalog.service;

import com.devhub.catalog.model.Categoria;
import com.devhub.catalog.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;


    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
