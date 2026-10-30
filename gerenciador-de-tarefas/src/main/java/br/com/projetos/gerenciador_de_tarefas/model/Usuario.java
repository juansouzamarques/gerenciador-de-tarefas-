package br.com.projetos.gerenciador_de_tarefas.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private long id;
    private String nome;
    private String email;
    private int senha;
    private String cep;
}
