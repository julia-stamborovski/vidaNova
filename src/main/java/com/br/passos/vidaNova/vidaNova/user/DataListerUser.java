package com.br.passos.vidaNova.vidaNova.user;

public record DataListerUser(
        String name,
        Dependency dependency,
        Boolean sober
) {
    //construtor
    public DataListerUser(User user){
        this(
                user.getName(),
                user.getDependency(),
                user.getSober());
    }
}
