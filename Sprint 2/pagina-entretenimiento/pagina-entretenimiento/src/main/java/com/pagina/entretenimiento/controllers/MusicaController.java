package com.pagina.entretenimiento.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.pagina.entretenimiento.models.MusicaModel;
import com.pagina.entretenimiento.services.MusicaService;

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
public class MusicaController {
    
    @Autowired //Instancia del servicio 
    MusicaService musicaService;


    /*
    Definimos el método HTTP (POST) por el que se va a ejecutar el metodo
    dentro del controller
    */
    //        http://localhost:8080/api/musica  GET,POST,PUT,DELETE

    //---------------------------------------------------------------------
    @PostMapping("/musica") 
    public ResponseEntity<Map<String, String>> guardarMusica(@Valid @RequestBody MusicaModel musica){
      this.musicaService.guardarMusica(musica);
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





    @GetMapping("/musica") //GET
    public List<MusicaModel> traerMusica(){
        return this.musicaService.traerMusica();
    }


    @GetMapping("/musica/{id}") //GET
    public MusicaModel traerMusicaPorId(@PathVariable String id){
        return this.musicaService.buscarPorId(id).get();
    }
    

}
