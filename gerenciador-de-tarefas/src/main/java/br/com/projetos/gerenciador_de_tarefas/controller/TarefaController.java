package br.com.projetos.gerenciador_de_tarefas.controller;


import br.com.projetos.gerenciador_de_tarefas.service.TarefaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TarefaController {

    private TarefaService tarefaService = new TarefaService();


}
