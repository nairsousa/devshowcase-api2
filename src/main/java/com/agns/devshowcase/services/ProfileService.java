package com.agns.devshowcase.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agns.devshowcase.domain.Profile;
import com.agns.devshowcase.dto.ProfileDTO;
import com.agns.devshowcase.repositories.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repository;

    @Transactional(readOnly = true)
    public List<ProfileDTO> findAll() {
        List<Profile> list = repository.findAll();
        return list.stream().map(x -> new ProfileDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProfileDTO findById(Long id) {
        Profile entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado com ID: " + id));
        return new ProfileDTO(entity);
    }

    @Transactional
    public ProfileDTO insert(ProfileDTO dto) {
        Profile entity = new Profile();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setBio(dto.getBio());
        entity.setAvatarUrl(dto.getAvatarUrl());
        entity.setGithubUrl(dto.getGithubUrl());
        
        entity = repository.save(entity);
        
        return new ProfileDTO(entity);
    }
}