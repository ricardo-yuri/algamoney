package com.algamoney.api.resource;

import com.algamoney.api.event.RecursoCriadoEvent;
import com.algamoney.api.model.Categoria;
import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.CategoriaRepository;
import com.algamoney.api.repository.PessoaRepository;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.apache.catalina.core.ApplicationPushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> create(@Valid @RequestBody Pessoa entity, HttpServletResponse response) {
        Pessoa pessoa = pessoaRepository.save(entity);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoa.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }
}
