package com.sistema.sistemamongo.controller;

import com.sistema.sistemamongo.model.Tarea;
import com.sistema.sistemamongo.repocitory.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("")
    List<Tarea> index(){
        return tareaRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Tarea crete(@RequestBody Tarea tarea){
        return tareaRepository.save(tarea);
    }

    @PutMapping("{id}")
    Tarea update(@PathVariable String id, @RequestBody Tarea tarea){
        Tarea tareaFormBD = tareaRepository.findById(id).orElseThrow(RuntimeException::new);

        tareaFormBD.setNombre(tarea.getNombre());
        tareaFormBD.setEstado(tarea.isEstado());

        return tareaRepository.save(tareaFormBD);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Tarea tareaDelete = tareaRepository.findById(id).orElseThrow(RuntimeException::new);
        tareaRepository.delete(tareaDelete);
    }
}
