package com.br.proposta.credito.usecase;


import com.br.proposta.credito.http.domain.dto.LancamentoCsvDto;
import com.br.proposta.credito.publisher.CadastroLancamentoDespesaMessagePublisher;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Component
@AllArgsConstructor
public class PreparaDadosCadastroLancamentoDespesa {
    private final CadastroLancamentoDespesaMessagePublisher cadastroLancamentoDespesaMessagePublisher;

    public ResponseEntity<String> executar()  {
        try {
            cadastroLancamentoDespesaMessagePublisher.send(readDataFromCsv());
            return ResponseEntity.ok("Message published successfully");
        } catch (Exception exception) {
            return ResponseEntity.
                    status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    private List<LancamentoCsvDto> readDataFromCsv() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader
                (new ClassPathResource("lancamentos.csv").getInputStream()))) {
            CsvToBean<LancamentoCsvDto> csvToBean = new CsvToBeanBuilder<LancamentoCsvDto>(reader)
                    .withType(LancamentoCsvDto.class)
                    .build();

            return csvToBean.parse();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao realizar o parse do csv");
        }
    }
}
