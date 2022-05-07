package Siths;

import DeathStars.Agencia;
import Falcon.Endereco;
import Falcon.Persistencia;
import StormTroppers.Gerente;

import java.util.ArrayList;

public class DadosAgencias {
    // Fields:
    private ArrayList<Agencia> agencias;

    private static int prox_num_agen = 1;

    // Getters:
    public static int getProxNro() {
        return prox_num_agen;
    }// getProxNro

    // Methods:
    public Object buscar(int nroAgencia) {
        for(Agencia agencia : this.agencias) {
            if(agencia.getNum() == nroAgencia)
                return (Object) agencia;
        }// for

        return new Object();
    }// buscar

    public void cadastar(String nome, Endereco endereco, Gerente gerente) {
        Agencia agencia = new Agencia(nome, endereco, prox_num_agen++, gerente);

        this.agencias.add(agencia);
    }// cadastrar

    public void inserir(Agencia agencia) {
        this.agencias.add(agencia);
    }// inserir

    public boolean excluir(int nroAgencia) {
        for(Agencia agencia : this.agencias) {
            if (agencia.getNum() == nroAgencia) {
                this.agencias.remove(agencia);
                return true;
            }// if
        }// for

        return false;
    }// excluir

    public void salvarAgencias() {
        Persistencia.criar("Dados.bin");

        for (Agencia agencia : this.agencias)
            Persistencia.gravar(agencia);

        Persistencia.fechar();
    }// salvarAgencias

    public ArrayList<Agencia> listar() {
        return agencias;
    }// listar

    // Constructor:
    public DadosAgencias() {
        agencias = new ArrayList<Agencia>();
    }// DadosAgencias
}// DadosAgencias