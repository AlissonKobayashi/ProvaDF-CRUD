package com.example.provaDF.personagem;

import com.example.provaDF.itemMagico.ItemMagicoModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TBL_PERSONAGEM")
public class PersonagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String nomeAventureiro;
    @Enumerated(EnumType.STRING)
    private PersonagemEnum classe;
    private int level;
    @OneToMany
    private List<ItemMagicoModel> listaItensMagico = new ArrayList<>();
    private int forca;
    private int defesa;

    public PersonagemModel() {}

    public PersonagemModel(Long id, String nome, String nomeAventureiro, PersonagemEnum classe, int level, List<ItemMagicoModel> listaItensMagico, int forca, int defesa) {
        this.id = id;
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.listaItensMagico = listaItensMagico;

        setForca(forca);
        setDefesa(defesa);
        validarUnicoAmuleto();
    }

    private void validarForcaEDefesa(int forca, int defesa) {
        if (forca < 0 || defesa < 0 || (forca + defesa) > 10) {
            throw new IllegalArgumentException("A soma de Força e Defesa deve ser no máximo 10 pontos e valores não podem ser negativos.");
        }
    }

    private void setForca(int forca) {
        validarForcaEDefesa(forca, this.defesa);
        this.forca = forca;
    }

    private void setDefesa(int defesa) {
        validarForcaEDefesa(this.forca, defesa);
        this.defesa = defesa;
    }

    private void validarUnicoAmuleto() {
        long amuletos = listaItensMagico.stream()
                .filter(item -> item.getTipoItem().toString().equals("AMULETO"))
                .count();

        if (amuletos > 1) {
            throw new IllegalArgumentException("O personagem só pode ter um item mágico do tipo AMULETO.");
        }
    }

    public int getForcaTotal() {
        int bonus = listaItensMagico.stream().mapToInt(ItemMagicoModel::getForca).sum();
        return forca + bonus;
    }

    public int getDefesaTotal() {
        int bonus = listaItensMagico.stream().mapToInt(ItemMagicoModel::getDefesa).sum();
        return defesa + bonus;
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

    public String getNomeAventureiro() {
        return nomeAventureiro;
    }

    public void setNomeAventureiro(String nomeAventureiro) {
        this.nomeAventureiro = nomeAventureiro;
    }

    public PersonagemEnum getClasse() {
        return classe;
    }

    public void setClasse(PersonagemEnum classe) {
        this.classe = classe;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<ItemMagicoModel> getListaItensMagico() {
        return listaItensMagico;
    }

    public void setListaItensMagico(List<ItemMagicoModel> listaItensMagico) {
        this.listaItensMagico = listaItensMagico;
    }

    public int getForca() {
        return forca;
    }

    public int getDefesa() {
        return defesa;
    }
}
