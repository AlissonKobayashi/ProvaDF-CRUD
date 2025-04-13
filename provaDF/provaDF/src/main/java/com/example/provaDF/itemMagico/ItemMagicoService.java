package com.example.provaDF.itemMagico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ItemMagicoService {

    @Autowired
    private ItemMagicoRepository itemMagicoRepository;

    @GetMapping
    public List<ItemMagicoModel> listaAll(){
        return itemMagicoRepository.findAll();
    }

    @GetMapping("{/id}")
    public Optional<ItemMagicoModel> listarById(Long id){
        return itemMagicoRepository.findById(id);
    }

    @PostMapping
    public ItemMagicoModel criarItemMagico(ItemMagicoModel itemMagicoModel){
        itemMagicoModel.validar();
        return itemMagicoRepository.save(itemMagicoModel);
    }

    @PutMapping("{/id}")
    public void editarItemMagico(Long id, ItemMagicoModel itemMagicoModel){
        itemMagicoModel.setId(id);
        itemMagicoRepository.save(itemMagicoModel);
    }

    @DeleteMapping("/{id}")
    public void excluirItemMagico(Long id){
        itemMagicoRepository.deleteById(id);
    }
}
