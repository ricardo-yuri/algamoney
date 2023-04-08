package com.algamoney.api.service;

import com.algamoney.api.model.Pessoa;
import com.algamoney.api.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public Pessoa atualizar(Long id, Pessoa pessoa) {
        Optional<Pessoa> originPessoa = pessoaRepository.findById(id);
        if(originPessoa.isPresent()){
            BeanUtils.copyProperties(pessoa, originPessoa.get(), "codigo");
            pessoaRepository.save(originPessoa.get());}
        return originPessoa.get();
    }
}
