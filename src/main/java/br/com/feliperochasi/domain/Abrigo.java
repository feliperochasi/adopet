package br.com.feliperochasi.domain;

import java.util.Arrays;

public class Abrigo {
    private long id;
    private String nome;
    private String telefone;
    private String email;
    private Pet[] pets;

    public Abrigo() {
    }

    public Abrigo(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pet[] getPets() {
        return pets;
    }

    @Override
    public String toString() {
        return """
               "id":%s,"nome":"%s","telefone":"%s","email":"%s"
               """.formatted(this.id, this.nome, this.telefone, this.email);
    }
}
