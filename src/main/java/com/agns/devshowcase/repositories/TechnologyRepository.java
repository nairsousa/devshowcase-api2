package com.agns.devshowcase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agns.devshowcase.domain.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {
}