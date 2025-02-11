package com.br.proposta.credito.database.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import oracle.sql.ARRAY;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
public class ClientePropostaCreditoType implements SQLData {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private EnderecoPropostaCreditoType enderecoPropostaCreditoType;

    private List<TelefonePropostaCreditoType> telefonePropostaCreditoTypeList;


    public Struct toStruct(Connection connection) throws SQLException {
        List<Struct> structList = new ArrayList<>();
        Struct enderecoStruct = enderecoPropostaCreditoType.toStruct(connection);

        telefonePropostaCreditoTypeList.forEach(telefonePropostaCreditoType -> {
            try {
                structList.add(telefonePropostaCreditoType.toStruct(connection));
            } catch (SQLException e) {
                log.error("Erro ao gerar telefonesPropostaCreditoType", e);
                throw new RuntimeException(e);
            }
        });


        Object[] attributes = {id, nome, cpf, rg, dataNascimento, enderecoStruct, structList.toArray(new Struct[0])};
        return connection.createStruct("CLIENTE_PROPOSTA_CREDITO_TYPE", attributes);
    }

    public static ClientePropostaCreditoType fromStruct(Struct clienteStruct) throws SQLException {
        Object[] attributes = clienteStruct.getAttributes();

        ClientePropostaCreditoType cliente = new ClientePropostaCreditoType();

        cliente.setId((Long) attributes[0]);
        cliente.setNome((String) attributes[1]);
        cliente.setCpf((String) attributes[2]);
        cliente.setRg((String) attributes[3]);
        cliente.setDataNascimento((String) attributes[4]);

        if (null != attributes[5]) {
            Struct enderecoStruct = (Struct) attributes[5];
            EnderecoPropostaCreditoType endereco = EnderecoPropostaCreditoType.fromStruct(enderecoStruct);
            cliente.setEnderecoPropostaCreditoType(endereco);
        }
        if (null != attributes[6]) {
            ARRAY telefonesArray = (ARRAY) attributes[6];
            Object[] telefones = (Object[]) telefonesArray.getArray();
            List<TelefonePropostaCreditoType> list = TelefonePropostaCreditoType.fromStruct(telefones);
            cliente.setTelefonePropostaCreditoTypeList(list);
        }
        return cliente;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return "CLIENTE_PROPOSTA_CREDITO_TYPE";
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.id = stream.readLong();
        this.nome = stream.readString();
        this.cpf = stream.readString();
        this.rg = stream.readString();
        this.dataNascimento = stream.readString();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        stream.writeLong(id);
        stream.writeString(nome);
        stream.writeString(cpf);
        stream.writeString(rg);
        stream.writeString(dataNascimento);
    }
}
