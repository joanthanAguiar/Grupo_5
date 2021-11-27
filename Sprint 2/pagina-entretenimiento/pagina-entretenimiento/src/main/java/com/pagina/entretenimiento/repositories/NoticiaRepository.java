package com.pagina.entretenimiento.repositories;

import com.pagina.entretenimiento.models.NoticiaModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoticiaRepository extends MongoRepository<NoticiaModel,String> {
    
}
