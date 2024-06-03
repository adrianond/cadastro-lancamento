package com.br.cadastro.lancamento.database.repository;


import com.br.cadastro.lancamento.database.entity.Lancamento;

public interface LancamentoRepositoryFacade {
    Lancamento save(Lancamento lancamento);
}
