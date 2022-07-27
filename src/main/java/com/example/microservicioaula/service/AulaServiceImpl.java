package com.example.microservicioaula.service;

import com.example.microservicioaula.model.Aula;
import com.example.microservicioaula.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaServiceImpl implements AulaService{

    @Autowired
    private AulaRepository respository;

    @Override
    public List<Aula> listar() {
        return respository.findAll();
    }

    @Override
    public Aula porId(Integer id_aula) {
        return respository.findById(id_aula).orElse(null);
    }

    @Override
    public void guardar(Aula aula) {
        respository.save(aula);
    }

    @Override
    public void eliminar(Integer id_aula) {
        respository.deleteById(id_aula);
    }

    @Override
    public void actualizar(Aula aula) {
        respository.saveAndFlush(aula);
    }
}
