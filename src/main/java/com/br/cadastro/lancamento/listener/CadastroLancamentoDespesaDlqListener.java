package com.br.cadastro.lancamento.listener;


import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CadastroLancamentoDespesaDlqListener {

    @KafkaListener(topics = "${lancamento.topic.dlq.name}", groupId = "ms-cadastro-lancamento")
    public void listenDLQ(ConsumerRecord<String, String> message) {
        log.info("CadastroLancamentoDlqListener: Received message from DLQ: {}", message.value());
    }
}

