package com.br.proposta.credito.scheduled;

import com.br.proposta.credito.usecase.PreparaDadosCadastroLancamentoDespesa;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
@Slf4j
@Transactional
@ConditionalOnProperty(value = "app.proposta-credito.scheduler.efetuar-cadastro-despesa.enabled", havingValue = "true")
public class CadastraLancamentoDespesaSchedule {
    private final PreparaDadosCadastroLancamentoDespesa preparaDadosCadastroLancamentoDespesa;

    @Scheduled(cron = "${app.proposta-credito.scheduler.efetuar-cadastro-despesa.cron}")
    //@Scheduled(fixedDelay = 5000)
    public void executar() {
        preparaDadosCadastroLancamentoDespesa.executar();
    }
}
