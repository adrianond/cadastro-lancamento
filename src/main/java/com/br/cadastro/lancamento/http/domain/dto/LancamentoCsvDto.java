package com.br.cadastro.lancamento.http.domain.dto;

import com.br.cadastro.lancamento.database.entity.enumeration.TipoLancamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LancamentoCsvDto {
    private String descricao;
    private String dataVencimento;
    private BigDecimal valor;
    private TipoLancamento tipo;
    private String observacao;
    private Long idCategoria;
    private String responsavel;
}