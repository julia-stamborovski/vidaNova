package com.br.passos.vidaNova.vidaNova.resources;

import jakarta.validation.constraints.NotNull;

public record DataUpdateResource(
        @NotNull
        Long id,
        String title,
        String content,
        Category category

) {


}
