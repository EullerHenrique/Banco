package Siths;

import Force.Conta;
import Jabba.ContaCorrente;
import Jabba.ContaPoupanca;
import Jabba.ContaSalario;
import StormTroppers.Cliente;
import java.io.Serializable;

import java.util.ArrayList;

public class DadosContas implements Serializable {
    // Fields:
    private ArrayList<Conta> contas;

    private static int prox_num_conta;

    // Methods:
    public Object buscar(int num) {
        for(Conta conta : this.contas) {
            if(conta.getNroConta() == num)
                return (Object) conta;
        }// for

        return new Object();
    }// buscar

    public void cadastar(Cliente cliente, String senha, String dataAbert, int tipo) {
        // 1 - corrente; 2 - poupanca; 3 - salario

        if(tipo == 1) {
            ContaCorrente nwConta = new ContaCorrente(cliente, senha, prox_num_conta++, dataAbert);
            this.contas.add(nwConta);

        } else if(tipo == 2) {
            ContaPoupanca nwConta = new ContaPoupanca(cliente, senha, prox_num_conta++, dataAbert);
            this.contas.add(nwConta);

        } else {
            ContaSalario nwConta = new ContaSalario(cliente, senha, prox_num_conta++, dataAbert);
            this.contas.add(nwConta);
        }


    }// cadastrar

    public void inserir(Conta conta) {
        this.contas.add(conta);
    }// inserir

    public boolean excluir(int nroConta) {
        for(Conta conta : this.contas) {
            if(conta.getNroConta() == nroConta) {
                this.contas.remove(conta);
                return true;
            }// if
        }// for

        return false;
    }// excluir

    public ArrayList<Conta> listar() {
        return contas;
    }// listar

    // Constructor:
    public DadosContas() {
        contas = new ArrayList<Conta>();
        prox_num_conta = 1;
    }// DadosConta
}// DadosConta