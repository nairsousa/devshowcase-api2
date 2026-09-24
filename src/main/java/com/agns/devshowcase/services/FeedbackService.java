package com.agns.devshowcase.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agns.devshowcase.domain.Feedback;
import com.agns.devshowcase.domain.Project;
import com.agns.devshowcase.dto.FeedbackDTO;
import com.agns.devshowcase.repositories.FeedbackRepository;
import com.agns.devshowcase.repositories.ProjectRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    @Autowired
    private ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<FeedbackDTO> findAll() {
        List<Feedback> list = repository.findAll();
        return list.stream().map(x -> new FeedbackDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FeedbackDTO findById(Long id) {
        Feedback entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Feedback não encontrado com ID: " + id));
        return new FeedbackDTO(entity);
    }

    @Transactional
    public FeedbackDTO insert(FeedbackDTO dto) {
        Feedback entity = new Feedback();
        entity.setAuthorName(dto.getAuthorName());
        entity.setComment(dto.getComment());
        entity.setRating(dto.getRating());
        
        Project project = null;
        if (dto.getProjectId() != null) {
            project = projectRepository.findById(dto.getProjectId())
                    .orElseThrow(() -> new RuntimeException("Projeto associado não encontrado"));
            entity.setProject(project);
        }
        
        entity = repository.save(entity);
        
        // Calcula e atualiza a média de notas do projeto se ele existir
        if (project != null) {
            List<Feedback> projectFeedbacks = repository.findByProjectId(project.getId());
            
            double average = projectFeedbacks.stream()
                    .mapToInt(Feedback::getRating)
                    .average()
                    .orElse(0.0);
                    
            project.setAverageRating(average);
            projectRepository.save(project);
        }
        
        return new FeedbackDTO(entity);
    }
}