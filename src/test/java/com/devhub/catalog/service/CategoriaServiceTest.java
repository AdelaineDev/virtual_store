package com.devhub.catalog.service;

import com.devhub.catalog.model.Categoria;
import com.devhub.catalog.repository.CategoriaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Calendar;
import java.util.Date;


import static org.mockito.Mockito.*;

@SpringBootTest
public class CategoriaServiceTest {
    @Mock
    public CategoriaRepository categoriaRepository;

    @InjectMocks
    public CategoriaService categoriaService;


    @Test
    public void deveValidarACriacaoDeUmmaCategoria(){

        Categoria categoria = new Categoria();
        categoria.setId(2L);
        categoria.setName("Eletronicos");
        categoria.setCreatedAt(new Date(2019, Calendar.JANUARY, 18).toInstant());

        categoriaService.criarCategoria(categoria);
        when(categoriaService.criarCategoria(categoria)).thenReturn(categoria);

        Assertions.assertThat(categoria.getId()).isEqualTo(2);
        Assertions.assertThat(categoria.getName()).isEqualTo("Eletronicos");
        Assertions.assertThat(categoria.getCreatedAt()).isEqualTo(new  Date(2019, Calendar.JANUARY, 18).toInstant());
        verify(categoriaRepository).save(categoria);


    }

}
