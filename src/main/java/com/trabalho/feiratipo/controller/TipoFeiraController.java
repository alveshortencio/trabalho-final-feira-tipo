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

import com.trabalho.feiratipo.domain.TipoFeira;
import com.trabalho.feiratipo.dto.TipoFeiraRequest;
import com.trabalho.feiratipo.service.TipoFeiraService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/tipos-feira")
@CrossOrigin(origins = "*")
public class TipoFeiraController {

    private final TipoFeiraService tipoFeiraService;

    public TipoFeiraController(TipoFeiraService tipoFeiraService) {
        this.tipoFeiraService = tipoFeiraService;
    }

    @GetMapping
    public List<TipoFeira> listar() {
        return tipoFeiraService.listarTodos();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoFeira salvar(@RequestBody @Valid TipoFeiraRequest request) {
        return tipoFeiraService.salvar(request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        tipoFeiraService.remover(id);
    }
}