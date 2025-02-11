package com.br.proposta.credito.http.domain.response;

import com.br.proposta.credito.http.domain.dto.PropostaCreditoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PropostaCreditoDtoResponse {
    private PropostaCreditoDto propostaCreditoDto;
}
