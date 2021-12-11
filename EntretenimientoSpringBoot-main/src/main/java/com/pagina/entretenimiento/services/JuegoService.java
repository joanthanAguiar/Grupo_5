package com.pagina.entretenimiento.services;

import java.util.List;
import java.util.Optional;

import com.pagina.entretenimiento.models.JuegoModel;
import com.pagina.entretenimiento.repositories.JuegoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Definimos la clase como un servicio
public class JuegoService {

    @Autowired //Creamos la instancia del repository
    JuegoRepository juegoRepository; 

    //Método para guardar equipos
    public void guardarJuegos(JuegoModel juego) {
        this.juegoRepository.save(juego);
    }

    //Método para traer los Equipos
    public List<JuegoModel> traerJuegos() {
        return this.juegoRepository.findAll();
    }

    //Método para buscar equipo por ID
    public Optional<JuegoModel> buscarPorId(String id) {
            return this.juegoRepository.findById(id);
    }

    //Método para verificar si ya existe el equipo
    public Boolean verificar(String id) {
        return this.juegoRepository.existsById(id);
    }

    //Método para eliminar un equipo
    public void eliminar(String id) {
        this.juegoRepository.deleteById(id);
    }

    
}

