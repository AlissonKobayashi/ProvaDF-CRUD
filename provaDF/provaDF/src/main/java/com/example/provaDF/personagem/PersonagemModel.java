package com.example.provaDF.personagem;

import jakarta.persistence.*;

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
    private String listaItensMagico;
    private int forca;
    private int defesa;

    public PersonagemModel(){}

    public PersonagemModel(Long id, String nome, String nomeAventureiro, PersonagemEnum classe, int level, String listaItensMagico, int forca, int defesa) {
        this.id = id;
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.listaItensMagico = listaItensMagico;
        this.forca = forca;
        this.defesa = defesa;

        if (forca < 0 || defesa < 0 || (forca + defesa) > 10){
            throw new IllegalArgumentException("A soma de Força e Defesa não pode passar de 10 pontos.");
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

    public String getListaItensMagico() {
        return listaItensMagico;
    }

    public void setListaItensMagico(String listaItensMagico) {
        this.listaItensMagico = listaItensMagico;
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
