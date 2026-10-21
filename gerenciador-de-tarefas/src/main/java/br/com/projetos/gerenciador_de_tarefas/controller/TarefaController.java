package br.com.projetos.gerenciador_de_tarefas.controller;


import br.com.projetos.gerenciador_de_tarefas.dto.TarefaRequestDTO;
import br.com.projetos.gerenciador_de_tarefas.dto.TarefaResponseDTO;
import br.com.projetos.gerenciador_de_tarefas.repository.TarefaRepository;
import br.com.projetos.gerenciador_de_tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {



    private final TarefaService tarefaService;
    private final TarefaRepository tarefaRepository;

    public TarefaController(TarefaService tarefaService, TarefaRepository tarefaRepository) {
        this.tarefaService = tarefaService;
        this.tarefaRepository = tarefaRepository;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<TarefaResponseDTO> cadastrar(@RequestBody TarefaRequestDTO requestDTO) {
        TarefaResponseDTO tarefaCadastrada = tarefaService.cadastrar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaCadastrada);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TarefaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(tarefaService.listarTodas());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<List<TarefaResponseDTO>> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(tarefaService.buscarPorId(id));
    }




    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> excluirFisicamente(@PathVariable Long id) {
        // Verifica se o registro realmente existe antes de tentar deletar
        if (!tarefaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Executa a exclusão física direto no banco de dados
        tarefaRepository.deleteById(id);

        // Retorna o status 204 No Content (sucesso, sem corpo na resposta)
        return ResponseEntity.noContent().build();
    }
}
