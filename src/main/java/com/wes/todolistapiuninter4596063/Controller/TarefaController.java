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

    @PostMapping
    public ResponseEntity<Tarefa> createTask(@RequestBody Tarefa tarefa) {
        Tarefa savedTarefa = tarefaRepository.save(tarefa);
        return ResponseEntity.ok(savedTarefa);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTask(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaRepository.findById(id)
                .map(existingTarefa -> {
                    tarefa.setId(id);
                    return ResponseEntity.ok(tarefaRepository.save(tarefa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Tarefa> partialUpdateTask(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        return tarefaRepository.findById(id)
                .map(existingTarefa -> {
                    if (tarefa.getNome() != null) {
                        existingTarefa.setNome(tarefa.getNome());
                    }
                    if (tarefa.getDataEntrega() != null) {
                        existingTarefa.setDataEntrega(tarefa.getDataEntrega());
                    }
                    if (tarefa.getResponsavel() != null) {
                        existingTarefa.setResponsavel(tarefa.getResponsavel());
                    }
                    return ResponseEntity.ok(tarefaRepository.save(existingTarefa));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        return tarefaRepository.findById(id)
                .map(tarefa -> {
                    tarefaRepository.delete(tarefa);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
