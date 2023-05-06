package com.algamoney.api.resource;

import com.algamoney.api.event.RecursoCriadoEvent;
import com.algamoney.api.model.Lancamento;
import com.algamoney.api.model.Pessoa;
import com.algamoney.api.service.LancamentoService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/lancamento")
public class LancamentoResource {

    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    public ResponseEntity<Lancamento> create(@RequestBody @Valid Lancamento lanc, HttpServletResponse response) {
        Lancamento save = lancamentoService.create(lanc);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, save.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(save);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> findById(@PathVariable Long id) {
        Lancamento lancamento = lancamentoService.findById(id);
        return Objects.nonNull(lancamento) ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Lancamento>> findAll() {
        return ResponseEntity.ok(lancamentoService.findAll());
    }
}
