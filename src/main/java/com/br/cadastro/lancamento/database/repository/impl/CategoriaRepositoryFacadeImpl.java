package com.br.cadastro.lancamento.database.repository.impl;


import com.br.cadastro.lancamento.database.entity.Categoria;
import com.br.cadastro.lancamento.database.repository.CategoriaRepositoryFacade;
import com.br.cadastro.lancamento.exception.CategoriaNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoriaRepositoryFacadeImpl implements CategoriaRepositoryFacade {
    private final CategoriaRepository repository;

    @Override
    public Categoria findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new CategoriaNotFoundException(String.format("Categoria não encontrada para o id %s:", id)));
    }
}
