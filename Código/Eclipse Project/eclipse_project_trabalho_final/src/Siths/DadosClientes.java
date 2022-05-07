package Siths;

import Falcon.Endereco;
import StormTroppers.Cliente;
import java.io.Serializable;

import java.util.ArrayList;

public class DadosClientes implements Serializable {
    // Fields:
    private ArrayList<Cliente> clientes;

    // Methods:
    public Object buscar(String cpf) {
        for(Cliente cliente : this.clientes) {
            if(cliente.getCpf().equals(cpf))
                return (Object) cliente;
        }// for

        return new Object();
    }// buscar

    public void cadastar(String nome, String cpf, String estadoCivil, Endereco endereco, String escolaridade, String
            dataNasc) {
        Cliente nwCliente = new Cliente(nome, cpf,  estadoCivil, endereco, escolaridade, dataNasc);

        this.clientes.add(nwCliente);
    }// cadastrar

    public void inserir(Cliente cliente) {
        this.clientes.add(cliente);
    }// inserir

    public boolean excluir(String cpf) {
        for(Cliente cliente : this.clientes) {
            if(cliente.getCpf().equals(cpf)) {
                this.clientes.remove(cliente);
                return true;
            }// if
        }// for

        return false;
    }// excluir

    public ArrayList<Cliente> listar() {
        return clientes;
    }// listar

    // Constructor:
    public DadosClientes() {
        clientes = new ArrayList<Cliente>();
    }// DadosClientes
}// DadosClientes