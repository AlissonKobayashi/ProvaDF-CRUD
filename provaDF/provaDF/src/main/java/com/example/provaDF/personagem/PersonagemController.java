package com.example.provaDF.personagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    private List<PersonagemModel> listarAll(){
        return personagemService.listarAll();
    }

    @GetMapping("/{id}")
    private Optional<PersonagemModel> listarById(@RequestParam Long id){
        return personagemService.listarById(id);
    }

    @PostMapping
    private ResponseEntity<PersonagemModel> criarPersonagem(@RequestBody PersonagemModel personagemModel){
        PersonagemModel personagemModel1 = personagemService.criarPersonagem(personagemModel);
        return ResponseEntity.ok().body(personagemModel1);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Void> editPersonagem(@RequestParam Long id, @RequestBody PersonagemModel personagemModel){
        personagemService.editarPersonagem(id, personagemModel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deletePersonagem(@RequestParam Long id){
        personagemService.excluirPersonagem(id);
        return ResponseEntity.noContent().build();
    }
}
