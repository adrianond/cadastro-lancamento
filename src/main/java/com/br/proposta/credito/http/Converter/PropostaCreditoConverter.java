package com.br.proposta.credito.http.Converter;


import com.br.proposta.credito.database.type.ClientePropostaCreditoType;
import com.br.proposta.credito.database.type.EnderecoPropostaCreditoType;
import com.br.proposta.credito.database.type.PropostaCreditoType;
import com.br.proposta.credito.database.type.TelefonePropostaCreditoType;
import com.br.proposta.credito.http.domain.dto.ClientePropostaCreditoDto;
import com.br.proposta.credito.http.domain.dto.EnderecoPropostaCreditoDto;
import com.br.proposta.credito.http.domain.dto.PropostaCreditoDto;
import com.br.proposta.credito.http.domain.dto.TelefonePropostaCreditoDto;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.beans.BeanUtils.copyProperties;

@Component
public class PropostaCreditoConverter {

    public PropostaCreditoType toEntity(PropostaCreditoDto propostaCreditoDto) {
        PropostaCreditoType propostaCreditoType = new PropostaCreditoType();
        copyProperties(propostaCreditoDto, propostaCreditoType);
        propostaCreditoType.setClientePropostaCreditoType(buildClientePropostaCreditoType(propostaCreditoDto
                .getClientePropostaCreditoDto()));

        return propostaCreditoType;
    }

    private ClientePropostaCreditoType buildClientePropostaCreditoType(ClientePropostaCreditoDto clientePropostaCreditoDto) {
        ClientePropostaCreditoType clientePropostaCreditoType = new ClientePropostaCreditoType();

        copyProperties(clientePropostaCreditoDto, clientePropostaCreditoType);

        clientePropostaCreditoType.setEnderecoPropostaCreditoType(buildEnderecoPropostaCreditoType(clientePropostaCreditoDto
                .getEnderecoPropostaCreditoDto()));
        clientePropostaCreditoType.setTelefonePropostaCreditoTypeList(buildTelefonesPropostaCreditoType(clientePropostaCreditoDto
                .getTelefonePropostaCreditoDtoList()));

        return clientePropostaCreditoType;
    }

    private List<TelefonePropostaCreditoType> buildTelefonesPropostaCreditoType(List<TelefonePropostaCreditoDto> telefonePropostaCreditoDtoList) {
        return telefonePropostaCreditoDtoList.stream()
                .map(this::getTelefonePropostaCreditoType)
                .collect(Collectors.toList());
    }

    private TelefonePropostaCreditoType getTelefonePropostaCreditoType(TelefonePropostaCreditoDto telefonePropostaCreditoDto) {
        return TelefonePropostaCreditoType.builder()
                .numero(telefonePropostaCreditoDto.getNumero())
                .ddd(telefonePropostaCreditoDto.getDdd())
                .tipo(telefonePropostaCreditoDto.getTipo())
                .build();
    }

    private EnderecoPropostaCreditoType buildEnderecoPropostaCreditoType(EnderecoPropostaCreditoDto enderecoPropostaCreditoDto) {
        EnderecoPropostaCreditoType enderecoPropostaCreditoType = new EnderecoPropostaCreditoType();
        copyProperties(enderecoPropostaCreditoDto, enderecoPropostaCreditoType);

        return enderecoPropostaCreditoType;
    }

    public PropostaCreditoDto toDto(PropostaCreditoType propostaCreditoType) {
        PropostaCreditoDto propostaCreditoDto = new PropostaCreditoDto();

        copyProperties(propostaCreditoType, propostaCreditoDto);

        if (null != propostaCreditoType.getClientePropostaCreditoType()) {
            propostaCreditoDto.setClientePropostaCreditoDto(buildClientePropostaCreditoDto(propostaCreditoType
                    .getClientePropostaCreditoType()));
        }
        return propostaCreditoDto;
    }

    private ClientePropostaCreditoDto buildClientePropostaCreditoDto(ClientePropostaCreditoType clientePropostaCreditoType) {
        ClientePropostaCreditoDto clientePropostaCreditoDto = new ClientePropostaCreditoDto();

        copyProperties(clientePropostaCreditoType, clientePropostaCreditoDto);

        if (null != clientePropostaCreditoType.getEnderecoPropostaCreditoType()) {
            clientePropostaCreditoDto.setEnderecoPropostaCreditoDto(buildEnderecoPropostaCreditoDto(clientePropostaCreditoType
                    .getEnderecoPropostaCreditoType()));
        }

        if (!CollectionUtils.isEmpty(clientePropostaCreditoType.getTelefonePropostaCreditoTypeList())) {
            clientePropostaCreditoDto.setTelefonePropostaCreditoDtoList(buildTelefonesPropostaCreditoDto(clientePropostaCreditoType
                    .getTelefonePropostaCreditoTypeList()));
        }

        return clientePropostaCreditoDto;
    }

    private List<TelefonePropostaCreditoDto> buildTelefonesPropostaCreditoDto(List<TelefonePropostaCreditoType> telefonePropostaCreditoTypeList) {
        return telefonePropostaCreditoTypeList.stream()
                .map(this::getTelefonePropostaCreditoDto)
                .collect(Collectors.toList());
    }

    private TelefonePropostaCreditoDto getTelefonePropostaCreditoDto(TelefonePropostaCreditoType telefonePropostaCreditoType) {
        return TelefonePropostaCreditoDto.builder()
                .numero(telefonePropostaCreditoType.getNumero())
                .ddd(telefonePropostaCreditoType.getDdd())
                .tipo(telefonePropostaCreditoType.getTipo())
                .build();

    }

    private EnderecoPropostaCreditoDto buildEnderecoPropostaCreditoDto(EnderecoPropostaCreditoType enderecoPropostaCreditoType) {
        EnderecoPropostaCreditoDto enderecoPropostaCreditoDto = new EnderecoPropostaCreditoDto();
        copyProperties(enderecoPropostaCreditoType, enderecoPropostaCreditoDto);

        return enderecoPropostaCreditoDto;
    }
}
