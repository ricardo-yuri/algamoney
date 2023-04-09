package com.algamoney.api.service;

import com.algamoney.api.model.Lancamento;
import com.algamoney.api.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento find(Long id){
        Optional<Lancamento> lanc = lancamentoRepository.findById(id);
        if(lanc.isPresent()){
            return lanc.get();
        };
        return null;
    }

    public List<Lancamento> findAll() {
        return lancamentoRepository.findAll();
    }
}
