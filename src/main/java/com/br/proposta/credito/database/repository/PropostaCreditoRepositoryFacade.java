package com.br.proposta.credito.database.repository;

import com.br.proposta.credito.database.type.PropostaCreditoType;

import java.sql.SQLException;

public interface PropostaCreditoRepositoryFacade {
    PropostaCreditoType salvar(PropostaCreditoType propostaCreditoType) throws SQLException;
}
