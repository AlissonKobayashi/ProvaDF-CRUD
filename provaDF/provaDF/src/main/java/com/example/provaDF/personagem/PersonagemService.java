package com.example.provaDF.personagem;

import com.example.provaDF.itemMagico.ItemMagicoModel;
import com.example.provaDF.itemMagico.ItemMagicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;

    public List<PersonagemModel> listarAll(){
        return personagemRepository.findAll();
    }

    public Optional<PersonagemModel> listarById(Long id){
        return personagemRepository.findById(id);
    }

    public PersonagemModel criarPersonagem(PersonagemModel personagemModel){
        return personagemRepository.save(personagemModel);
    }

    public void editarPersonagem(Long id, PersonagemModel personagemModel){
        personagemModel.setId(id);
        personagemRepository.save(personagemModel);
    }

    public void excluirPersonagem(Long id){
        personagemRepository.deleteById(id);
    }

    public List<ItemMagicoModel> listarItensPorPersonagem(Long idPersonagem) {
        PersonagemModel personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));
        return personagem.getListaItensMagico();
    }

    public void adicionarItemMagico(Long idPersonagem, Long idItem) {
        PersonagemModel personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        ItemMagicoModel item = itemMagicoRepository.findById(idItem)
                .orElseThrow(() -> new RuntimeException("Item mágico não encontrado"));

        if (item.getTipoItem().toString().equals("AMULETO")) {
            boolean jaTemAmuleto = personagem.getListaItensMagico().stream()
                    .anyMatch(i -> i.getTipoItem().toString().equals("AMULETO"));
            if (jaTemAmuleto) {
                throw new IllegalArgumentException("O personagem já possui um AMULETO.");
            }
        }

        personagem.getListaItensMagico().add(item);
        personagemRepository.save(personagem);
    }

    public void removerItemMagico(Long idPersonagem, Long idItem) {
        PersonagemModel personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        personagem.getListaItensMagico().removeIf(item -> item.getId().equals(idItem));
        personagemRepository.save(personagem);
    }

    public Optional<ItemMagicoModel> buscarAmuletoDoPersonagem(Long idPersonagem) {
        PersonagemModel personagem = personagemRepository.findById(idPersonagem)
                .orElseThrow(() -> new RuntimeException("Personagem não encontrado"));

        return personagem.getListaItensMagico().stream()
                .filter(item -> item.getTipoItem().toString().equals("AMULETO"))
                .findFirst();
    }
}
