package com.marcosshirafuchi.Teamcubation_desafio_tecnico.service;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto.TransacaoDto;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.model.Transacao;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class TransacaoService {
    @Autowired
    private TransacaoRepository repository;

    public List<TransacaoDto> save(List<TransacaoDto> transacaoDtoList) {


        transacaoDtoList.forEach(value -> {
            Random random = new Random();
            long randomInt = random.nextLong(500);
            Transacao transacao = new Transacao(randomInt,value.getValor(), value.getDataHora());
            repository.getList().add(transacao);
        });

        List<Transacao> listTransacao = repository.getList();
        List<TransacaoDto> resultTransacaoDto = listTransacao.stream().map(
                value -> new TransacaoDto(value.getValor(), value.getDataHora())
        ).toList();

        return resultTransacaoDto;
    }
    public List<TransacaoDto> delete(){
        List<Transacao> listProduct = repository.getDelete();
        List<TransacaoDto> transacaoDto = listProduct.stream().map(
                value -> new TransacaoDto(value.getValor(),value.getDataHora())
        ).toList();
        return transacaoDto;
    }

}
