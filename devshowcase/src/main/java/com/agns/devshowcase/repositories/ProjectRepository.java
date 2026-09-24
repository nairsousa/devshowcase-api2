package com.agns.devshowcase.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.agns.devshowcase.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    // Método para buscar projetos filtrando por tecnologia de forma insensível a maiúsculas/minúsculas, com suporte a paginação
    Page<Project> findByTechnologyContainingIgnoreCase(String technology, Pageable pageable);

}