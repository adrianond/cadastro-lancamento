package com.br.proposta.credito.usecase;

import com.br.proposta.credito.database.repository.PropostaCreditoRepositoryFacade;
import com.br.proposta.credito.database.type.PropostaCreditoType;
import com.br.proposta.credito.http.Converter.PropostaCreditoConverter;
import com.br.proposta.credito.http.domain.dto.PropostaCreditoDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@AllArgsConstructor
@Slf4j
public class SalvaPropostaCredito {
    private final PropostaCreditoRepositoryFacade propostaCreditoRepositoryFacade;
    private final PropostaCreditoConverter propostaCreditoConverter;

    public PropostaCreditoDto executar(PropostaCreditoDto propostaCreditoDto) {


        try {
            PropostaCreditoType propostaCreditoType =  propostaCreditoRepositoryFacade
                    .salvar(propostaCreditoConverter.toEntity(propostaCreditoDto));

            return propostaCreditoConverter.toDto(propostaCreditoType);
        } catch (SQLException e) {
            log.error("Ocorreu erro ao salvar proposta de credito", e);
            throw new RuntimeException(e);
        }
    }


}
