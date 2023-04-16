package com.br.passos.vidaNova.vidaNova.user;

import jakarta.validation.constraints.*;

public record DataRegisterUser(
        @NotBlank
        String name,
        @Email
        @NotBlank
        String email,
        @NotNull
        Integer age,
        @NotBlank
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        //@Pattern(
        //regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).*$",
       // message = "A senha deve ter pelo menos uma letra maiúscula, uma letra minúscula, um número, um caractere especial e não pode conter espaços em branco")
        String password,
        @NotNull
        Dependency dependency,
        @NotNull
        Boolean sober
) {
}
