package br.com.projetos.gerenciador_de_tarefas.dto;

import br.com.projetos.gerenciador_de_tarefas.enums.Prioridade;
import br.com.projetos.gerenciador_de_tarefas.enums.Status;

import java.time.LocalDateTime;

public record TarefaResponseDTO(
        int id,
        String titulo,
        String descricao,
        Status status,
        Prioridade prioridade,
        LocalDateTime dataCriacao
) {
}
