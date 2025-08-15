package com.wes.todolistapiuninter4596063.Controller;

import com.wes.todolistapiuninter4596063.Model.Tarefa;
import com.wes.todolistapiuninter4596063.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    TarefaRepository tarefaRepository;

    @GetMapping
    public ResponseEntity<List<Tarefa>> getAllTasks(){
        List<Tarefa> tasks = tarefaRepository.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTaskById(@PathVariable Long id) {
        return tarefaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


}
