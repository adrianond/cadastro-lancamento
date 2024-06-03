package com.br.cadastro.lancamento.database.repository;


import com.br.cadastro.lancamento.database.entity.Pessoa;

public interface PessoaRepositoryFacade {
    Pessoa findById(Long id);
}
