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

    public DoubleSummaryStatistics getEstatistica() {
        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
        Iterator<Transacao> iterator = dtoList.listIterator();
        while (iterator.hasNext()) {

            doubleSummaryStatistics
                    .accept(iterator.next().getValor());
        }
        return doubleSummaryStatistics;
    }
}
