package com.br.passos.vidaNova.vidaNova.newBegginer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="NewBegginerItem")
@Table(name = "new_begginers_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewBegginerItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String description;
    private boolean completed;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="new_begginers_id")
    @JsonIgnore
    private NewBegginer newBegginer;

    public NewBegginerItem(String description){
        this.description = description;
        this.completed = completed;
    }
}
