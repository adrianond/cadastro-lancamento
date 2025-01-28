package com.br.cadastro.lancamento.database.repository.impl;

import com.br.cadastro.lancamento.database.type.PropostaCreditoType;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

@Repository
@AllArgsConstructor
public class PropostaCreditoRepository {
    private final JdbcTemplate jdbcTemplate;

    public void salvarPropostaCredito(PropostaCreditoType propostaCreditoType) {
        jdbcTemplate.execute((Connection connection) -> {
            try {
                var structPropostaType = propostaCreditoType.toStruct(connection);
                var callableStatement = connection.prepareCall("{call pck_proposta_credito.prc_cria_proposta}");
                callableStatement.setObject(1, structPropostaType, Types.STRUCT);
                callableStatement.execute();
            } catch (SQLException exception) {
                throw new RuntimeException("Erro ao chamar a procedure", exception);
            }
            return null;
        });

    }
}
