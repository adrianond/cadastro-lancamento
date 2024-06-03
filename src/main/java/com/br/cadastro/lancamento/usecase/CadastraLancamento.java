package com.br.cadastro.lancamento.usecase;


import com.br.cadastro.lancamento.database.repository.LancamentoRepositoryFacade;
import com.br.cadastro.lancamento.http.domain.builder.LancamentoBuilder;
import com.br.cadastro.lancamento.http.domain.dto.LancamentoCsvDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CadastraLancamento {

  private final LancamentoRepositoryFacade lancamentoRepositoryFacade;
  private final LancamentoBuilder lancamentoBuilder;

    public void executar(LancamentoCsvDto lancamentoCsvDto) {
        lancamentoRepositoryFacade.save(lancamentoBuilder.fromDtoToEntity(lancamentoCsvDto));
    }
}
