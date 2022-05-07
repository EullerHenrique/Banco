package Jabba;

import Force.Conta;
import StormTroppers.Cliente;
import java.io.Serializable;

public class ContaCorrente extends Conta implements Serializable {
    // Fields:
    private final static float LIMITE_CHEQUE_ESPECIAL = 100, VALOR_TAXA_ADMIN = 6.5f;

    // Methods:
    public boolean saque(float qtd, String canal, String senha) {
        if(super.getSenha().equals(senha)) {
            if(qtd > 0 && ((qtd + ContaCorrente.VALOR_TAXA_ADMIN <= super.getSaldoAtual()) ||
                    (qtd + ContaCorrente.VALOR_TAXA_ADMIN - super.getSaldoAtual() <=
                            ContaCorrente.LIMITE_CHEQUE_ESPECIAL)))
                return super.saque(ContaCorrente.VALOR_TAXA_ADMIN + qtd, canal);
            else
                return false;
        } else
            return false;
    }// saque

    public String toString() {
        return super.toString() + String.format("\n\nConta Corrente:\nLmt. Cheque Especial: %.2f\n" +
                "Taxa Administrativa: %.2f\n", LIMITE_CHEQUE_ESPECIAL, VALOR_TAXA_ADMIN);
    }// toString

    // Construtor:
    public ContaCorrente(Cliente cliente, String senha, int nroConta, String dataAbert) {
        super(cliente, senha, nroConta, dataAbert);
    }// ContaCorrente
}// ContaCorrente