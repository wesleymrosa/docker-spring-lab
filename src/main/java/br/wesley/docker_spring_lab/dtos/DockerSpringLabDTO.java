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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
