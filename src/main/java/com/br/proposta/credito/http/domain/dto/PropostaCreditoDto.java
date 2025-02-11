package com.br.proposta.credito.http.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PropostaCreditoDto {
    private Long id;
    private String produto;
    private BigDecimal valor;
    private String status;
    private ClientePropostaCreditoDto clientePropostaCreditoDto;
}
