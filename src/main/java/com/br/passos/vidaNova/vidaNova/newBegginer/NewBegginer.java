package com.br.passos.vidaNova.vidaNova.newBegginer;

import com.br.passos.vidaNova.vidaNova.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name="new_begginers")
@Entity(name="NewBegginer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class NewBegginer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Difficult difficult;
    private Boolean completed;
    private String tips;
    @Enumerated(EnumType.STRING)
    private Category category;
    private LocalDate start;
    @OneToMany(mappedBy = "newBegginer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NewBegginerItem> items = new ArrayList<>();
    //@ManyToOne
   // @JoinColumn(name= "user_id")
  //  private User user;

    public NewBegginer(DataAddNewBegginer data) {
        this.title = data.title();
        this.description = data.description();
        this.difficult = data.difficult();
        this.completed = data.completed();
        this.tips = data.tips();
        this.category = data.category();
        this.start = LocalDate.now();
    }

    public void addItem(NewBegginerItem item) {
        item.setNewBegginer(this);
        this.items.add(item);
    }
}
