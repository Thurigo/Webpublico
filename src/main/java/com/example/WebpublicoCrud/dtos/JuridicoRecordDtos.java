package com.example.WebpublicoCrud.dtos;

import jakarta.validation.constraints.NotBlank;

public record JuridicoRecordDtos
        (
                @NotBlank String razaoSocial,
                @NotBlank String cnpj,
                @NotBlank String email
        ) {
}
