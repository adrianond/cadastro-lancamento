package com.br.cadastro.lancamento.listener;


import com.br.cadastro.lancamento.http.domain.dto.LancamentoCsvDto;
import com.br.cadastro.lancamento.usecase.CadastraLancamento;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@AllArgsConstructor
@Slf4j
public class CadastroLancamentoKafkaListener {
    private final CadastraLancamento cadastraLancamento;

    @KafkaHandler
    @RetryableTopic(
            backoff = @Backoff(value = 3000L),
            attempts = "1",
    autoCreateTopics = "false")
    @KafkaListener(topics = "${lancamento.topic.name}", groupId = "ms-cadastro-lancamento")
    public void consumeCastroLancamento(@RequestBody() String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                                        @Header(KafkaHeaders.OFFSET) long offset) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        log.info("Received message: {} from topic {} offset {}", message, topic, offset);

        try {
            LancamentoCsvDto lancamentoCsvDto = objectMapper.readValue(message, LancamentoCsvDto.class);
            if (lancamentoCsvDto.getValor() == null)
                throw new RuntimeException("Lancamento invalido: " + lancamentoCsvDto.getDescricao());

            cadastraLancamento.executar(lancamentoCsvDto);

            log.info("Message processed: {} from {} offset {}", lancamentoCsvDto, topic, offset);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    @DltHandler
    public void listenDLT(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset) {
        log.info("DLT Received : {} , from topic {} , offset {}", message, topic, offset);
    }

}

