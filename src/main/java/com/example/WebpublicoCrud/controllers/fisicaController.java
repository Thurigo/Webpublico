package com.example.WebpublicoCrud.controllers;


import com.example.WebpublicoCrud.dtos.FisicaRecordDtos;
import com.example.WebpublicoCrud.models.EnderecoModel;
import com.example.WebpublicoCrud.models.FisicaModel;
import com.example.WebpublicoCrud.repositories.EnderecoRepositorio;
import com.example.WebpublicoCrud.repositories.FisicaRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class fisicaController {
    @Autowired
    FisicaRepositorio fisicaRepositorio;


//    @Autowired
//    EnderecoRepositorio enderecoRepositorio;
//
//    @PostMapping("/fisica")
//    public ResponseEntity<FisicaModel> saveFisica(@RequestBody @Valid FisicaRecordDtos fisicaRecordDtos){
//        var fisicaModel = new FisicaModel();
//        BeanUtils.copyProperties(fisicaRecordDtos, fisicaModel);
//        fisicaRepositorio.save(fisicaModel);
//
//        // Criando e configurando o endereço
//        var enderecoModel = new EnderecoModel();
//        BeanUtils.copyProperties(fisicaRecordDtos.endereco(), enderecoModel);
//        enderecoModel.setPessoafisica(fisicaModel);
//        enderecoRepositorio.save(enderecoModel);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(fisicaModel);
//    }


    @PostMapping("/fisica")
    public ResponseEntity<FisicaModel> saveFisica(@RequestBody @Valid FisicaRecordDtos fisicaRecordDtos){
        var fisicaModelodel = new FisicaModel();
        BeanUtils.copyProperties(fisicaRecordDtos, fisicaModelodel);
        return ResponseEntity.status(HttpStatus.CREATED).body(fisicaRepositorio.save(fisicaModelodel));
    }


    @GetMapping("/fisica")
    public ResponseEntity<List<FisicaModel>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(fisicaRepositorio.findAll());
    }

    @GetMapping("/fisica/{id}")
    public ResponseEntity<Object> getonepessoa(@RequestParam(value ="id")UUID id){
        Optional<FisicaModel> fisicaP = fisicaRepositorio.findById(id);
        if (fisicaP.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(fisicaP.get());
    }

    @PutMapping("/fisica/{id}")
    public ResponseEntity<Object> Putonepessoa(@PathVariable(value = "id")UUID id, @RequestBody @Valid FisicaRecordDtos fisicaRecordDtos){
        Optional<FisicaModel> fisicaP = fisicaRepositorio.findById(id);
        if (fisicaP.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        var fisicaModel = fisicaP.get();
        BeanUtils.copyProperties(fisicaRecordDtos, fisicaModel);
        return ResponseEntity.status(HttpStatus.OK).body(fisicaRepositorio.save(fisicaModel));
    }

    @DeleteMapping("/fisica/{id}")
    public ResponseEntity<Object> DELETEonepessoa(@PathVariable(value = "id")UUID id) {
        Optional<FisicaModel> fisicaP = fisicaRepositorio.findById(id);
        if (fisicaP.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        fisicaRepositorio.delete(fisicaP.get());
        return ResponseEntity.status(HttpStatus.OK).body("PESSOA DELETADA");
    }
}
