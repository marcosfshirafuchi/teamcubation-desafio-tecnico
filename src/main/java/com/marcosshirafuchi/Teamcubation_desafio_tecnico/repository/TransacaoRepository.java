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

    // Método para calcular as estatísticas das transações nos últimos 60 segundos
    public EstatisticaDto calcularEstatisticas() {
        OffsetDateTime agora = OffsetDateTime.now(); // Obtém o momento atual
        OffsetDateTime limiteInferior = agora.minusSeconds(60); // Calcula o limite inferior (60 segundos atrás)

        // Variáveis para armazenar os valores das estatísticas
        long count = 0;
        double sum = 0;
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;

        // Itera sobre as transações e calcula as estatísticas
        for (Transacao transacao : dtoList) {
            if (transacao.getDataHora().isAfter(limiteInferior)) { // Verifica se a transação está dentro do intervalo de tempo
                count++;
                double valor = transacao.getValor();
                sum += valor;
                min = Math.min(min, valor);
                max = Math.max(max, valor);
            }
        }

        // Calcula a média
        double avg = count > 0 ? sum / count : 0;
        // Cria e retorna o objeto de estatísticas
        EstatisticaDto estatisticas = new EstatisticaDto();
        estatisticas.setCount(count);
        estatisticas.setSum(sum);
        estatisticas.setAvg(avg);
        estatisticas.setMin(min);
        estatisticas.setMax(max);
        return estatisticas;
    }

}
