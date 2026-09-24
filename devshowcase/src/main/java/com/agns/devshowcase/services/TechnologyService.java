package com.agns.devshowcase.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agns.devshowcase.domain.Technology;
import com.agns.devshowcase.dto.TechnologyDTO;
import com.agns.devshowcase.repositories.TechnologyRepository;

@Service
public class TechnologyService {

    private TechnologyRepository repository;

    @Transactional(readOnly = true)
    public List<TechnologyDTO> findAll() {
        List<Technology> list = repository.findAll();
        return list.stream().map(x -> new TechnologyDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public TechnologyDTO insert(TechnologyDTO dto) {
        Technology entity = new Technology();
        entity.setName(dto.getName());
        
        entity = repository.save(entity);
        return new TechnologyDTO(entity);
    }
}