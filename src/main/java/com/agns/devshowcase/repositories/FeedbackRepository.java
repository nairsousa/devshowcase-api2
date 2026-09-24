package com.agns.devshowcase.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.agns.devshowcase.domain.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    List<Feedback> findByProjectId(Long projectId);

}