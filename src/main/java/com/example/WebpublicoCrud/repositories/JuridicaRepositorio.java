package com.example.WebpublicoCrud.repositories;


import com.example.WebpublicoCrud.models.JuricaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JuridicaRepositorio extends JpaRepository<JuricaModel, UUID> {
}
