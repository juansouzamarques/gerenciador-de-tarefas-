package br.com.projetos.gerenciador_de_tarefas.mapper;

import br.com.projetos.gerenciador_de_tarefas.dto.TarefaRequestDTO;
import br.com.projetos.gerenciador_de_tarefas.dto.TarefaResponseDTO;
import br.com.projetos.gerenciador_de_tarefas.enums.Status;
import br.com.projetos.gerenciador_de_tarefas.model.Tarefa;

import java.time.LocalDateTime;

public class TarefaMapper {

    public Tarefa toModel(TarefaRequestDTO requestDTO) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(requestDTO.titulo());
        tarefa.setDescricao(requestDTO.descricao());
        tarefa.setStatus(requestDTO.status() != null ? requestDTO.status() : Status.PENDENTE);
        tarefa.setPrioridade(requestDTO.prioridade());
        tarefa.setDataCriacao(LocalDateTime.now());
        return tarefa;
    }

    public TarefaResponseDTO toResponseDTO(Tarefa tarefa) {
        return new TarefaResponseDTO(
                tarefa.getId(),
                tarefa.getTitulo(),
                tarefa.getDescricao(),
                tarefa.getStatus(),
                tarefa.getPrioridade(),
                tarefa.getDataCriacao()
        );
    }
}
