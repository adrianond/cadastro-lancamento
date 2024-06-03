package com.br.cadastro.lancamento.database.repository.impl;

import com.br.cadastro.lancamento.database.entity.Pessoa;
import com.br.cadastro.lancamento.database.repository.PessoaRepositoryFacade;
import com.br.cadastro.lancamento.exception.PessoaNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PessoaRepositoryFacadeImpl implements PessoaRepositoryFacade {
    private final PessoaRepository repository;

    @Override
    public Pessoa findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada"));
    }
}
