package com.example.WebpublicoCrud.dtos;

import jakarta.validation.constraints.NotBlank;

public record FisicaRecordDtos
        (
          @NotBlank String name,
          @NotBlank String cpf,
          @NotBlank String email
//          EnderecoDTos endereco
        ) {


}
