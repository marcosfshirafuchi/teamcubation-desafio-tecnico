package com.marcosshirafuchi.Teamcubation_desafio_tecnico.repository;

import com.marcosshirafuchi.Teamcubation_desafio_tecnico.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class TransacaoRepository {
    private List<Transacao> dtoList = new ArrayList();
    public List<Transacao> getList(){
        return dtoList;
    }
}
