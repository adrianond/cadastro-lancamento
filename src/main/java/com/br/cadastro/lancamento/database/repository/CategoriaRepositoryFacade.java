package com.br.cadastro.lancamento.database.repository;


import com.br.cadastro.lancamento.database.entity.Categoria;

public interface CategoriaRepositoryFacade {
    Categoria findById(Long id);
}
