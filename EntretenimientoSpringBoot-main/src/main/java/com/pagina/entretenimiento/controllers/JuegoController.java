package com.pagina.entretenimiento.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.pagina.entretenimiento.models.JuegoModel;
import com.pagina.entretenimiento.services.JuegoService;

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
public class JuegoController {
    
    @Autowired //Instancia del servicio 
    JuegoService juegoService;

    /*
    Definimos el método HTTP (POST) por el que se va a ejecutar el metodo
    dentro del controller
    */
    //        http://localhost:8080/api/juegos   GET,POST,PUT,DELETE

    //---------------------------------------------------------------------
    @PostMapping("/juegos") 
    public ResponseEntity<Map<String, String>> guardarJuego(@Valid @RequestBody JuegoModel juego){
      this.juegoService.guardarJuegos(juego);
      //Mostrar un mensaje personalizado al cliente
      Map<String, String> respuesta = new HashMap<>();
      respuesta.put("mensaje","Se añadió correctamente");
      respuesta.put("estado","true");

      return ResponseEntity.ok(respuesta);

    }
    //-------------------------------------------------------------------------

    @GetMapping("/juegos") //GET
    public List<JuegoModel> traerJuegos(){
        return this.juegoService.traerJuegos();
    }

    @GetMapping("/juegos/{id}") //GET
    public JuegoModel traerJuegoPorId(@PathVariable String id){
        return this.juegoService.buscarPorId(id).get();
    }
    

}

