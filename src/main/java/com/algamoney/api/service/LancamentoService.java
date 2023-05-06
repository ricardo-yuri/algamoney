package com.algamoney.api.service;

import com.algamoney.api.event.RecursoCriadoEvent;
import com.algamoney.api.model.Lancamento;
import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.LancamentoRepository;
import com.algamoney.api.repository.PessoaRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Lancamento create(Lancamento lancamento) {
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento findById(Long id){
        return lancamentoRepository.findById(id).orElse(null);
    }

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }
}
