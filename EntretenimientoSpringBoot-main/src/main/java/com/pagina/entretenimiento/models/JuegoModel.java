package com.pagina.entretenimiento.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="juegos")
public class JuegoModel {

    @Id
    private String id;
    private String nombre;
    private String categoria;
    private String servidor;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getServidor() {
        return servidor;
    }
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
}

