package br.com.projetos.gerenciador_de_tarefas.repository;

import br.com.projetos.gerenciador_de_tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {
}
