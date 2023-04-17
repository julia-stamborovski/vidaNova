package com.br.passos.vidaNova.vidaNova.user;

import jakarta.persistence.*;
import lombok.*;

@Table(name= "users")
@Entity(name= "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private String password;
    @Enumerated(EnumType.STRING)
    private Dependency dependency;
    private Boolean sober;

    public User(DataRegisterUser data) {
        this.name = data.name();
        this.email = data.email();
        this.age  = data.age();
        this.password = data.password();
        this.dependency = data.dependency();
        this.sober = data.sober();
    }

    public User(Long id) {
        this.id = id;
        this.name = name;
        this.dependency = dependency;
        this.sober = sober;
    }

    public void updateData(DataUpdateUser data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.email() != null) {
            this.email = data.email();
        }
        if (data.password() != null) {
            this.password = data.password();
        }
        if (data.dependency() != null) {
            this.dependency = data.dependency();
        }
    }
}
