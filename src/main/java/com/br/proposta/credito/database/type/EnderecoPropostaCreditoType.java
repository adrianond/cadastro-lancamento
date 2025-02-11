package com.br.proposta.credito.database.type;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPropostaCreditoType implements SQLData {
    private Long id;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;

    public Struct toStruct(Connection connection) throws SQLException {
        Object[] attributes = {id, endereco, numero, complemento, cep, bairro, cidade, uf};
        return connection.createStruct("ENDERECO_PROPOSTA_CREDITO_TYPE", attributes);
    }

    public static EnderecoPropostaCreditoType fromStruct(Struct enderecoStruct) throws SQLException {
        Object[] attributes = enderecoStruct.getAttributes();
        EnderecoPropostaCreditoType enderecoPropostaCreditoType = new EnderecoPropostaCreditoType();

        enderecoPropostaCreditoType.setId((Long) attributes[0]);
        enderecoPropostaCreditoType.setEndereco((String) attributes[1]);
       // enderecoPropostaCreditoType.setNumero((Integer) attributes[2]);
        enderecoPropostaCreditoType.setComplemento((String) attributes[3]);
        enderecoPropostaCreditoType.setCep((String) attributes[4]);
        enderecoPropostaCreditoType.setBairro((String) attributes[5]);
        enderecoPropostaCreditoType.setCidade((String) attributes[6]);
        enderecoPropostaCreditoType.setUf((String) attributes[7]);

        return enderecoPropostaCreditoType;
    }


    @Override
    public String getSQLTypeName() throws SQLException {
        return "ENDERECO_PROPOSTA_CREDITO_TYPE";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.id = stream.readLong();
        this.endereco = stream.readString();
        this.numero = stream.readInt();
        this.complemento = stream.readString();
        this.cep = stream.readString();
        this.bairro = stream.readString();
        this.cidade = stream.readString();
        this.uf = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeLong(id);
        stream.writeString(endereco);
        stream.writeInt(numero);
        stream.writeString(complemento);
        stream.writeString(cep);
        stream.writeString(bairro);
        stream.writeString(cidade);
        stream.writeString(uf);
    }
}
