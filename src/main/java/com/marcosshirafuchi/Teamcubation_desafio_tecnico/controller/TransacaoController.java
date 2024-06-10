package com.marcosshirafuchi.Teamcubation_desafio_tecnico.controller;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto.EstatisticaDto;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto.TransacaoDto;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.exception.TransacaoInvalidaException;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.exception.ValidarTransacao;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacao")
    public ResponseEntity<List<TransacaoDto>> salvar(@RequestBody List<TransacaoDto> body) throws Exception {
        try {

            TransacaoDto transacaoDto = null;
            for (int i = 0; i < body.size(); i++) {
                transacaoDto = body.get(i);
            }
            ValidarTransacao validarTransacao = new ValidarTransacao();
            validarTransacao.validarTransacao(transacaoDto);
            List<TransacaoDto> result = transacaoService.save(body);
            return ResponseEntity.status(HttpStatus.OK).body(result);

        } catch (TransacaoInvalidaException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }

    }

    @DeleteMapping("/transacao")
    public ResponseEntity<List<TransacaoDto>> delete(){
        List<TransacaoDto> productDtoList = transacaoService.delete();
        return ResponseEntity.status(HttpStatus.OK).body(productDtoList);
    }

//    @GetMapping("/estatistica")
//    public ResponseEntity<List<TransacaoDto>> getEstatistica(){
//        List<TransacaoDto> productDtoList = transacaoService.Estatistica();
//        return ResponseEntity.status(HttpStatus.OK).body(productDtoList);
//    }
//    @GetMapping("/estatistica")
//    public ResponseEntity<DoubleSummaryStatistics> getEstatistica(){
//        DoubleSummaryStatistics estatistica = transacaoService.Estatistica();
//        return ResponseEntity.status(HttpStatus.OK).body(estatistica);
//    }

    @GetMapping("/estatistica")
    public ResponseEntity<EstatisticaDto> getEstatistica(){
        EstatisticaDto estatistica = transacaoService.Estatistica();
        return ResponseEntity.status(HttpStatus.OK).body(estatistica);
    }

//    @GetMapping("/estatistica")
//    public ResponseEntity<EstatisticaDto> getEstatistica(){
//        EstatisticaDto productDtoList = transacaoService.Estatistica();
//        return ResponseEntity.status(HttpStatus.OK).body(productDtoList);
//    }
}
