package com.pagina.entretenimiento.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.pagina.entretenimiento.models.PeliculaModel;
import com.pagina.entretenimiento.services.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // Permitir origen de petición
@RequestMapping("/api")
public class PeliculaController {
    
    @Autowired //Instancia del servicio 
    PeliculaService peliculaService;


    /*
    Definimos el método HTTP (POST) por el que se va a ejecutar el metodo
    dentro del controller
    */
    //        http://localhost:8080/api/equipos   GET,POST,PUT,DELETE

    //---------------------------------------------------------------------
    @PostMapping("/peliculas") 
    public ResponseEntity<Map<String, String>> guardarPelicula(@Valid @RequestBody PeliculaModel pelicula){
      this.peliculaService.guardarEquipos(pelicula);
      //Mostrar un mensaje personalizado al cliente
      Map<String, String> respuesta = new HashMap<>();
      respuesta.put("mensaje","Se añadió correctamente");
      respuesta.put("estado","true");
      /*
      {
          "mensaje":"Se añadió correctamente",
          "estado":"true"
      }
      */
      return ResponseEntity.ok(respuesta);

    }
    //-------------------------------------------------------------------------





    @GetMapping("/peliculas") //GET
    public List<PeliculaModel> traerEquipos(){
        return this.peliculaService.traerEquipos();
    }


    @GetMapping("/peliculas/{id}") //GET
    public PeliculaModel traerEquipoPorId(@PathVariable String id){
        return this.peliculaService.buscarPorId(id).get();
    }
    

}
