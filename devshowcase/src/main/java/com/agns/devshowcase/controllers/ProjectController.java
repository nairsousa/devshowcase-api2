package com.agns.devshowcase.controllers;

import java.net.URI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.agns.devshowcase.dto.ProjectDTO;
import com.agns.devshowcase.services.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<ProjectDTO>> findAll(
            @RequestParam(value = "technology", defaultValue = "") String technology,
            Pageable pageable) {
        Page<ProjectDTO> list = service.findAllPaged(technology, pageable);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> insert(@Valid @RequestBody ProjectDTO dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    @PutMapping("/{id}/upvote")
    public ResponseEntity<ProjectDTO> upvoteProject(@PathVariable Long id) {
        ProjectDTO updatedProject = service.incrementUpvote(id);
        return ResponseEntity.ok(updatedProject);
    }
}