package Siths;


import Falcon.Endereco;
import StormTroppers.Funcionario;
import java.io.Serializable;
import java.util.ArrayList;

public class DadosFuncionarios implements Serializable {
    // Fields:
    private ArrayList<Funcionario> funcionarios;

    // Methods:
    public Object buscar(String cpf) {
        for(Funcionario funcionario : this.funcionarios) {
            if(funcionario.getCpf().equals(cpf))
                return (Object) funcionario;
        }// for

        return new Object();
    }// buscar

    public void cadastar(String nome, String cpf, String estadoCivil, Endereco endereco, String numCarteira,
                         String rg, String cargo, char sexo, float salario) {
        Funcionario nwFunc = new Funcionario(nome, cpf, estadoCivil, endereco, numCarteira, rg, cargo, sexo, salario, false);

        this.funcionarios.add(nwFunc);
    }// cadastrar

    public void inserir(Funcionario func) {
        this.funcionarios.add(func);
    }// inserir

    public boolean excluir(String cpf) {
        for(Funcionario funcionario : this.funcionarios) {
            if(funcionario.getCpf().equals(cpf)) {
                this.funcionarios.remove(funcionario);

                return true;
            }// if
        }// for

        return false;
    }// excluir

    public ArrayList<Funcionario> listar() {
        return funcionarios;
    }// lista

    // Constructor:
    public DadosFuncionarios() {
        funcionarios = new ArrayList<Funcionario>();
    }// DadosFuncionarios
}// DadosFuncionarios