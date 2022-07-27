package com.example.microservicioaula.controller;

import com.example.microservicioaula.model.Aula;
import com.example.microservicioaula.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/aula/v1")
public class AulaController {

    @Autowired
    private AulaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<Aula>> listarA(){
        List<Aula> au = service.listar();
        return new ResponseEntity<>(au, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Void> nuevoA(@Validated @RequestBody Aula aula){
        service.guardar(aula);
        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarA(@Validated @RequestBody Aula aula){
        service.actualizar(aula);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/listarPorId/{id_aula}")
    public ResponseEntity<Aula> listarPorId(@Validated @RequestBody @PathVariable("id_aula")Integer id_aula) throws Exception{
        Aula au = service.porId(id_aula);
        if (au == null){
            throw new Exception("No existe id");
        }
        return new ResponseEntity<Aula>(au, HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id_aula}")
    public ResponseEntity<Void> eliminarA(@Validated @RequestBody @PathVariable("id_aula")Integer id_aula) throws Exception{
        Aula pdt = service.porId(id_aula);
        if(pdt == null){
            throw new Exception("No existe Id");
        }
        service.eliminar(id_aula);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }



}


