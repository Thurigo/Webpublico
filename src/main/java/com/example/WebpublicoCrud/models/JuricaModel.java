package com.example.WebpublicoCrud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="PessoaJuridica")
@Getter
@Setter
public class JuricaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idJuridica;
    private String razaoSocial;
    private String cnpj;
    private String email;


    @OneToMany(mappedBy = "juridica")
    private List<EnderecoModel> endereço;


    public UUID getIdJuridica() {
        return idJuridica;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setIdJuridica(UUID idJuridica) {
        this.idJuridica = idJuridica;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
