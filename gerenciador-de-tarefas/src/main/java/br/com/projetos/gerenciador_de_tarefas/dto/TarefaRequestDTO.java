package br.com.projetos.gerenciador_de_tarefas.dto;

import br.com.projetos.gerenciador_de_tarefas.enums.Prioridade;
import br.com.projetos.gerenciador_de_tarefas.enums.Status;

public record TarefaRequestDTO(
        String titulo,
        String descricao,
        Status status,
        Prioridade prioridade
) {
}
