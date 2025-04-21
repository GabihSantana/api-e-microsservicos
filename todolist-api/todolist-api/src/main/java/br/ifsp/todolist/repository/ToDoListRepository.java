package br.ifsp.todolist.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ifsp.todolist.model.Tarefa;

@Repository
public interface ToDoListRepository extends JpaRepository<Tarefa, Long>{
	@Query("SELECT t FROM Tarefa t WHERE LOWER(t.categoria) LIKE LOWER(CONCAT('%', :categoria, '%'))")
	Page<Tarefa> findByCategoriaContainingIgnoreCase(String categoria, Pageable pageable);
}
