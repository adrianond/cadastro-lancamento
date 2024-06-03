package com.br.cadastro.lancamento.http.controller;


import com.br.cadastro.lancamento.usecase.PreparaDadosCadastroLancamento;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro/lancamento")
@AllArgsConstructor
public class CadastroLancamentoController {

   private final PreparaDadosCadastroLancamento preparaDadosCadastroLancamento;

    @PostMapping
    public ResponseEntity<String> cadastrarLancamento() {
        return preparaDadosCadastroLancamento.executar();
    }
}
