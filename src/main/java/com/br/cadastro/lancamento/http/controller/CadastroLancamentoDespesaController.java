package com.br.cadastro.lancamento.http.controller;


import com.br.cadastro.lancamento.usecase.PreparaDadosCadastroLancamentoDespesa;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro/cliente")
@AllArgsConstructor
public class CadastroLancamentoDespesaController {

   private final PreparaDadosCadastroLancamentoDespesa preparaDadosCadastroLancamentoDespesa;

    @PostMapping
    public ResponseEntity<String> cadastrarLancamento() {
        return preparaDadosCadastroLancamentoDespesa.executar();
    }
}
