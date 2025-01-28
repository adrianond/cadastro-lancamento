package com.br.cadastro.lancamento.database.repository.impl;

import com.br.cadastro.lancamento.database.repository.PropostaCreditoRepositoryFacade;
import com.br.cadastro.lancamento.database.type.PropostaCreditoType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PropostaCreditoRepositoryFacadeImpl implements PropostaCreditoRepositoryFacade {
    private final PropostaCreditoRepository propostaCreditoRepository;
    public void salvar(PropostaCreditoType propostaCreditoType) {
        propostaCreditoRepository.salvarPropostaCredito(propostaCreditoType);
    }
}
