package com.br.passos.vidaNova.vidaNova.streak;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DataCreateStreak(
        LocalDate start,
        Integer current,
        Integer longest,
        @NotNull
        Boolean sober,
        @NotNull
        Feeling feeling,
        @Lob
        String daily_commitment,
        Long userId

) {


}
