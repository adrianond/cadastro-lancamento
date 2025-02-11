package com.br.proposta.credito.database.type;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefonePropostaCreditoType implements SQLData {
    private Long id;
    private String tipo;
    private String numero;
    private String ddd;


    public Struct toStruct(Connection connection) throws SQLException {
        Object[] attributes = {id, tipo, numero, ddd};
        return connection.createStruct("TELEFONE_PROPOSTA_CREDITO_TYPE", attributes);
    }

    public static List<TelefonePropostaCreditoType> fromStruct(Object[] telefonesStruct) throws SQLException {
        List<TelefonePropostaCreditoType> telefones = new ArrayList<>();
        for (Object telefoneObj : telefonesStruct) {
            Struct telefoneStruct = (Struct) telefoneObj;
            Object[] attributes = telefoneStruct.getAttributes();

            TelefonePropostaCreditoType telefonePropostaCreditoType = new TelefonePropostaCreditoType();
            telefonePropostaCreditoType.setId((Long) attributes[0]);
            telefonePropostaCreditoType.setTipo((String)attributes[1]);
            telefonePropostaCreditoType.setNumero((String)attributes[2]);
            telefonePropostaCreditoType.setDdd((String)attributes[3]);

            telefones.add(telefonePropostaCreditoType);
        }
        return telefones;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "TELEFONE_PROPOSTA_CREDITO_TYPE";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.id = stream.readLong();
        this.tipo = stream.readString();
        this.numero = stream.readString();
        this.ddd = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeLong(id);
        stream.writeString(tipo);
        stream.writeString(numero);
        stream.writeString(ddd);
    }
}
