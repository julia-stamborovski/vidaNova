package com.br.passos.vidaNova.vidaNova.controller;

import com.br.passos.vidaNova.vidaNova.newBegginer.DataAddNewBegginer;
import com.br.passos.vidaNova.vidaNova.newBegginer.NewBegginer;
import com.br.passos.vidaNova.vidaNova.newBegginer.newBegginerRepository;
import com.electronwill.nightconfig.core.conversion.Path;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("novoComeco")
public class NewBegginerController {

    @Autowired
    private newBegginerRepository repository;

    @PostMapping
    @Transactional
    public void add (@RequestBody @Valid DataAddNewBegginer data){
        repository.save(new NewBegginer(data));
    }

    @GetMapping
    public List<NewBegginer> getAll() {
        return repository.findAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        NewBegginer newBegginer = repository.findById(id)
                .orElseThrow(RuntimeException::new);
        repository.delete(newBegginer);

    }
}
