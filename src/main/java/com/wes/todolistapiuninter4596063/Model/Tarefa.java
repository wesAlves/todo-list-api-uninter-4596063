package com.wes.todolistapiuninter4596063.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="tarefa")
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dateEntrega;

    public Tarefa() {
    }

    public Tarefa(Long id, String nome, Date dateEntrega) {
        this.id = id;
        this.nome = nome;
        this.dateEntrega = dateEntrega;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDateEntrega() {
        return dateEntrega;
    }

    public void setDateEntrega(Date dateEntrega) {
        this.dateEntrega = dateEntrega;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Tarefa tarefa = (Tarefa) o;
        return Objects.equals(id, tarefa.id) && Objects.equals(nome, tarefa.nome) && Objects.equals(dateEntrega, tarefa.dateEntrega);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dateEntrega);
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dateEntrega=" + dateEntrega +
                '}';
    }
}
