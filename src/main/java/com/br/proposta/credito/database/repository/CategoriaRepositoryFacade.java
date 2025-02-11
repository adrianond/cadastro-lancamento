package com.br.proposta.credito.database.repository;


import com.br.proposta.credito.database.entity.Categoria;

public interface CategoriaRepositoryFacade {
    Categoria findById(Long id);
}
