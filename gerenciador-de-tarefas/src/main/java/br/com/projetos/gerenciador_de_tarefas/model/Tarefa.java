package br.com.projetos.gerenciador_de_tarefas.model;

import br.com.projetos.gerenciador_de_tarefas.enums.Prioridade;
import br.com.projetos.gerenciador_de_tarefas.enums.Status;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String titulo;
    private String descricao;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Prioridade prioridade;
    private LocalDateTime dataCriacao;
}
