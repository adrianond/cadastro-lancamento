package com.br.proposta.credito.http.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TelefonePropostaCreditoDto {
    private Long id;
    private String tipo;
    private String numero;
    private String ddd;
}
