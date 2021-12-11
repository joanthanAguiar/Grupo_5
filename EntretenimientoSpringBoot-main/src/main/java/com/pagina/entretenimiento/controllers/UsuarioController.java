package com.pagina.entretenimiento.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.pagina.entretenimiento.models.UsuarioModel;
import com.pagina.entretenimiento.services.UsuarioService;
import com.pagina.entretenimiento.utils.Autorizacion;
import com.pagina.entretenimiento.utils.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UsuarioController {
    
    @Autowired
    UsuarioService usuarioService;

   

    //Método para registrar a un usuario
    //Definimos el método de la petición HTTP Post

    @PostMapping("/usuarios") //POST 
    public ResponseEntity<Map<String, String>> guardarUsuarios(@RequestBody UsuarioModel usuario){
        
        //Map tener una clave valor {"mensaje": "Se agregó correctamente"}
        Map<String, String> respuesta= new HashMap<>();
        
        //Codificar contraseña
        usuario.setPassword(BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt()));
       
       
        UsuarioModel u=this.usuarioService.buscarPorusername(usuario.getUsername());
        if(u.getId()==null){
            this.usuarioService.guardar(usuario);
            respuesta.put("mensaje","Se agregó correctamente");
        }else{
            respuesta.put("mensaje","Usuario ya existe");
        }

        return ResponseEntity.ok(respuesta);
    }


    //Método para chekear autenticidad
    @PostMapping("/usuarios/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UsuarioModel usuario){
        UsuarioModel usuarioAux=this.usuarioService.buscarPorusername(usuario.getUsername());
        Map<String, String> respuesta = new HashMap<>();
        if(usuarioAux.getUsername()==null){
            respuesta.put("mensaje","usuario o contraseña incorrectos");
        }else{
            if(!BCrypt.checkpw(usuario.getPassword(), usuarioAux.getPassword())){
                respuesta.put("mensaje","usuario o contraseña incorrectos");
            }else{
                String hash ="";
                long tiempo = System.currentTimeMillis();
                if(usuarioAux.getId()!=null){
                    hash=Jwts.builder()
                           .signWith(SignatureAlgorithm.HS256, Autorizacion.KEY)
                           .setSubject(usuarioAux.getNombre())
                           .setIssuedAt(new Date(tiempo))
                           .setExpiration(new Date(tiempo+900000))
                           .claim("username", usuarioAux.getUsername())
                           .claim("correo", usuarioAux.getCorreo())
                           .compact();
                }
                usuarioAux.setHash(hash);
                respuesta.put("mensaje","Accedió correctamente");
                respuesta.put("token",hash);
            }
        }
        return ResponseEntity.ok(respuesta);
    }







    @PutMapping("/usuarios") //POST 
    public ResponseEntity<Map<String, String>> actualizarUsuario(@RequestBody UsuarioModel usuario){
        
        //Map tener una clave valor {"mensaje": "Se agregó correctamente"}
        Map<String, String> respuesta= new HashMap<>();
            this.usuarioService.guardar(usuario); //Actualizo al usuario
            respuesta.put("mensaje","Se actualizó correctamente");

            //Busco el partdio que contenga a ese usuario
           // PartidoModel parAux=this.partidoService.getPartido("61945de3105cd33b0f98d96a");
            //Modifico la información de usuario dentro del partido
        //    parAux.getUsuario().setNombre(usuario.getNombre());
            //y se le agrega al partido
        //    actualizarPartido(parAux);
        return ResponseEntity.ok(respuesta);
    }

/*
    public void actualizarPartido(PartidoModel partido){
        this.partidoService.guardarPartido(partido);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje","Se actualizó correctamente");
    }*/

    
}
