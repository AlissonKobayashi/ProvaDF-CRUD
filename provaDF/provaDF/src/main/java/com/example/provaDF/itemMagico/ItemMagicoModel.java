package com.example.provaDF.itemMagico;


import jakarta.persistence.*;

@Entity
@Table(name = "TBL_ITEMMAGICO")
public class ItemMagicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private ItemMagicoEnum tipoItem;
    private int forca;
    private int defesa;

    public ItemMagicoModel(){}

    public ItemMagicoModel(Long id, String nome, ItemMagicoEnum tipoItem, int forca, int defesa) {
        this.id = id;
        this.nome = nome;
        this.tipoItem = tipoItem;
        this.forca = forca;
        this.defesa = defesa;

        if (forca < 0 || defesa < 0 || forca > 10 || defesa > 10) {
            throw new IllegalArgumentException("Força e Defesa devem estar entre 0 e 10.");
        }

        if (forca == 0 && defesa == 0) {
            throw new IllegalArgumentException("Item não pode ter Força e Defesa iguais a zero.");
        }

        if (tipoItem == ItemMagicoEnum.ARMA && defesa != 0) {
            throw new IllegalArgumentException("Itens do tipo ARMA devem ter defesa igual a zero.");
        }

        if (tipoItem == ItemMagicoEnum.ARMADURA && forca != 0) {
            throw new IllegalArgumentException("Itens do tipo ARMADURA devem ter força igual a zero.");
        }

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ItemMagicoEnum getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(ItemMagicoEnum tipoItem) {
        this.tipoItem = tipoItem;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
}
