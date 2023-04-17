package com.br.passos.vidaNova.vidaNova.controller;

import com.br.passos.vidaNova.vidaNova.newBegginer.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("novoComeco")
public class NewBegginerItemController {
    @Autowired
    private newBegginerRepository repository;
    @PostMapping("/{id}/items")
    public NewBegginer addItem(@PathVariable Long id, @RequestBody DataAddNewBegginerItem data) {
        NewBegginer newBegginer = repository.findById(id)
                .orElseThrow();
        NewBegginerItem item = new NewBegginerItem(data.description());
        newBegginer.addItem(item);
        repository.save(newBegginer);
        return newBegginer;
    }

}
