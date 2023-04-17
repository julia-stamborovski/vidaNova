package com.br.passos.vidaNova.vidaNova.controller;

import com.br.passos.vidaNova.vidaNova.streak.DataCreateStreak;
import com.br.passos.vidaNova.vidaNova.streak.Streak;
import com.br.passos.vidaNova.vidaNova.streak.StreakRepository;
import com.br.passos.vidaNova.vidaNova.user.User;
import com.br.passos.vidaNova.vidaNova.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("streaks")
public class StreakController {
    @Autowired
    private StreakRepository repositoryStreak;

    @Autowired
    private UserRepository repository;

    @PostMapping("/{userId}")
    public ResponseEntity<Streak> createStreak(@PathVariable Long userId, @RequestBody DataCreateStreak data) {
        Optional<User> optionalUser = repository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            Streak streak = new Streak(data, user);
            repositoryStreak.save(streak);
            return ResponseEntity.ok(streak);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Streak> getStreakById(@PathVariable Long id) {
        Optional<Streak> optionalStreak = repositoryStreak.findById(id);
        if (optionalStreak.isPresent()) {
            Streak streak = optionalStreak.get();
            return ResponseEntity.ok(streak);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}