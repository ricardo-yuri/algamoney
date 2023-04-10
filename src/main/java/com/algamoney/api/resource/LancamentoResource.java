package com.algamoney.api.resource;

import com.algamoney.api.model.Lancamento;
import com.algamoney.api.model.Pessoa;
import com.algamoney.api.service.LancamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

    @Autowired
    private LancamentoService lancamentoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lancamento create(@RequestBody @Valid Lancamento lanc) {
        return lancamentoService.create(lanc);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> find(@PathVariable Long id) {
        return ResponseEntity.ok(lancamentoService.find(id));
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> findAll() {
        return ResponseEntity.ok(lancamentoService.findAll());
    }
}
