package com.br.passos.vidaNova.vidaNova.user;

public record DataListerUser(
        Long id,
        String name,
        Dependency dependency,
        Boolean sober
) {
    //construtor
    public DataListerUser(User user){
        this(
                user.getId(),
                user.getName(),
                user.getDependency(),
                user.getSober());
    }
    public static DataListerUser fromUser(User user) {
        return new DataListerUser(user.getId(), user.getName(), user.getDependency(), user.getSober());
    }
}
