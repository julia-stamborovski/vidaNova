package com.br.passos.vidaNova.vidaNova.newBegginer;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataAddNewBegginer(
        String title,
        @Lob
        String description,
        @NotNull
        Difficult difficult,
        Boolean completed,
        @Lob
        String tips,
        Category category,
        LocalDate start


) {

}
