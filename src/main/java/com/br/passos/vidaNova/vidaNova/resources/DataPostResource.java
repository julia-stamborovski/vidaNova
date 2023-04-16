package com.br.passos.vidaNova.vidaNova.resources;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataPostResource(
        @NotBlank
        String title,
        @NotBlank
        @Lob //O conteúdo é armazenado como uma string grande
        String content,
        @NotNull
        Category category,
        Boolean helped,

        LocalDate date


        ) {

}
