package com.pagina.entretenimiento.repositories;

import com.pagina.entretenimiento.models.JuegoModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface JuegoRepository extends MongoRepository<JuegoModel,String> {

}

