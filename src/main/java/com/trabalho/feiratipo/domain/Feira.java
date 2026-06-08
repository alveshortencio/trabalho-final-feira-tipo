package com.trabalho.feiratipo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "feira")
public class Feira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String logradouro;
    private String bairro;
    private boolean ativa;

    @ManyToOne
    @JoinColumn(name = "tipo_feira_id")
    private TipoFeira tipoFeira;

    public Feira() {}

    public Feira(Long id, String nome, String logradouro, String bairro, boolean ativa, TipoFeira tipoFeira) {
        this.id = id;
        this.nome = nome == null ? null : nome.trim();
        this.logradouro = logradouro == null ? null : logradouro.trim();
        this.bairro = bairro == null ? null : bairro.trim();
        this.ativa = ativa;
        this.tipoFeira = tipoFeira;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public boolean isAtiva() { return ativa; }
    public void setAtiva(boolean ativa) { this.ativa = ativa; }

    public TipoFeira getTipoFeira() { return tipoFeira; }
    public void setTipoFeira(TipoFeira tipoFeira) { this.tipoFeira = tipoFeira; }
}