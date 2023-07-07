package com.exemplothymelaf.poswebsys.rh.controle;

import com.exemplothymelaf.poswebsys.rh.dominio.Pessoa;
import com.exemplothymelaf.poswebsys.rh.dominio.PessoaRepositorio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PessoaControle {

    private PessoaRepositorio pessoaRepo;

    public PessoaControle(PessoaRepositorio pessoaRepo){
        this.pessoaRepo = pessoaRepo;
    }

    @GetMapping("/rh/pessoas")
    public String pessoas(Model model) {
        model.addAttribute("listaPessoas", pessoaRepo.findAll());
        return "rh/pessoas/index";
    }

    @GetMapping("/rh/pessoas/nova")
    public String novaPessoa(Model model){
        model.addAttribute("pessoa", new Pessoa(""));
        return "rh/pessoas/form";
    }

    @PostMapping("rh/pessoas/salvar")
    public String salvarPessoa(@ModelAttribute("pessoa") Pessoa pessoa){
        pessoaRepo.save(pessoa);
        return "redirect:/rh/pessoas";
    }
}
