package com.agns.devshowcase.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import com.agns.devshowcase.domain.Profile;

public class ProfileDTO {

    private Long id;

    @NotBlank(message = "O nome não pode estar vazio")
    private String name;

    @NotBlank(message = "O e-mail não pode estar vazio")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    private String bio;
    private String avatarUrl;
    private String githubUrl;

    public ProfileDTO() {}

    public ProfileDTO(Profile entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.bio = entity.getBio();
        this.avatarUrl = entity.getAvatarUrl();
        this.githubUrl = entity.getGithubUrl();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public String getGithubUrl() { return githubUrl; }
    public void setGithubUrl(String githubUrl) { this.githubUrl = githubUrl; }
}