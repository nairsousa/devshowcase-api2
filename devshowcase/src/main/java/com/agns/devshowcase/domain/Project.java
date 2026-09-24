package com.agns.devshowcase.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_project")
public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String repositoryUrl;
    private String deployedUrl;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    public Project() {}

    public Project(Long id, String title, String description, String repositoryUrl, String deployedUrl, Profile profile) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.repositoryUrl = repositoryUrl;
        this.deployedUrl = deployedUrl;
        this.profile = profile;
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

    public Profile getProfile() { return profile; }
    public void setProfile(Profile profile) { this.profile = profile; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Project other = (Project) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    private Double averageRating = 0.0;
    private Integer upvotes = 0;
    private String technology; // ou uma lista/coleção de tecnologias, dependendo da sua modelagem

public Integer getUpvotes() {
    return upvotes;
}

public void setUpvotes(Integer upvotes) {
    this.upvotes = upvotes;
}

public Double getAverageRating() {
    return averageRating;
}

public void setAverageRating(Double averageRating) {
    this.averageRating = averageRating;
}

public String getTechnology() {
    return technology;
}

public void setTechnology(String technology) {
    this.technology = technology;
}
}