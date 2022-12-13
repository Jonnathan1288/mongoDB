package com.sistema.sistemamongo.repocitory;

import com.sistema.sistemamongo.model.Tarea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TareaRepository extends MongoRepository<Tarea, String> {
}
