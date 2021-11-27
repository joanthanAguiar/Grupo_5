package com.pagina.entretenimiento.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="noticia")
public class NoticiaModel {

    @Id
    private String id;
    private String nombre;
    private String genero_noticias;
    

    
    public String getId() {
        return id;
    }
    public String getGenero_noticias() {
        return genero_noticias;
    }
    public void setGenero_noticias(String genero_noticias) {
        this.genero_noticias = genero_noticias;
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

    
 
}
