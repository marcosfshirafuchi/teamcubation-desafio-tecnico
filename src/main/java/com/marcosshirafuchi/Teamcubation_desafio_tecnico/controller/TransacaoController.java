package com.marcosshirafuchi.Teamcubation_desafio_tecnico.controller;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto.TransacaoDto;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@RestController
@RequestMapping
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacao")
    public ResponseEntity<?> salvar(@RequestBody List<TransacaoDto> body) {
        TransacaoDto transacaoDto = null;
        for (int i = 0; i < body.size(); i++) {
            transacaoDto = body.get(i);
        }
        OffsetDateTime agora = OffsetDateTime.now();
        if (transacaoDto.getValor() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O valor da transação não pode ser negativo!");
        } else if (transacaoDto.getDataHora().isAfter(agora)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não pode colocar data futura!");
        } else {
            List<TransacaoDto> result = transacaoService.save(body);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<?> delete() {
        List<TransacaoDto> productDtoList = transacaoService.delete();
        return ResponseEntity.status(HttpStatus.OK).body("Transações apagadas com sucesso!");
    }

    @GetMapping("/estatistica")
    public ResponseEntity<DoubleSummaryStatistics> getEstatistica() {
        DoubleSummaryStatistics productDtoList = transacaoService.Estatistica();
        return ResponseEntity.status(HttpStatus.OK).body(productDtoList);
    }
}
