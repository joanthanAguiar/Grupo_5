package com.pagina.entretenimiento.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.pagina.entretenimiento.models.NoticiaModel;
import com.pagina.entretenimiento.services.NoticiaService;

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
public class NoticiaController {
    
    @Autowired //Instancia del servicio 
    NoticiaService noticiaService;


    /*
    Definimos el método HTTP (POST) por el que se va a ejecutar el metodo
    dentro del controller
    */
    //        http://localhost:8080/api/Noticia  GET,POST,PUT,DELETE

    //---------------------------------------------------------------------
    @PostMapping("/noticia") 
    public ResponseEntity<Map<String, String>> guardarNoticia(@Valid @RequestBody NoticiaModel noticia){
      this.noticiaService.guardarNoticia(noticia);
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





    @GetMapping("/noticia") //GET
    public List<NoticiaModel> traerNoticia(){
        return this.noticiaService.traerNoticia();
    }


    @GetMapping("/noticia/{id}") //GET
    public NoticiaModel traerNoticiaPorId(@PathVariable String id){
        return this.noticiaService.buscarPorId(id).get();
    }
    

}
