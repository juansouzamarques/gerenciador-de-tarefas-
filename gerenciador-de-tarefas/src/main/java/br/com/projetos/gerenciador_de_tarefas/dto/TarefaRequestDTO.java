package br.com.projetos.gerenciador_de_tarefas.dto;

import br.com.projetos.gerenciador_de_tarefas.enums.Prioridade;
import br.com.projetos.gerenciador_de_tarefas.enums.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TarefaRequestDTO {
    private String titulo;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
}
