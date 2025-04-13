package com.example.provaDF.itemMagico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itemMagico")
public class ItemMagicoController {

    @Autowired
    private ItemMagicoService itemMagicoService;

    @GetMapping
    public List<ItemMagicoModel> findAll(){
        return itemMagicoService.listaAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemMagicoModel> listarById(@PathVariable Long id){
        return itemMagicoService.listarById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ItemMagicoModel> createItem(@RequestBody ItemMagicoModel itemMagicoModel){
        ItemMagicoModel itemMagicoModel1 = itemMagicoService.criarItemMagico(itemMagicoModel);
        return ResponseEntity.ok().body(itemMagicoModel1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editItemMagico(@PathVariable Long id, @RequestBody ItemMagicoModel itemMagicoModel){
        itemMagicoService.editarItemMagico(id, itemMagicoModel);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarItemMagico(@PathVariable Long id){
        itemMagicoService.excluirItemMagico(id);
        return ResponseEntity.noContent().build();
    }
}
