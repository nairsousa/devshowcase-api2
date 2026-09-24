package com.agns.devshowcase.services;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agns.devshowcase.domain.Profile;
import com.agns.devshowcase.domain.Project;
import com.agns.devshowcase.dto.ProjectDTO;
import com.agns.devshowcase.repositories.ProfileRepository;
import com.agns.devshowcase.repositories.ProjectRepository;

@Service
public class ProjectService {
	
@Autowired
    private ProjectRepository repository;

@Autowired
    private ProfileRepository profileRepository;

    @Transactional(readOnly = true)
    public List<ProjectDTO> findAll() {
        List<Project> list = repository.findAll();
        return list.stream().map(x -> new ProjectDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProjectDTO findById(Long id) {
        Project entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com ID: " + id));
        return new ProjectDTO(entity);
    }

    @Transactional
    public ProjectDTO insert(ProjectDTO dto) {
        Project entity = new Project();
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setRepositoryUrl(dto.getRepositoryUrl());
        entity.setDeployedUrl(dto.getDeployedUrl());

        if (dto.getProfileId() != null) {
            Profile profile = profileRepository.findById(dto.getProfileId())
                    .orElseThrow(() -> new RuntimeException("Perfil associado não encontrado"));
            entity.setProfile(profile);
        }

        entity = repository.save(entity);
        return new ProjectDTO(entity);
    }
    public ProjectDTO incrementUpvote(Long id) {
        Project entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        
        int currentVotes = entity.getUpvotes() != null ? entity.getUpvotes() : 0;
        entity.setUpvotes(currentVotes + 1);
        
        entity = repository.save(entity);
        return new ProjectDTO(entity);
    }
    @Transactional(readOnly = true)
    public Page<ProjectDTO> findAllPaged(String technology, Pageable pageable) {
        Page<Project> list;
        if (technology != null && !technology.isEmpty()) {
            list = repository.findByTechnologyContainingIgnoreCase(technology, pageable);
        } else {
            list = repository.findAll(pageable);
        }
        return list.map(x -> new ProjectDTO(x));
    }
}