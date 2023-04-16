package com.br.passos.vidaNova.vidaNova.controller;

import com.br.passos.vidaNova.vidaNova.resources.*;
import com.electronwill.nightconfig.core.conversion.Path;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("resources")
public class ResourceController {
    @Autowired
    private ResourceRepository repositoryResource;

    @PostMapping
    @Transactional
    public void post(@RequestBody @Valid DataPostResource dataPost) {
        repositoryResource.save(new Resource(dataPost));
    }
    @GetMapping
    public Page<DataListerResource> list(@PageableDefault(sort = {"date"}) Pageable pageable){
        return repositoryResource.findAll(pageable).map(DataListerResource::new);
    }

    @PutMapping
    @Transactional
    public void updatePost(@RequestBody @Valid DataUpdateResource dataPost){
        var resource = repositoryResource.getReferenceById(dataPost.id());
        resource.updateDataPost(dataPost);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePost(@PathVariable Long id){
        repositoryResource.deleteById(id);
    }

}
