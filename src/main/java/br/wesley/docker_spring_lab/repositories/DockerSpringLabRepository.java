package br.wesley.docker_spring_lab.repositories;

import br.wesley.docker_spring_lab.entity.DockerSpringLabEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DockerSpringLabRepository extends JpaRepository <DockerSpringLabEntity, Long> {
}
