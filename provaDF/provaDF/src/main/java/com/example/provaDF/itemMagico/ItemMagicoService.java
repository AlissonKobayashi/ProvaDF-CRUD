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

    public List<ItemMagicoModel> listaAll(){
        return itemMagicoRepository.findAll();
    }

    public Optional<ItemMagicoModel> listarById(Long id){
        return itemMagicoRepository.findById(id);
    }

    public ItemMagicoModel criarItemMagico(ItemMagicoModel itemMagicoModel){
        itemMagicoModel.validar();
        return itemMagicoRepository.save(itemMagicoModel);
    }

    public void editarItemMagico(Long id, ItemMagicoModel itemMagicoModel){
        itemMagicoModel.setId(id);
        itemMagicoRepository.save(itemMagicoModel);
    }

    public void excluirItemMagico(Long id){
        itemMagicoRepository.deleteById(id);
    }
}
