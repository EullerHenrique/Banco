package StormTroppers;

import Falcon.Endereco;
import Force.Pessoa;
import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {
    // Fields:
    private String numCarteira, rg, cargo;
    private char sexo;
    private float salario;
    private boolean ehGerente;

    // Getters & Setters:
    public String getNumCarteira() {
        return numCarteira;
    }// getNumCarteira

    public void setNumCarteira(String numCarteira) {
        this.numCarteira = numCarteira;
    }// setNumCarteira

    public String getRg() {
        return rg;
    }// getRg

    public void setRg(String rg) {
        this.rg = rg;
    }// setRg

    public String getCargo() {
        return cargo;
    }// getCargo

    public void setCargo(String cargo) {
        this.cargo = cargo.toUpperCase();
    }// setCargo

    public char getSexo() {
        return sexo;
    }// getSexo

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }// setSexo

    public float getSalario() {
        return salario;
    }// getSalario

    public void setSalario(float salario) {
        this.salario = salario;
    }// setSalario

    public boolean isGerente() {
        return ehGerente;
    }// isGerente

    public void setEhGerente(boolean ehGerente) {
        this.ehGerente = ehGerente;
    }// setEhGerente

    // Methods:
    public String toString() {
        return super.toString() + String.format("numCarteira: %s\nRG: %s\nSexo: %c\n" +
                "Cargo: %s\n", numCarteira, rg, sexo, cargo);
    }// toString

    // Contructor:
    public Funcionario(String nome, String cpf, String estadoCivil, Endereco endereco, String numCarteira, String rg,
                       String cargo, char sexo, float salario, boolean ehGerente) {
        super(nome, cpf, estadoCivil, endereco);
        this.setNumCarteira(numCarteira);
        this.setRg(rg);
        this.setCargo(cargo);
        this.setSexo(sexo);
        this.setSalario(salario);
        this.ehGerente = ehGerente;
    }// Funcionario
}// Funcionario