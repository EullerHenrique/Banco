package Jabba;

import Force.Conta;
import StormTroppers.Cliente;
import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaPoupanca extends Conta implements Serializable {
    // Fields:
    private static final float REND_MES = 0.1f;  // Porcentagem
    private String ultimoCalcRend; // "MM/yyyy"
    private float rendimento_ult_mes;

    // Getters & Setters:
    public static float getRendMes() {
        return REND_MES;
    }// getRendMes

    // Methods:
    public void calcularRendMes() {
        String strHoje = (new SimpleDateFormat("MM/yyyy")).format(new Date(System.currentTimeMillis()));

        int i;
        // Pegar valor de ano e mes atual como inteiro:
        int ano_atual = Integer.parseInt(String.format("%c%c%c%c", strHoje.charAt(3), strHoje.charAt(4),
                strHoje.charAt(5), strHoje.charAt(6)));
        int mes_atual = Integer.parseInt(String.format("%c%c", strHoje.charAt(0), strHoje.charAt(1)));

        // Pegar valor de ano e mes do ultimo calc do rendimento:
        int ano_calc = Integer.parseInt(String.format("%c%c%c%c", this.ultimoCalcRend.charAt(3),
                this.ultimoCalcRend.charAt(4), this.ultimoCalcRend.charAt(5), this.ultimoCalcRend.charAt(6)));
        int mes_calc = Integer.parseInt(String.format("%c%c", this.ultimoCalcRend.charAt(0),
                this.ultimoCalcRend.charAt(1)));

        float valor_rend = 0;
        int qtd_meses;

        if(ano_atual == ano_calc)
            qtd_meses = mes_atual - mes_calc;
        else
        {

            qtd_meses = 12 - mes_calc;
            qtd_meses += mes_atual;
            qtd_meses += (12 * (ano_atual - ano_calc - 1));

        }// if else

        for(i = 0; i < qtd_meses; ++i) {
            valor_rend += super.getSaldoAtual() * (ContaPoupanca.getRendMes() / 100);
            super.setSaldoAtual(super.getSaldoAtual() + valor_rend);
        }// for

        this.rendimento_ult_mes = valor_rend;
    }// calcularRendMes

    public String toString() {
        return super.toString() + String.format("\n\nConta Poupança:\nRend. mensal: %.1f%%"
                + "\nQuanto rendeu no último mês: R$%.4f", REND_MES, rendimento_ult_mes);
    }// toString

    // Constructor:
    public ContaPoupanca(Cliente cliente, String senha, int nroConta, String dataAbert) {
        super(cliente, senha, nroConta, dataAbert);
        this.ultimoCalcRend = String.format("%c%c/%c%c%c%c", dataAbert.charAt(3), dataAbert.charAt(4),
                dataAbert.charAt(6), dataAbert.charAt(7), dataAbert.charAt(8), dataAbert.charAt(9));
        this.rendimento_ult_mes = 0.0f;
    }// ContaPoupanca
}// ContaPoupanca