package com.example.PIClinica.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Paciente")
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence",sequenceName = "paciente_sequence",allocationSize = 1)
    //vai criar e controlar a criação do ids
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "paciente_sequence")
    private int id;
    private String nome;
    private String sobrenome;
    private String endereco;
    private int rg;
    private Date dataAlta;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;

    public Paciente() {
    }

    public Paciente(int id, String nome, String sobrenome, String endereco, int rg, Date dataAlta) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataAlta = dataAlta;
    }

    public Paciente(String nome, String sobrenome, String endereco, int rg, Date dataAlta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.rg = rg;
        this.dataAlta = dataAlta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public Date getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(Date dataAlta) {
        this.dataAlta = dataAlta;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", rg=" + rg +
                ", dataAlta=" + dataAlta +
                '}';
    }
}
