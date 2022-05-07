package Force;

import Falcon.Endereco;
import java.io.Serializable;

public abstract class Pessoa implements Serializable {
    // Fields:
    private String nome, cpf, estadoCivil;
    private Endereco endereco;

    // Getters & Setters:
    public String getNome() {
        return nome;
    }// getNome

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }// setNome

    public String getCpf() {
        return cpf;
    }// getCpf

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }// setCpf;

    public String getEstadoCivil() {
        return estadoCivil;
    }// getEstadoCivil

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil.toUpperCase();
    }// setEstadoCivil

    public Endereco getEndereco() {
        return endereco;
    }// getEndereco

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }// setEndereco

    // Methods:
    public String toString() {
        return String.format("Nome: %s\nCpf: %s\nEndereco: %s\n" +
                        "Estado Civil: %s\n", this.nome, this.cpf,
                this.endereco.toString(), this.estadoCivil);
    }// toString

    // Constructor:
    public Pessoa(String nome, String cpf, String estadoCivil, Endereco endereco) {
        setNome(nome);
        setCpf(cpf);
        setEstadoCivil(estadoCivil);
        setEndereco(endereco);
    }// Pessoa
}// Pessoa