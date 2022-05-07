package Falcon;

import java.io.Serializable;

public class Transacao implements Serializable {
    // Fields:
    private String dataTransacao;
    private float valor, antesTransacao, depoisTransacao;
    private String tipo;
    private String canal;
    private boolean status;

    // Getters:
    public String getDataTransacao() {
        return dataTransacao;
    }// getDataTransacao

    public float getValor() {
        return valor;
    }// getValor

    public String getTipo() {
        return tipo;
    }// getTipo

    public String getCanal() {
        return canal;
    }// getCanal

    public boolean isStatus() {
        return status;
    }// isStatus

    // Methods:
    public String toString() {
        return String.format("Data: %s\nSaldo Anterior: %.2f\nSaldo Posterior: %.2f\nValor: %.2f\nTipo: %s\n" +
                        "Canal: %s\nStatus: %b\n", dataTransacao, antesTransacao, depoisTransacao, valor, canal,
                tipo, status);
    }// toString

    // Constructor:
    public Transacao(String dataTransacao, float saldo, float valor, String canal, String tipo, boolean status) {
        this.dataTransacao = dataTransacao;
        if(tipo.equals("Depósito"))
            this.antesTransacao = saldo - valor;
        else
            this.antesTransacao = saldo + valor;
        this.depoisTransacao = saldo;
        this.valor = valor;
        this.tipo = tipo.toUpperCase();
        this.canal = canal.toUpperCase();
        this.status = status;
    }// Transacao
}// Transacao