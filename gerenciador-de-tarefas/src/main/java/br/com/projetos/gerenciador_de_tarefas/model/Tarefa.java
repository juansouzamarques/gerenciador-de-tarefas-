package br.com.projetos.gerenciador_de_tarefas.model;

import br.com.projetos.gerenciador_de_tarefas.enums.Prioridade;
import br.com.projetos.gerenciador_de_tarefas.enums.Status;

import java.time.LocalDateTime;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private LocalDateTime dataCriacao;
}
