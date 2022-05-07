package DeathStars;

import Falcon.Endereco;
import Siths.DadosClientes;
import Siths.DadosContas;
import Siths.DadosFuncionarios;
import StormTroppers.Gerente;
import java.io.Serializable;

public class Agencia implements Serializable {
    // Fields:
    private String nome;
    private Endereco endereco;
    private int num;
    private Gerente gerente;
    private DadosFuncionarios funcionarios;
    private DadosClientes clientes;
    private DadosContas contas;

    // Getters & Setters:
    public String getNome() {
        return nome;
    }// getNome

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }// setNome

    public Endereco getEndereco() {
        return endereco;
    }// getEndereco

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }// setEndereco

    public int getNum() {
        return num;
    }// getNum

    public void setNum(int num) {
        this.num = num;
    }// setNum

    public Gerente getGerente() {
        return gerente;
    }// getGerente

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }// setGerente

    public DadosFuncionarios getFuncionarios() {
        return funcionarios;
    }// getFuncionarios

    public DadosClientes getClientes() {
        return clientes;
    }// getClientes

    public DadosContas getContas() {
        return contas;
    }// getContas

    // Methods:
    public String toString() {
        return String.format("Nome: %s\nEndereco: %s\n, Num: %d\n" +
                        "Gerente:\n%s", nome, endereco.toString(), num,
                gerente.toString());
    }// toString

    // Constructor:
    public Agencia(String nome, Endereco endereco, int num, Gerente gerente) {
        setNome(nome);
        setEndereco(endereco);
        setNum(num);
        setGerente(gerente);
        funcionarios = new DadosFuncionarios();
        clientes = new DadosClientes();
        contas = new DadosContas();
    }// Agencia
}// Agencia