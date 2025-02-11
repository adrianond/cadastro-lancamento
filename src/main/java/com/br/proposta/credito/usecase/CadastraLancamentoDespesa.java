package com.br.proposta.credito.usecase;


import com.br.proposta.credito.database.repository.LancamentoDespesaRepositoryFacade;
import com.br.proposta.credito.http.domain.builder.LancamentoDespesaBuilder;
import com.br.proposta.credito.http.domain.dto.LancamentoCsvDto;
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
