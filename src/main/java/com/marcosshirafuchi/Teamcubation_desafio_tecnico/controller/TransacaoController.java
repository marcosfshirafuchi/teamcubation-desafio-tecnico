package com.marcosshirafuchi.Teamcubation_desafio_tecnico.controller;

import com.marcosshirafuchi.Teamcubation_desafio_tecnico.dto.TransacaoDto;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.model.Transacao;
import com.marcosshirafuchi.Teamcubation_desafio_tecnico.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;
    @PostMapping
    public ResponseEntity<List<TransacaoDto>> salvar(@RequestBody List<TransacaoDto> body){
//        for (int i=0;i<body.size();i++){
//            if (body.contains(body.get(i).getValor()<0)) {
//                return ResponseEntity.badRequest().body("Custom header set");;
//            }
//        }

//        if (body.contains(body.get().getValor()<0)){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body();
//        }
        List<TransacaoDto> result = transacaoService.save(body);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable Integer id){
        return ResponseEntity.ok("Deu certo para ID: " + id);
    }
}
