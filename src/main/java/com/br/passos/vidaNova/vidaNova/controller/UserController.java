package com.br.passos.vidaNova.vidaNova.controller;

import com.br.passos.vidaNova.vidaNova.user.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

//dtos::Records- DataRegisterUser, DataListerUser, DataUpdateUser

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
    public Page<DataListerUser> list(@PageableDefault(sort = {"name"}) Pageable pageable) {
        return repository.findAll(pageable).map(DataListerUser::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid DataUpdateUser data) {
        //carregar o objeto do banco de dados
        var user = repository.getReferenceById(data.id());
        user.updateData(data);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
