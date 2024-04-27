package com.example.WebpublicoCrud.repositories;


import com.example.WebpublicoCrud.models.EnderecoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnderecoRepositorio extends JpaRepository<EnderecoModel, UUID> {
}
