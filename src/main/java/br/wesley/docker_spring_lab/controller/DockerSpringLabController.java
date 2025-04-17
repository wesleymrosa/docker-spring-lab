package br.wesley.docker_spring_lab.controller;

import br.wesley.docker_spring_lab.dtos.DockerSpringLabDTO;
import br.wesley.docker_spring_lab.entity.DockerSpringLabEntity;
import br.wesley.docker_spring_lab.services.DockerSpringLabService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/docker")
public class DockerSpringLabController {

    private final DockerSpringLabService service;

    public DockerSpringLabController(DockerSpringLabService service) {
        this.service = service;
    }

    @GetMapping(value = "/teste")
    public ResponseEntity<String> testar() {
        return ResponseEntity.ok().body("API DockerSpringLab está funcionando !");
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<DockerSpringLabEntity>> findAll() {
        return ResponseEntity.ok(service.listarTudo());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<DockerSpringLabEntity> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    // CREATE
    @PostMapping
    public ResponseEntity<DockerSpringLabEntity> create(@RequestBody DockerSpringLabEntity entity) {
        DockerSpringLabEntity created = service.salvar(entity);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<DockerSpringLabEntity> update(@PathVariable Long id, @RequestBody DockerSpringLabDTO dto) {
        DockerSpringLabEntity updated = service.atualizar(id, dto);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
