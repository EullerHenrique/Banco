package StormTroppers;

import Falcon.Endereco;
import Force.Pessoa;
import java.io.Serializable;


public class Cliente extends Pessoa implements Serializable {
    // Fields:
    private String escolaridade, dataNasc;

    // Getters & Setters:
    public String getEscolaridade() {
        return escolaridade;
    }// getEscolaridade

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade.toUpperCase();
    }// setEscolaridade

    public String getDataNasc() {
        return dataNasc;
    }// getDataNascc

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }// setDataNasc

    // Mehtods:
    public String toString() {
        return super.toString() + String.format("Escolaridade: %s\n" +
                "Data de Nascimento: %s\n", escolaridade, dataNasc);
    }// toString

    // Constructor:
    public Cliente(String nome, String cpf, String estadoCivil, Endereco endereco,
                   String escolaridade, String dataNasc) {
        super(nome, cpf, estadoCivil, endereco);
        this.setEscolaridade(escolaridade);
        this.setDataNasc(dataNasc);
    }// Cliente
}// Cliente