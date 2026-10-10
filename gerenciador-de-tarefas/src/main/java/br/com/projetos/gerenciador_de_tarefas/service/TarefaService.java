package br.com.projetos.gerenciador_de_tarefas.service;

import br.com.projetos.gerenciador_de_tarefas.dto.TarefaRequestDTO;
import br.com.projetos.gerenciador_de_tarefas.dto.TarefaResponseDTO;
import br.com.projetos.gerenciador_de_tarefas.mapper.TarefaMapper;
import br.com.projetos.gerenciador_de_tarefas.model.Tarefa;
import br.com.projetos.gerenciador_de_tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper = new TarefaMapper();

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaResponseDTO cadastrar(TarefaRequestDTO requestDTO) {
        Tarefa tarefa = tarefaMapper.toModel(requestDTO);
        Tarefa tarefaSalva = tarefaRepository.salvar(tarefa);
        return tarefaMapper.toResponseDTO(tarefaSalva);
    }

    public List<TarefaResponseDTO> listarTodas() {
        return tarefaRepository.listarTodas()
                .stream()
                .map(tarefaMapper::toResponseDTO)
                .toList();
    }



    public boolean excluir(int id) {
        return tarefaRepository.excluirPorId(id);
    }
}
