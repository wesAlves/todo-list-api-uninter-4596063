package com.wes.todolistapiuninter4596063.Repository;

import com.wes.todolistapiuninter4596063.Model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
