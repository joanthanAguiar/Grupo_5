package com.pagina.entretenimiento.repositories;

import com.pagina.entretenimiento.models.PeliculaModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeliculaRepository extends MongoRepository<PeliculaModel,String> {
    
}
