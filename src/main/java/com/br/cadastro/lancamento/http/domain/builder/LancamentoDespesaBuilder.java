package com.br.cadastro.lancamento.http.domain.builder;


import com.br.cadastro.lancamento.database.entity.LancamentoDespesa;
import com.br.cadastro.lancamento.database.repository.CategoriaRepositoryFacade;
import com.br.cadastro.lancamento.http.domain.dto.LancamentoCsvDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class LancamentoDespesaBuilder {
    private final CategoriaRepositoryFacade categoriaRepositoryFacade;

    public LancamentoDespesa fromDtoToEntity(LancamentoCsvDto lancamentoCsvDto) {

        LancamentoDespesa lancamentoDespesa = new LancamentoDespesa();
        lancamentoDespesa.setDataLancamento(LocalDate.now());
        lancamentoDespesa.setDescricao(lancamentoCsvDto.getDescricao());
        lancamentoDespesa.setObservacao(lancamentoCsvDto.getObservacao());
        lancamentoDespesa.setTipoLancamento(lancamentoCsvDto.getTipo());
        lancamentoDespesa.setValor(lancamentoCsvDto.getValor());
        lancamentoDespesa.setCategoria(categoriaRepositoryFacade.findById(lancamentoCsvDto.getIdCategoria()));
        lancamentoDespesa.setResponsavel(lancamentoCsvDto.getResponsavel());
        return lancamentoDespesa;
    }
}
