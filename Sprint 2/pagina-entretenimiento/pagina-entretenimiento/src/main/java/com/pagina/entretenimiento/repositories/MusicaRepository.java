package com.pagina.entretenimiento.repositories;

import com.pagina.entretenimiento.models.MusicaModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MusicaRepository extends MongoRepository<MusicaModel,String> {
    
}
