package com.example.WebpublicoCrud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="PessoaFisica")
@Getter
@Setter
public class FisicaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPessoaFisia;
    private  String name;
    private  String cpf;
    private  String email;

    public void setIdPessoaFisia(UUID idPessoaFisia) {
        this.idPessoaFisia = idPessoaFisia;
    }

    public void setEndereco(List<EnderecoModel> endereco) {
        this.endereco = endereco;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public UUID getIdPessoaFisia() {
        return idPessoaFisia;
    }

    public String getEmail() {
        return email;
    }

    public List<EnderecoModel> getEndereco() {
        return endereco;
    }

    @OneToMany(mappedBy = "pessoafisica")
    private List<EnderecoModel> endereco = new ArrayList<>();


}
