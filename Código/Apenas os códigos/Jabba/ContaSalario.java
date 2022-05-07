package Jabba;

import Force.Conta;
import StormTroppers.Cliente;
import java.io.Serializable;

public class ContaSalario extends Conta implements Serializable {
    // Fileds:
    private static final float LIMITE_SAQUE = 1000f, LIMITE_TRANSF = 500f;

    // Getters & Setters:
    public static float getLimiteSaque() {
        return LIMITE_SAQUE;
    }// getLimiteSaque

    public static float getLimiteTransf() {
        return LIMITE_TRANSF;
    }// getLimiteTransf

    // Methods:
    public boolean saque(float qtd, String canal, String senha) {
        if(super.getSenha().equals(senha)) {
            if(qtd > super.getSaldoAtual() || super.getSaldoAtual() <= 0 || qtd <= 0 ||
                    qtd > LIMITE_SAQUE)
                return false;

            else
                return super.saque(qtd, canal);
        } else
            return false;
    }// saque

    public boolean transf(float qtd, String senha, String canal, int nroAgencia, int nroConta) {
        if(super.getSenha().equals(senha)) {
            if(qtd > super.getSaldoAtual() || super.getSaldoAtual() <= 0 || qtd <= 0 ||
                    qtd > LIMITE_TRANSF)
                return false;

            else
                return super.transf(qtd, canal, nroAgencia, nroConta);
        } else
            return false;
    }// transf

    public String toString() {
        return super.toString() + String.format("\n\nConta Salário:\n" +
                        "Lmt. Saque: %.2f\nLmt. Transf.: %.2f\n",
                LIMITE_SAQUE, LIMITE_TRANSF);
    }// toString

    // Construtor:
    public ContaSalario(Cliente cliente, String senha, int nroConta, String dataAbert) {
        super(cliente, senha, nroConta, dataAbert);
    }// ContaSalario
}// ContaSalario