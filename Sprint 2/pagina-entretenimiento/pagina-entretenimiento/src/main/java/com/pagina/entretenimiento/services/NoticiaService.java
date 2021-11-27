package com.pagina.entretenimiento.services;

import java.util.List;
import java.util.Optional;

import com.pagina.entretenimiento.models.NoticiaModel;
import com.pagina.entretenimiento.repositories.NoticiaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service //Definimos la clase como un servicio
public class NoticiaService {

    @Autowired //Creamos la instancia del repository
    NoticiaRepository noticiaRepository; 

    //Método para guardar noticia
    public void guardarNoticia(NoticiaModel noticia) {
        this.noticiaRepository.save(noticia);
    }

    //Método para traer los noticia
    public List<NoticiaModel> traerNoticia() {
        return this.noticiaRepository.findAll();
    }

    //Método para buscar noticia por ID
    public Optional<NoticiaModel> buscarPorId(String id) {
         return this.noticiaRepository.findById(id);
    }

    //Método para verificar si ya existe el noticia
    public Boolean verificar(String id) {
        return this.noticiaRepository.existsById(id);
    }

    //Método para eliminar un noticia
    public void eliminar(String id) {
        this.noticiaRepository.deleteById(id);
    }

    
}
