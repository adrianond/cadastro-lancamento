package com.br.cadastro.lancamento.usecase;


import com.br.cadastro.lancamento.database.repository.LancamentoDespesaRepositoryFacade;
import com.br.cadastro.lancamento.http.domain.builder.LancamentoDespesaBuilder;
import com.br.cadastro.lancamento.http.domain.dto.LancamentoCsvDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CadastraLancamentoDespesa {

  private final LancamentoDespesaRepositoryFacade lancamentoDespesaRepositoryFacade;
  private final LancamentoDespesaBuilder lancamentoDespesaBuilder;

    public void executar(LancamentoCsvDto lancamentoCsvDto) {
        lancamentoDespesaRepositoryFacade.save(lancamentoDespesaBuilder.fromDtoToEntity(lancamentoCsvDto));
    }
}
