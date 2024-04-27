package com.example.WebpublicoCrud.controllers;

import com.example.WebpublicoCrud.dtos.JuridicoRecordDtos;
import com.example.WebpublicoCrud.models.JuricaModel;
import com.example.WebpublicoCrud.repositories.JuridicaRepositorio;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
public class juridicoController {
    @Autowired
    JuridicaRepositorio juridicaRepositorio;

    @PostMapping("/juridica")
    public ResponseEntity<JuricaModel> saveJuridico(@RequestBody @Valid JuridicoRecordDtos juridicoRecordDtos){
        var juricaModel = new JuricaModel();
        BeanUtils.copyProperties(juridicoRecordDtos, juricaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(juridicaRepositorio.save(juricaModel));
    }

    @GetMapping("/juridica")
    public ResponseEntity<List<JuricaModel>> getAlljuridica(){
        return ResponseEntity.status(HttpStatus.OK).body(juridicaRepositorio.findAll());
    }

    @GetMapping("/juridica/{id}")
    public ResponseEntity<Object> getonejuridica(@RequestParam(value ="id") UUID id){
        Optional<JuricaModel> juricaP = juridicaRepositorio.findById(id);
        if (juricaP.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(juricaP.get());
    }

    @PutMapping("/juridica/{id}")
    public ResponseEntity<Object> Putonejuridica(@PathVariable(value = "id")UUID id, @RequestBody @Valid JuridicoRecordDtos juridicoRecordDtos){
        Optional<JuricaModel> juricaP = juridicaRepositorio.findById(id);
        if (juricaP.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        var juridicaModel = juricaP.get();
        BeanUtils.copyProperties(juridicoRecordDtos, juridicaModel);
        return ResponseEntity.status(HttpStatus.OK).body(juridicaRepositorio.save(juridicaModel));
    }

    @DeleteMapping("/juridica/{id}")
    public ResponseEntity<Object> DELETEJuridco(@PathVariable(value = "id")UUID id) {
        Optional<JuricaModel> juricaP = juridicaRepositorio.findById(id);
        if (juricaP.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        juridicaRepositorio.delete(juricaP.get());
        return ResponseEntity.status(HttpStatus.OK).body("PESSOA DELETADA");
    }




}
