package com.br.passos.vidaNova.vidaNova.newBegginer;

import jakarta.persistence.Lob;

import java.time.LocalDate;

public record DataAddNewBegginer(
        String title,
        @Lob
        String description,
        Difficult difficult,
        Boolean completed,
        @Lob
        String tips,
        Category category,
        LocalDate start


) {

}
