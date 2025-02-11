package com.br.proposta.credito.http.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Struct;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoPropostaCreditoDto {
    private Long id;
    private String endereco;
    private Integer numero;
    private String complemento;
    private String cep;
    private String bairro;
    private String cidade;
    private String uf;
}
