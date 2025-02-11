package com.br.proposta.credito.http.controller;


import com.br.proposta.credito.http.domain.dto.PropostaCreditoDto;
import com.br.proposta.credito.http.domain.response.PropostaCreditoDtoResponse;
import com.br.proposta.credito.usecase.SalvaPropostaCredito;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cadastro/proposta")
@AllArgsConstructor
public class CadastraPropostaCreditoController {

   private final SalvaPropostaCredito salvaPropostaCredito;


    @ApiOperation(value = "Save new credit proposal")
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public PropostaCreditoDtoResponse cadastrarPropostaCredito(@RequestBody PropostaCreditoDto propostaCreditoDto) {

        return new PropostaCreditoDtoResponse(salvaPropostaCredito.executar(propostaCreditoDto));
    }
}
