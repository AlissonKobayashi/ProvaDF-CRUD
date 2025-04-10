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
    private String classe;
    private int level;
    private String listaItensMagico;
    private int forca;
    private int defesa;

    public PersonagemModel(){}

    public PersonagemModel(Long id, String nome, String nomeAventureiro, String classe, int level, String listaItensMagico, int forca, int defesa) {
        this.id = id;
        this.nome = nome;
        this.nomeAventureiro = nomeAventureiro;
        this.classe = classe;
        this.level = level;
        this.listaItensMagico = listaItensMagico;
        this.forca = forca;
        this.defesa = defesa;
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

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
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
