package br.com.projetos.gerenciador_de_tarefas.controller;


import br.com.projetos.gerenciador_de_tarefas.dto.TarefaRequestDTO;
import br.com.projetos.gerenciador_de_tarefas.dto.TarefaResponseDTO;
import br.com.projetos.gerenciador_de_tarefas.service.TarefaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@CrossOrigin(origins= "*")
public class TarefaController {



    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
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
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        Optional<TarefaResponseDTO> tarefa = tarefaService.buscarPorId(id);
        if (tarefa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "Tarefa com id " + id + " não encontrada."));
        }
        return ResponseEntity.ok(tarefa.get());
    }




    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Map<String, String>> excluirFisicamente(@PathVariable int id) {
        if (!tarefaService.excluir(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensagem", "Tarefa com id " + id + " não encontrada."));
        }
        return ResponseEntity.ok(Map.of("mensagem", "Tarefa com id " + id + " excluída com sucesso."));
    }

}
