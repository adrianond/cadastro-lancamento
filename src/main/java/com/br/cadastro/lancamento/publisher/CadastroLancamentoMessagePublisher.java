package com.br.cadastro.lancamento.publisher;


import com.br.cadastro.lancamento.http.domain.dto.LancamentoCsvDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class CadastroLancamentoMessagePublisher {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${lancamento.topic.name}")
    private String topicName;

    public void send(List<LancamentoCsvDto> lancamentoCsvDtoList) throws JsonProcessingException {
        ObjectMapper objectMapper = JsonMapper.builder()
                .addModule(new JavaTimeModule())
                .build();

        try {
            for (LancamentoCsvDto lancamentoCsvDto : lancamentoCsvDtoList) {
                String message = objectMapper.writeValueAsString(lancamentoCsvDto);
                log.info("MESSAGE SENT FROM PRODUCER END {}", message);
                kafkaTemplate.send(topicName, message);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}

