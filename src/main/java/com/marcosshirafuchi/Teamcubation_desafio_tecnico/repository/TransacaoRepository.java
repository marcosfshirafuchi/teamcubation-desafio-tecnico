package com.marcosshirafuchi.Teamcubation_desafio_tecnico.repository;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto.EstatisticaDto;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.model.Transacao;
import org.springframework.stereotype.Repository;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {
    private List<Transacao> dtoList = new ArrayList();
    public List<Transacao> getList(){
        return dtoList;
    }

    public List<Transacao> getDelete(){
        for (int i = 0; i< dtoList.size();i++){
            dtoList.clear();
        }
        return dtoList;
    }

    public EstatisticaDto calcularEstatisticas() {
        OffsetDateTime agora = OffsetDateTime.now();
        OffsetDateTime limiteInferior = agora.minusSeconds(60);


        long count = 0;
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;


        for (Transacao transacao : dtoList) {
            if (transacao.getDataHora().isAfter(limiteInferior)) {
                count++;
                double valor = transacao.getValor();
                sum += valor;
                min = Math.min(min, valor);
                max = Math.max(max, valor);
            }
        }


        double avg = count > 0 ? sum / count : 0;

        EstatisticaDto estatisticas = new EstatisticaDto();
        estatisticas.setCount(count);
        estatisticas.setSum(sum);
        estatisticas.setAvg(avg);
        estatisticas.setMin(min);
        estatisticas.setMax(max);
        return estatisticas;
    }

}
