package com.br.cadastro.lancamento.http.domain.builder;


import com.br.cadastro.lancamento.database.entity.Lancamento;
import com.br.cadastro.lancamento.database.repository.CategoriaRepositoryFacade;
import com.br.cadastro.lancamento.database.repository.PessoaRepositoryFacade;
import com.br.cadastro.lancamento.http.domain.dto.LancamentoCsvDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@AllArgsConstructor
public class LancamentoBuilder {
    private final CategoriaRepositoryFacade categoriaRepositoryFacade;
    private final PessoaRepositoryFacade pessoaRepositoryFacade;



    public Lancamento fromDtoToEntity(LancamentoCsvDto lancamentoCsvDto) {

        Lancamento lancamento = new Lancamento();
        lancamento.setDataVencimento(LocalDate.now());
        lancamento.setDescricao(lancamentoCsvDto.getDescricao());
        lancamento.setObservacao(lancamentoCsvDto.getObservacao());
        lancamento.setTipoLancamento(lancamentoCsvDto.getTipo());
        lancamento.setValor(lancamentoCsvDto.getValor());
        lancamento.setCategoria(categoriaRepositoryFacade.findById(lancamentoCsvDto.getIdCategoria()));
        lancamento.setPessoa(pessoaRepositoryFacade.findById(lancamentoCsvDto.getIdPessoa()));
        return lancamento;
    }
}
