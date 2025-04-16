package br.wesley.docker_spring_lab.controller;

import br.wesley.docker_spring_lab.entity.DockerSpringLabEntity;
import br.wesley.docker_spring_lab.services.DockerSpringLabService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/docker")
public class DockerSpringLabController {

    private final DockerSpringLabService dockerSpringLabService;

    public DockerSpringLabController(DockerSpringLabService dockerSpringLabService) {
        this.dockerSpringLabService = dockerSpringLabService;
    }

    @GetMapping(value = "/teste")
    public ResponseEntity<String> testar (){
        return ResponseEntity.ok().body("API DockerSpringLab está funcionando !" );
    }
}
