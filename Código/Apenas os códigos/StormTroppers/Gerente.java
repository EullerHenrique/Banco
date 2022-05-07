package StormTroppers;

import Falcon.Endereco;
import java.io.Serializable;

public class Gerente extends Funcionario implements Serializable {
    // Fields:
    private String dataIngresso;
    private int numAgencia;
    private boolean formacao;
    private String senha;

    // Getters & Setters:
    public String getDataIngresso() {
        return dataIngresso;
    }// getDataIngresso

    public void setDataIngresso(String dataIngresso) {
        this.dataIngresso = dataIngresso;
    }// setDataIngresso

    public int getNumAgencia() {
        return numAgencia;
    }// getNumAgenica

    public void setNumAgencia(int numAgencia) {
        this.numAgencia = numAgencia;
    }// setNumAgencia

    public boolean isFormacao() {
        return formacao;
    }// isFormacao

    public void setFormacao(boolean formacao) {
        this.formacao = formacao;
    }// setFormacao

    public void setSenha(String senha) {
        this.senha = senha;
    }// setSenha

    public String getSenha() {
        return this.senha;
    }// getSenha

    // Methods:
    public String toString() {
        return super.toString() + String.format("Data de Ingresso: %s\n" +
                        "Agencia: %s\nPossui Formação: %b\n", dataIngresso,
                numAgencia, formacao);
    }// toString

    // Constructor:
    public Gerente(String nome, String cpf, String estadoCivil, Endereco endereco, String numCarteira, String rg,
                   String cargo, char sexo, float salario, String dataIngresso, int numAgencia, boolean formacao,
                   String senha) {
        super(nome, cpf, estadoCivil, endereco, numCarteira, rg, cargo, sexo, salario, true);
        this.setDataIngresso(dataIngresso);
        this.setNumAgencia(numAgencia);
        this.setFormacao(formacao);
        this.setSenha(senha);
    }// Gerente
}// Gerente