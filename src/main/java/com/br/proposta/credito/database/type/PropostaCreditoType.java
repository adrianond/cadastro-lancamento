package com.br.proposta.credito.database.type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PropostaCreditoType implements SQLData {
    private Long id;
    private String produto;
    private BigDecimal valor;
    private String status;
    private ClientePropostaCreditoType clientePropostaCreditoType;

    public Struct toStruct(Connection connection) throws SQLException {
        Struct clienteStruct = clientePropostaCreditoType.toStruct(connection);
        Object[] attributes = {id, produto, valor, status, clienteStruct};
        return connection.createStruct("PROPOSTA_CREDITO_TYPE", attributes);
    }

    public static PropostaCreditoType fromStruct(Struct struct) throws SQLException {
        Object[] attributes = struct.getAttributes();
        PropostaCreditoType proposta = new PropostaCreditoType();

        proposta.setId((Long) attributes[0]);
        proposta.setProduto((String) attributes[1]);
        proposta.setValor((BigDecimal) attributes[2]);
        proposta.setStatus((String) attributes[3]);

        if (attributes[4] != null) {
            Struct clienteStruct = (Struct) attributes[4];
            ClientePropostaCreditoType cliente = ClientePropostaCreditoType.fromStruct(clienteStruct);
            proposta.setClientePropostaCreditoType(cliente);
        }
        return proposta;
    }


    @Override
    public String getSQLTypeName() {
        return "PROPOSTA_CREDITO_TYPE";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.produto = stream.readString();
        this.valor = stream.readBigDecimal();
        this.status = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeString(produto);
        stream.writeBigDecimal(valor);
        stream.writeString(status);
    }
}
