package com.br.passos.vidaNova.vidaNova.resources;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "resources")
@Entity(name = "Resource")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Boolean helped;
    private LocalDate date;

    public Resource(DataPostResource dataPost) {
        this.title = dataPost.title();
        this.category = dataPost.category();
        this.content = dataPost.content();
        this.date = LocalDate.now();
        this.helped = dataPost.helped();
    }

    public void updateDataPost(DataUpdateResource dataPost) {
        if(dataPost.title() != null){
            this.title = dataPost.title();
        }
        if(dataPost.content() != null){
            this.content = dataPost.content();
        }
        if(dataPost.category() != null){
            this.category = dataPost.category();
        }
    }
}
