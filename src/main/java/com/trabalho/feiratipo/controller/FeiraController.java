package com.trabalho.feiratipo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.trabalho.feiratipo.domain.Feira;
import com.trabalho.feiratipo.dto.FeiraRequest;
import com.trabalho.feiratipo.service.FeiraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/feiras")
@CrossOrigin(origins = "*")
public class FeiraController {

    private final FeiraService feiraService;

    public FeiraController(FeiraService feiraService) {
        this.feiraService = feiraService;
    }

    @GetMapping
    public List<Feira> listar() {
        return feiraService.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Feira salvar(@RequestBody @Valid FeiraRequest request) {
        return feiraService.salvar(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        feiraService.remover(id);
    }
}