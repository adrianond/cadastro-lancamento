package com.br.cadastro.lancamento.database.type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientePropostaCreditoType {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNascimento;

    public Struct toStruct(Connection connection) throws SQLException {
        Object[] attributes = {id, nome, cpf, rg, dataNascimento};
        return connection.createStruct("ClientePropostaCreditoType", attributes);
    }
}
