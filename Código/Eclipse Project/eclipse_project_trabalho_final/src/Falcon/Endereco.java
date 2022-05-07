package Falcon;

import java.io.Serializable;

public class Endereco implements Serializable {
    // Fields:
    private int numero;
    private String lograd, nome, bairro, cidade, estado;

    // Getters & Setters:
    public int getNumero() {
        return numero;
    }// getNumero

    public void setNumero(int numero) {
        if (numero > 0)
            this.numero = numero;
    }// setNumero

    public String getLograd() {
        return lograd;
    }// getLograd

    public void setLograd(String lograd) {
        this.lograd = lograd.toUpperCase();
    }// setLograd

    public String getNome() {
        return nome;
    }// getNome

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }// setNome

    public String getBairro() {
        return bairro;
    }// getBairro

    public void setBairro(String bairro) {
        this.bairro = bairro.toUpperCase();
    }// setBairro

    public String getCidade() {
        return cidade;
    }// getCidade

    public void setCidade(String cidade) {
        this.cidade = cidade.toUpperCase();
    }// setCidade

    public String getEstado() {
        return estado;
    }// getEstado

    public void setEstado(String estado) {
        this.estado = estado.toUpperCase();
    }// setEstado

    // Methods:
    public String toString() {
        return String.format("%s %s, %d, %s-%s, %s",
                lograd, nome, numero, cidade, estado, bairro);
    }// toString

    // Constructor:
    public Endereco(int numero, String lograd, String nome, String bairro,
                    String cidade, String estado) {
        setNumero(numero);
        setLograd(lograd);
        setNome(nome);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
    }// Endereco
}// Endereco