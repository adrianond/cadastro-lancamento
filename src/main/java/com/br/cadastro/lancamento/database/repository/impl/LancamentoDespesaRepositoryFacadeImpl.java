package com.br.cadastro.lancamento.database.repository.impl;


import com.br.cadastro.lancamento.database.entity.LancamentoDespesa;
import com.br.cadastro.lancamento.database.repository.LancamentoDespesaRepositoryFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class LancamentoDespesaRepositoryFacadeImpl implements LancamentoDespesaRepositoryFacade {

    private final LancamentoDespesaRepository repository;


    @Override
    public LancamentoDespesa save(LancamentoDespesa lancamentoDespesa) {
        return repository.save(lancamentoDespesa);
    }

}
