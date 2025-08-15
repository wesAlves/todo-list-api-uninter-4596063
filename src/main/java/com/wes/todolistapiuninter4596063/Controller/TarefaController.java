package com.wes.todolistapiuninter4596063.Controller;

import com.wes.todolistapiuninter4596063.Model.Tarefa;
import com.wes.todolistapiuninter4596063.Repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
