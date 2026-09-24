package com.agns.devshowcase.dto;

import jakarta.validation.constraints.NotBlank;
import com.agns.devshowcase.domain.Project;

public class ProjectDTO {

    private Long id;

    @NotBlank(message = "O título do projeto não pode estar vazio")
    private String title;

    private String description;
    private String repositoryUrl;
    private String deployedUrl;
    private Long profileId;

    public ProjectDTO() {}

    public ProjectDTO(Project entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.repositoryUrl = entity.getRepositoryUrl();
        this.deployedUrl = entity.getDeployedUrl();
        if (entity.getProfile() != null) {
            this.profileId = entity.getProfile().getId();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getRepositoryUrl() { return repositoryUrl; }
    public void setRepositoryUrl(String repositoryUrl) { this.repositoryUrl = repositoryUrl; }

    public String getDeployedUrl() { return deployedUrl; }
    public void setDeployedUrl(String deployedUrl) { this.deployedUrl = deployedUrl; }

    public Long getProfileId() { return profileId; }
    public void setProfileId(Long profileId) { this.profileId = profileId; }
}