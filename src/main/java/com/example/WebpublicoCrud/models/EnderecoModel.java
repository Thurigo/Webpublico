package com.example.WebpublicoCrud.models;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "enderecos")
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEndereco;
    private String rua;
    private Integer numero;
    private String Estado;

    public FisicaModel getPessoafisica() {
        return pessoafisica;
    }

    public JuricaModel getJuridica() {
        return juridica;
    }

    public void setPessoafisica(FisicaModel pessoafisica) {
        this.pessoafisica = pessoafisica;
    }

    public void setJuridica(JuricaModel juridica) {
        this.juridica = juridica;
    }

    @ManyToOne
    @JoinColumn(name = "pessoafisica", nullable = false)
    private  FisicaModel pessoafisica;

    @ManyToOne
    @JoinColumn(name = "juridica_id", nullable = false)
    private  JuricaModel juridica;

    public UUID getIdEndereco() {
        return idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getEstado() {
        return Estado;
    }

    public void setIdEndereco(UUID idEndereco) {
        this.idEndereco = idEndereco;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
