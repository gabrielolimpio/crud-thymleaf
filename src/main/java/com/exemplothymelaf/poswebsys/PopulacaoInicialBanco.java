package com.exemplothymelaf.poswebsys;

import com.exemplothymelaf.poswebsys.rh.dominio.Pessoa;
import com.exemplothymelaf.poswebsys.rh.dominio.PessoaRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Transactional
public class PopulacaoInicialBanco implements CommandLineRunner {

    @Autowired
    private PessoaRepositorio pessoaRepo;

    @Override
    public void run(String... args) throws Exception {
        Pessoa p1 = new Pessoa("Joao");
        p1.setDataNascimento(LocalDate.of(1990, 6, 1));
        p1.setEmail("joao@gmail.com");

        Pessoa p2 = new Pessoa("Maria");
        p1.setDataNascimento(LocalDate.of(1991, 8, 1));
        p1.setEmail("maria@gmail.com");

        pessoaRepo.save(p1);
        pessoaRepo.save(p2);
    }


}
