package com.example.provaDF.personagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @GetMapping
    public List<PersonagemModel> listarAll(){
        return personagemService.listarAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemModel> listarById(@PathVariable Long id){
        return personagemService.listarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PersonagemModel> criarPersonagem(@RequestBody PersonagemModel personagemModel){
        PersonagemModel personagemModel1 = personagemService.criarPersonagem(personagemModel);
        return ResponseEntity.ok().body(personagemModel1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editPersonagem(@PathVariable Long id, @RequestBody PersonagemModel personagemModel){
        personagemService.editarPersonagem(id, personagemModel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonagem(@PathVariable Long id){
        personagemService.excluirPersonagem(id);
        return ResponseEntity.noContent().build();
    }
}
