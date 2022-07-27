package com.example.microservicioaula.service;

import com.example.microservicioaula.model.Aula;

import java.util.List;

public interface AulaService {
    List<Aula> listar();
    Aula porId(Integer id_aula);
    void guardar(Aula aula);
    void eliminar(Integer id_aula);
    void actualizar(Aula aula);
}
