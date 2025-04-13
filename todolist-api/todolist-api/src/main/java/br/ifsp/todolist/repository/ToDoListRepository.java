package br.ifsp.todolist.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifsp.todolist.model.Tarefa;

@Repository
public interface ToDoListRepository extends JpaRepository<Tarefa, Long>{
	Page<Tarefa> findByCategoriaContainingIgnoreCase(String categoria, Pageable pageable);
}
