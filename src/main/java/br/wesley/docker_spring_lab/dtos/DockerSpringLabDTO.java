package br.wesley.docker_spring_lab.dtos;

import br.wesley.docker_spring_lab.entity.DockerSpringLabEntity;

import java.io.Serializable;

public class DockerSpringLabDTO implements Serializable {
    private static final long serializable = 1L;
    private String nome;
    private Integer idade;

    public DockerSpringLabDTO() {
    }

    public DockerSpringLabDTO(DockerSpringLabEntity obj) {
        this.nome = obj.getNome();
        this.idade = obj.getIdade();
    }
}
