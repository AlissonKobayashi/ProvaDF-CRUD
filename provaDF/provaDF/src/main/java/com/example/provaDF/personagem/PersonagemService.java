package com.example.provaDF.personagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @GetMapping
    public List<PersonagemModel> listarAll(){
        return personagemRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<PersonagemModel> listarById(Long id){
        return personagemRepository.findById(id);
    }

    @PostMapping
    public PersonagemModel criarPersonagem(PersonagemModel personagemModel){
        return personagemRepository.save(personagemModel);
    }

    @PutMapping("/{id}")
    public void editarPersonagem(Long id, PersonagemModel personagemModel){
        personagemModel.setId(id);
        personagemRepository.save(personagemModel);
    }

    @DeleteMapping("/{id}")
    public void excluirPersonagem(Long id){
        personagemRepository.deleteById(id);
    }
}
