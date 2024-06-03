package com.br.cadastro.lancamento.database.repository.impl;


import com.br.cadastro.lancamento.database.entity.Lancamento;
import com.br.cadastro.lancamento.database.repository.LancamentoRepositoryFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LancamentoRepositoryFacadeImpl implements LancamentoRepositoryFacade {

    private final LancamentoRepository repository;


    @Override
    public Lancamento save(Lancamento lancamento) {
        return repository.save(lancamento);
    }

}
