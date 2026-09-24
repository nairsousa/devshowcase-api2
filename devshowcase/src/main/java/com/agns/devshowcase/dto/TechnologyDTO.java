package com.agns.devshowcase.dto;

import jakarta.validation.constraints.NotBlank;
import com.agns.devshowcase.domain.Technology;

public class TechnologyDTO {

    private Long id;

    @NotBlank(message = "O nome da tecnologia não pode estar vazio")
    private String name;

    public TechnologyDTO() {}

    public TechnologyDTO(Technology entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}