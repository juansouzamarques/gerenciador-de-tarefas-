package br.com.projetos.gerenciador_de_tarefas.service;

import br.com.projetos.gerenciador_de_tarefas.dto.TarefaRequestDTO;
import br.com.projetos.gerenciador_de_tarefas.dto.TarefaResponseDTO;
import br.com.projetos.gerenciador_de_tarefas.mapper.TarefaMapper;
import br.com.projetos.gerenciador_de_tarefas.model.Tarefa;
import br.com.projetos.gerenciador_de_tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private final TarefaMapper tarefaMapper = new TarefaMapper();

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public TarefaResponseDTO cadastrar(TarefaRequestDTO requestDTO) {
        Tarefa tarefa = tarefaMapper.toModel(requestDTO);
        Tarefa tarefaSalva = tarefaRepository.save(tarefa);
        return tarefaMapper.toResponseDTO(tarefaSalva);
    }

    public List<TarefaResponseDTO> listarTodas() {
        return tarefaRepository.findAll()
                .stream()
                .map(tarefaMapper::toResponseDTO)
                .toList();
    }

    public Optional<TarefaResponseDTO> buscarPorId(int id) {
        return tarefaRepository.findById(id).map(tarefaMapper::toResponseDTO);
    }


    public boolean excluir(int id) {
        if (!tarefaRepository.existsById(id)) {
            return false;
        }
        tarefaRepository.deleteById(id);
        return true;
    }

}
