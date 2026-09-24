package com.agns.devshowcase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agns.devshowcase.domain.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
}