package com.parcial.web.parcial.service;

import com.parcial.web.parcial.models.celular.Celular;
import com.parcial.web.parcial.models.celular.DTO.SimpleCelDTO;
import com.parcial.web.parcial.repository.CelularRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CelularService {

    @Autowired
    private CelularRepository celularRepository;

    @Autowired
    private ModelMapper modelMapper;

    public SimpleCelDTO createCelular(SimpleCelDTO simpleCelDTO) {
        Celular celular = modelMapper.map(simpleCelDTO, Celular.class);
        Celular savedCelular = celularRepository.save(celular);
        return modelMapper.map(savedCelular, SimpleCelDTO.class);
    }

    public SimpleCelDTO updateCelular(UUID id, SimpleCelDTO simpleCelDTO) {
        Optional<Celular> optionalCelular = celularRepository.findById(id);
        if (optionalCelular.isPresent()) {
            Celular celular = optionalCelular.get();
            modelMapper.map(simpleCelDTO, celular);
            Celular updatedCelular = celularRepository.save(celular);
            return modelMapper.map(updatedCelular, SimpleCelDTO.class);
        } else {
            throw new RuntimeException("Celular not found");
        }
    }

    public List<SimpleCelDTO> getAllCelulares() {
        List<Celular> celulares = (List<Celular>) celularRepository.findAll();
        return celulares.stream()
                .map(celular -> modelMapper.map(celular, SimpleCelDTO.class))
                .collect(Collectors.toList());
    }

    public SimpleCelDTO getCelularById(UUID id) {
        Optional<Celular> optionalCelular = celularRepository.findById(id);
        if (optionalCelular.isPresent()) {
            return modelMapper.map(optionalCelular.get(), SimpleCelDTO.class);
        } else {
            throw new RuntimeException("Celular not found");
        }
    }

    public void deleteCelular(UUID id) {
        Optional<Celular> optionalCelular = celularRepository.findById(id);
        if (optionalCelular.isPresent()) {
            Celular celular = optionalCelular.get();
            celular.setDeleted(true);
            celularRepository.save(celular);
        } else {
            throw new RuntimeException("Celular not found");
        }
    }
}
