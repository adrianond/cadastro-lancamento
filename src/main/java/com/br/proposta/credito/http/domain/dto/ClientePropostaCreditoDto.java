package com.br.proposta.credito.http.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientePropostaCreditoDto {
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;
    private EnderecoPropostaCreditoDto enderecoPropostaCreditoDto;
    private List<TelefonePropostaCreditoDto> telefonePropostaCreditoDtoList;
}
