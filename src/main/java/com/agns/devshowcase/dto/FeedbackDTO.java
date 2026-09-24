package com.agns.devshowcase.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.agns.devshowcase.domain.Feedback;

public class FeedbackDTO {

    private Long id;

    @NotBlank(message = "O nome do autor não pode estar vazio")
    private String authorName;

    @NotBlank(message = "O comentário não pode estar vazio")
    private String comment;

    @NotNull(message = "A nota (rating) é obrigatória")
    @Min(value = 1, message = "A nota mínima é 1")
    @Max(value = 5, message = "A nota máxima é 5")
    private Integer rating;

    private Long projectId;

    public FeedbackDTO() {}

    public FeedbackDTO(Feedback entity) {
        this.id = entity.getId();
        this.authorName = entity.getAuthorName();
        this.comment = entity.getComment();
        this.rating = entity.getRating();
        if (entity.getProject() != null) {
            this.projectId = entity.getProject().getId();
        }
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuthorName() { return authorName; }
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
}