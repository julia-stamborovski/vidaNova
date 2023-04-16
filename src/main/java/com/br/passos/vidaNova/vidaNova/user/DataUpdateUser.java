package com.br.passos.vidaNova.vidaNova.user;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUser(

        @NotNull
        Long id,
        String name,
        String email,
        String password,
        Dependency dependency
) {
}
