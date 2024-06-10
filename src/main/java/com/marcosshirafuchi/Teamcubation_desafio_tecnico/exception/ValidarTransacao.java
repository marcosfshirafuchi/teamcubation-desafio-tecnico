package com.marcosshirafuchi.Teamcubation_desafio_tecnico.exception;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto.TransacaoDto;

import java.time.Duration;
import java.time.OffsetDateTime;


public class ValidarTransacao {
    public void validarTransacao(TransacaoDto transacaoDto) throws TransacaoInvalidaException {
        if (transacaoDto.getValor() < 0) {
            throw new TransacaoInvalidaException("O valor da transação não pode ser negativo!");
        }
        OffsetDateTime agora = OffsetDateTime.now();
        if (transacaoDto.getDataHora().isAfter(agora.minus(Duration.ofMinutes(1)))) {
            throw new TransacaoInvalidaException("Não pode colocar data futura!");
        }

        if (transacaoDto.getDataHora().isBefore(agora)) {
            throw new TransacaoInvalidaException("Não pode colocar data passada!");
        }
    }
}
