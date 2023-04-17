package com.br.passos.vidaNova.vidaNova.streak;
import com.br.passos.vidaNova.vidaNova.user.DataListerUser;
import com.br.passos.vidaNova.vidaNova.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name="Streak")
@Entity(name= "Streak")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Streak {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private LocalDate start;
    private Integer current;
    private Integer longest;
    private Boolean sober;
    @Enumerated(EnumType.STRING)
    private Feeling feeling;
    private String daily_commitment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Streak(DataCreateStreak data, User user) {
        this.start = LocalDate.now();
        this.current = data.current();
        this.longest = data.longest();
        this.sober  = data.sober();
        this.feeling = data.feeling();
        this.daily_commitment = data.daily_commitment();
        this.user = user;
    }



}
