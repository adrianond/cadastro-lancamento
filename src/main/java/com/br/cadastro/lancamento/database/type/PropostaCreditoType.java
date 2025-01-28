package com.br.cadastro.lancamento.database.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropostaCreditoType {
    private Long id;
    private String produto;
    private BigDecimal valor;
    private String status;
    ClientePropostaCreditoType clientePropostaCreditoType;

    public Struct toStruct(Connection connection) throws SQLException {
        Struct clienteStruct = clientePropostaCreditoType.toStruct(connection);
        Object[]  attributes = {id, produto, valor, status, clienteStruct};
        return connection.createStruct("PropostaCreditoType", attributes);
    }
}
