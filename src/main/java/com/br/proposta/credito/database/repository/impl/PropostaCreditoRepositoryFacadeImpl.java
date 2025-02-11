package com.br.proposta.credito.database.repository.impl;

import com.br.proposta.credito.database.repository.PropostaCreditoRepositoryFacade;
import com.br.proposta.credito.database.type.PropostaCreditoType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@AllArgsConstructor
public class PropostaCreditoRepositoryFacadeImpl implements PropostaCreditoRepositoryFacade {
    private final PropostaCreditoRepository propostaCreditoRepository;
    public PropostaCreditoType salvar(PropostaCreditoType propostaCreditoType) throws SQLException {
        return propostaCreditoRepository.salvarPropostaCredito(propostaCreditoType);
    }
}
