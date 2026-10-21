package br.com.projetos.gerenciador_de_tarefas.repository;

import br.com.projetos.gerenciador_de_tarefas.model.Tarefa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TarefaRepository {
    private final List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    public Tarefa salvar(Tarefa tarefa) {
        tarefa.setId(proximoId++);
        tarefas.add(tarefa);
        return tarefa;
    }

    public List<Tarefa> listarTodas() {
        return new ArrayList<>(tarefas);
    }

    public boolean excluirPorId(int id) {
        Optional<Tarefa> tarefaEncontrada = tarefas.stream()
                .filter(tarefa -> tarefa.getId() == id)
                .findFirst();

        tarefaEncontrada.ifPresent(tarefas::remove);
        return tarefaEncontrada.isPresent();
    }

    public Tarefa buscarPorId(int id) {
        Optional<Tarefa> tarefaRepository = tarefaRepository.findById(id);

        tarefaEncontrada.(tarefas::getFirst());
        return tarefaEncontrada.isPresent();
    }

}
