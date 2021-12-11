package com.pagina.entretenimiento.services;

import java.util.List;
import java.util.Optional;

import com.pagina.entretenimiento.models.MusicaModel;
import com.pagina.entretenimiento.repositories.MusicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Definimos la clase como un servicio
public class MusicaService {

    @Autowired //Creamos la instancia del repository
    MusicaRepository musicaRepository; 

    //Método para guardar musica
    public void guardarMusica(MusicaModel musica) {
        this.musicaRepository.save(musica);
    }

    //Método para traer los musica
    public List<MusicaModel> traerMusica() {
        return this.musicaRepository.findAll();
    }

    //Método para buscar musica por ID
    public Optional<MusicaModel> buscarPorId(String id) {
         return this.musicaRepository.findById(id);
    }

    //Método para verificar si ya existe el musica
    public Boolean verificar(String id) {
        return this.musicaRepository.existsById(id);
    }

    //Método para eliminar un musica
    public void eliminar(String id) {
        this.musicaRepository.deleteById(id);
    }

    
}
