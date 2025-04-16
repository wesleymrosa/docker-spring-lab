package br.wesley.docker_spring_lab.services;

import br.wesley.docker_spring_lab.dtos.DockerSpringLabDTO;
import br.wesley.docker_spring_lab.entity.DockerSpringLabEntity;
import br.wesley.docker_spring_lab.repositories.DockerSpringLabRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DockerSpringLabService {
    private final DockerSpringLabRepository dockerSpringLabRepository;
    public DockerSpringLabService(DockerSpringLabRepository dockerSpringLabRepository) {
        this.dockerSpringLabRepository = dockerSpringLabRepository;
    }
    @Transactional
    public DockerSpringLabEntity salvar(DockerSpringLabEntity obj) {
        obj.setId(null);
        return dockerSpringLabRepository.save(obj);
    }
    public List<DockerSpringLabEntity> listarTudo() {
        return dockerSpringLabRepository.findAll();
    }
    public DockerSpringLabEntity buscarPorId(Long id) {
        Optional<DockerSpringLabEntity> obj = dockerSpringLabRepository.findById(id);
        return obj.orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada com o ID: " + id));
    }
    public DockerSpringLabEntity atualizar(Long id, DockerSpringLabDTO dto) {
        DockerSpringLabEntity obj = buscarPorId(id);
        obj.setNome(dto.getNome());
        obj.setIdade(dto.getIdade());
        return dockerSpringLabRepository.save(obj);
    }
    @Transactional
    public void deletar(Long id) {
        dockerSpringLabRepository.deleteById(id);
    }
}

