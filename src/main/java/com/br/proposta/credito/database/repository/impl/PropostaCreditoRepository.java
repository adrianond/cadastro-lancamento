package com.br.proposta.credito.database.repository.impl;

import com.br.proposta.credito.database.type.PropostaCreditoType;
import com.br.proposta.credito.http.domain.dto.PropostaCreditoDto;
import lombok.AllArgsConstructor;
import oracle.jdbc.OracleTypes;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;

@Repository
@AllArgsConstructor
public class PropostaCreditoRepository {
    private final DataSource dataSource;

    public PropostaCreditoType salvarPropostaCredito(PropostaCreditoType propostaCreditoType) throws SQLException {
        Connection connection = null;
        CallableStatement callableStatement = null;
        try  {
            connection = dataSource.getConnection();
            callableStatement = connection.prepareCall("{call pck_proposta_credito.prc_cria_proposta(?)}");

            Struct structProposta = propostaCreditoType.toStruct(connection);

            //callableStatement.registerOutParameter(1, OracleTypes.STRUCT, "PROPOSTA_CREDITO_TYPE");
            callableStatement.setObject(1, structProposta);
            callableStatement.execute();


            //Struct struct = (Struct) callableStatement.getObject(1);
            return PropostaCreditoType.fromStruct(structProposta);

           /*
            Object[] atributos = structProposta.getAttributes();
            propostaCreditoType.setId((Long) atributos[0]);
            return propostaCreditoType;

            */

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao chamar a procedure", e);
        }finally {
            close (callableStatement, connection);
        }
    }

    public static void close(CallableStatement callableStatement, Connection connection) throws SQLException {
        try {
            if (callableStatement != null)
                callableStatement.close();
        } finally {
            if (connection != null)
                connection.close();
        }
    }
}
