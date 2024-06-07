package com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto;

import java.time.OffsetDateTime;

public class TransacaoDto {
    private Float valor;
    //private OffsetDateTime dataHora;


    public TransacaoDto(Float valor) {
//        if (valor<0){
//            System.out.println("O valo não pode ser negativo");
//        }
        this.valor = valor;
    }

    public TransacaoDto(Float valor, OffsetDateTime dataHora) {
        this.valor = valor;
       // this.dataHora = dataHora.;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

//    public OffsetDateTime getDataHora() {
//        return dataHora;
//    }
//
//    public void setDataHora(OffsetDateTime dataHora) {
//        this.dataHora = dataHora;
//    }
}
