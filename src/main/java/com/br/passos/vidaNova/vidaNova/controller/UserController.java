package com.br.passos.vidaNova.vidaNova.controller;

import com.br.passos.vidaNova.vidaNova.user.DataListerUser;
import com.br.passos.vidaNova.vidaNova.user.DataRegisterUser;
import com.br.passos.vidaNova.vidaNova.user.User;
import com.br.passos.vidaNova.vidaNova.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DataRegisterUser data) {
        repository.save(new User(data));
    }

    @GetMapping
    public List<DataListerUser> list() {
        return repository.findAll().stream().map(DataListerUser::new).toList();
    }

}
