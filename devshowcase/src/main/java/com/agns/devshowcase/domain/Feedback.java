package com.agns.devshowcase.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_feedback")
public class Feedback implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authorName;
    private String comment;
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Feedback() {}

    public Feedback(Long id, String authorName, String comment, Integer rating, Project project) {
        this.id = id;
        this.authorName = authorName;
        this.comment = comment;
        this.rating = rating;
        this.project = project;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public Project getProject() { return project; }
    public void setProject(Project project) { this.project = project; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Feedback other = (Feedback) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}