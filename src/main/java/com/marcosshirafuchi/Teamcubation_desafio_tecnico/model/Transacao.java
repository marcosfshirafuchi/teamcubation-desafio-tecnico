package com.marcosshirafuchi.Teamcubation_desafio_tecnico.model;

import java.time.OffsetDateTime;

public class Transacao {
    private Long id;
    private Float valor;
    private OffsetDateTime dataHora;

    public Transacao(Long id,Float valor) {
        this.id = id;
        this.valor = valor;
    }

    public Transacao(Float valor, OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
