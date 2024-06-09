package com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto;

import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;
import jakarta.validation.constraints.Positive;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.util.Date;

public class TransacaoDto {
    @Positive(message = "O preço deve ser positivo")
    private Float valor;
    private OffsetDateTime dataHora;


    public TransacaoDto(Float valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

}
