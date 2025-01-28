package com.br.cadastro.lancamento.usecase;

import com.br.cadastro.lancamento.database.repository.PropostaCreditoRepositoryFacade;
import com.br.cadastro.lancamento.database.type.PropostaCreditoType;
import com.br.cadastro.lancamento.http.domain.dto.PropostaCreditoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SalvaPropostaCredito {
    private final PropostaCreditoRepositoryFacade propostaCreditoRepositoryFacade;

    public void executar(PropostaCreditoDto propostaCreditoDto) {

        PropostaCreditoType type = PropostaCreditoType.builder()
                .produto(propostaCreditoDto.getProduto())
                .build();

        propostaCreditoRepositoryFacade.salvar(type);
    }
}
