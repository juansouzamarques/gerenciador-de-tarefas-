package br.com.projetos.gerenciador_de_tarefas.mapper;

import br.com.projetos.gerenciador_de_tarefas.dto.TarefaRequestDTO;
import br.com.projetos.gerenciador_de_tarefas.dto.TarefaResponseDTO;
import br.com.projetos.gerenciador_de_tarefas.enums.Status;
import br.com.projetos.gerenciador_de_tarefas.model.Tarefa;

import java.time.LocalDateTime;

public class TarefaMapper {

    public Tarefa toModel(TarefaRequestDTO requestDTO) {
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(requestDTO.getTitulo());
        tarefa.setDescricao(requestDTO.getDescricao());
        tarefa.setStatus(requestDTO.getStatus() != null ? requestDTO.getStatus() : Status.PENDENTE);
        tarefa.setPrioridade(requestDTO.getPrioridade());
        tarefa.setDataCriacao(LocalDateTime.now());
        return tarefa;
    }

    public TarefaResponseDTO toResponseDTO(Tarefa tarefa) {
        TarefaResponseDTO responseDTO = new TarefaResponseDTO();
        responseDTO.setId(tarefa.getId());
        responseDTO.setTitulo(tarefa.getTitulo());
        responseDTO.setDescricao(tarefa.getDescricao());
        responseDTO.setStatus(tarefa.getStatus());
        responseDTO.setPrioridade(tarefa.getPrioridade());
        responseDTO.setDataCriacao(tarefa.getDataCriacao());
        return responseDTO;
    }
}
