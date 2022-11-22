package com.example.PIClinica.model;

public class Dentista {
    private int id;
    private String nome;
    private String sobrenome;
    private int matriculaDentista;

    public Dentista(int id, String nome, String sobrenome, int matriculaDentista) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matriculaDentista = matriculaDentista;
    }

    public Dentista(String nome, String sobrenome, int matriculaDentista) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matriculaDentista = matriculaDentista;
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

    public int getMatriculaDentista() {
        return matriculaDentista;
    }

    public void setMatriculaDentista(int matriculaDentista) {
        this.matriculaDentista = matriculaDentista;
    }

    @Override
    public String toString() {
        return "Dentista{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", matriculaDentista=" + matriculaDentista +
                '}';
    }
}
