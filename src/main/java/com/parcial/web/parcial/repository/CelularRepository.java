package com.parcial.web.parcial.repository;

import org.springframework.data.repository.CrudRepository;
import com.parcial.web.parcial.models.celular.Celular;

import java.util.Optional;
import java.util.UUID;

public interface CelularRepository extends CrudRepository<Celular, UUID> {
    Optional<Celular> findBySerial(String serial);
    Optional<Celular> findById(UUID id);
}
