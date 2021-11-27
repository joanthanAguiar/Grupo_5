package com.pagina.entretenimiento.services;

import java.util.List;
import java.util.Optional;

import com.pagina.entretenimiento.models.PeliculaModel;
import com.pagina.entretenimiento.repositories.PeliculaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Definimos la clase como un servicio
public class PeliculaService {

    @Autowired //Creamos la instancia del repository
    PeliculaRepository equipoRepository; 

    //Método para guardar equipos
    public void guardarEquipos(PeliculaModel equipo) {
        this.equipoRepository.save(equipo);
    }

    //Método para traer los Equipos
    public List<PeliculaModel> traerEquipos() {
        return this.equipoRepository.findAll();
    }

    //Método para buscar equipo por ID
    public Optional<PeliculaModel> buscarPorId(String id) {
         return this.equipoRepository.findById(id);
    }

    //Método para verificar si ya existe el equipo
    public Boolean verificar(String id) {
        return this.equipoRepository.existsById(id);
    }

    //Método para eliminar un equipo
    public void eliminar(String id) {
        this.equipoRepository.deleteById(id);
    }

    
}
