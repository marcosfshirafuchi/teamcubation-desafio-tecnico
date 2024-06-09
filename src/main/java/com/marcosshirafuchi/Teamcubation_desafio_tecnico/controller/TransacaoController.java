package com.marcosshirafuchi.Teamcubation_desafio_tecnico.controller;

import com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto.TransacaoDto;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.exception.TransacaoInvalidaException;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("api")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<List<TransacaoDto>> salvar(@Validated @RequestBody List<TransacaoDto> body) throws Exception {
        try {

            TransacaoDto transacaoDto = null;
            for (int i = 0; i < body.size(); i++) {
                transacaoDto = body.get(i);
            }
            validarTransacao(transacaoDto);
            List<TransacaoDto> result = transacaoService.save(body);
            return ResponseEntity.status(HttpStatus.OK).body(result);

        } catch (TransacaoInvalidaException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    private void validarTransacao(TransacaoDto transacaoDto) throws TransacaoInvalidaException {
        if (transacaoDto.getValor() < 0) {
            throw new TransacaoInvalidaException("O valor da transação não pode ser negativo.");
        }

        if (transacaoDto.getDataHora().isAfter(OffsetDateTime.now(ZoneId.systemDefault()))) {
            throw new TransacaoInvalidaException("Não pode colocar data futura!");
        }
        if (transacaoDto.getDataHora().isBefore(OffsetDateTime.now(ZoneId.systemDefault()))) {
            throw new TransacaoInvalidaException("Não pode colocar data passada!");
        }

    }
}
