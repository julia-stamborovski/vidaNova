package com.br.passos.vidaNova.vidaNova.resources;

import java.time.LocalDate;

public record DataListerResource(
        Long id,
        String title,
        String content,
        Category category,
        Boolean helped,
        LocalDate date
) {
    public DataListerResource(Resource resource){
        this (
                resource.getId(),
                resource.getTitle(),
                resource.getContent(),
                resource.getCategory(),
                resource.getHelped(),
                resource.getDate()
        );
    }

}
