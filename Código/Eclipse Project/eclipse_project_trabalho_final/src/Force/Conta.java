package Force;

import Disney.Main;
import Falcon.Transacao;
import StormTroppers.Cliente;
import java.io.Serializable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Conta implements Serializable {
    // Fields:
    private ArrayList<Cliente> cliente;
    private boolean status;
    private String senha;
    private int nroConta;
    private float saldoAtual;
    private String dataAbert, dataUMov;
    private ArrayList<Transacao> trasacoes;
    private int proprietarios;

    private static final int QTD_CLIENTES_PC = 2;

    // Getters && Setters:
    public ArrayList<Cliente> getCliente() {
        return cliente;
    }// getCliente

    public String getSenha() {
        return senha;
    }// getSenha

    public void setSenha(String senha) {
        this.senha = senha;
    }// setSenha

    public int getNroConta() {
        return nroConta;
    }// getNroConta

    public void setNroConta(int nroConta) {
        this.nroConta = nroConta;
    }// setNroConta

    public float getSaldoAtual() {
        return saldoAtual;
    }// getSaldoAtual

    public void setSaldoAtual(float saldoAtual) {
        this.saldoAtual = saldoAtual;
    }// setSaldoAtual

    public String getDataAbert() {
        return dataAbert;
    }// getDataAbert

    public void setDataAbert(String dataAbert) {
        this.dataAbert = dataAbert;
    }// setDataAbert

    public String getDataUMov() {
        return dataUMov;
    }// getDataUMov

    public void setDataUMov(String dataUMov) {
        this.dataUMov = dataUMov;
    }// setDataUMov

    public ArrayList<Transacao> getTrasacoes() {
        return trasacoes;
    }// getTrasacoes

    public int getProprietarios() {
        return proprietarios;
    }// getProprietarios

    public void setProprietarios(int nro) {
        if(nro <= Conta.QTD_CLIENTES_PC && nro > 0)
            this.proprietarios = nro;
    }// setProprietarios

    public boolean isStatus() {
        return status;
    }// isStatus

    public void setStatus(boolean status) {
        this.status = status;
    }// setStatus

    // Methods:
    public boolean alterarSenha(String senhaAnt, String senhaNov) {
        if (senhaAnt.equals(this.senha)) {
            this.setSenha(senhaNov);
            return true;

        } else
            return false;
    }// alterarSenha

    public boolean adcCliente(Cliente cliente) {
        if (proprietarios < Conta.QTD_CLIENTES_PC) {
            this.cliente.add(cliente);
            ++this.proprietarios;

            return true;

        } else
            return false;
    }// adcCliente

    public boolean rmvCliente(Cliente cliente) {
        if (proprietarios == 2)
            return this.cliente.remove(cliente);

        else
            return false;
    }// rmvCliente

    public ArrayList<Transacao> buscaTransacao(String data) {
        ArrayList<Transacao> transacoes_dia = new ArrayList<Transacao>();

        for (Transacao objeto : this.trasacoes) {
            if (objeto.getDataTransacao().equals(data))
                transacoes_dia.add(objeto);
        }// for

        return transacoes_dia;
    }// buscaTransacao

    public boolean saque(float qtd, String canal, String senha) {
        if(senha.equals(this.getSenha())) {
            if(qtd > this.saldoAtual || this.saldoAtual < 0 || qtd < 0)
                return false;

            else {
                this.saldoAtual -= qtd;

                // Pegar string da data do dia
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                String strHoje= formatador.format(new Date(System.currentTimeMillis()));

                this.trasacoes.add(new Transacao(strHoje, this.getSaldoAtual(), qtd, canal,
                        "Saque", true));
                this.setDataUMov(strHoje);
                return true;
            }// if else
        } else
            return false;
    }// saque

    protected boolean saque(float qtd, String canal) { // Apenas para subclasses (Senha é verificado lá)
        this.saldoAtual -= qtd;

        // Pegar string da data do dia
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String strHoje= formatador.format(new Date(System.currentTimeMillis()));

        this.trasacoes.add(new Transacao(strHoje, this.getSaldoAtual(), qtd, canal,
                "Saque", true));
        this.setDataUMov(strHoje);
        return true;
    }// saque

    public boolean transf(float qtd, String senha, String canal, int nroAgencia, int nroConta) {
        if(senha.equals(this.getSenha())) {
            if(qtd > this.saldoAtual || this.saldoAtual < 0 || qtd < 0)
                return false;
            else {
                this.saldoAtual -= qtd;

                // Pegar string da data do dia
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                String strHoje= formatador.format(new Date(System.currentTimeMillis()));

                this.trasacoes.add(new Transacao(strHoje, this.getSaldoAtual(), qtd, canal,
                        "Transferência", true));
                this.setDataUMov(strHoje);

                return true;
            }// if else
        } else
            return false;
    }// transf

    protected boolean transf(float qtd, String canal, int nroAgencia, int nroConta) {
        // Apenas para subclasses (Senha é verificado lá)
        if(qtd > this.saldoAtual || this.saldoAtual <= 0 || qtd < 0)
            return false;
        else {
            this.saldoAtual -= qtd;

            // Pegar string da data do dia
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String strHoje= formatador.format(new Date(System.currentTimeMillis()));

            this.trasacoes.add(new Transacao(strHoje, this.getSaldoAtual(), qtd, canal,
                    "Transferência", true));
            this.setDataUMov(strHoje);
            return true;
        }// if else
    }// transf

    public boolean depos(float qtd, String senha, String canal) {
        if(!(senha.equals(this.getSenha())) || qtd < 0)
            return false;

        else {
            this.saldoAtual += qtd;

            // Pegar string da data do dia
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            String strHoje= formatador.format(new Date(System.currentTimeMillis()));

            this.trasacoes.add(new Transacao(strHoje, this.getSaldoAtual(), qtd, canal,
                    "Depósito", true));
            this.setDataUMov(strHoje);
            return true;
        }// if else
    }// depos

    public boolean pagar(float qtd, String senha, String canal) {
        if(senha.equals(this.getSenha())) {
            if(qtd > this.saldoAtual || this.saldoAtual < 0 || qtd < 0)
                return false;
            else {
                this.saldoAtual -= qtd;

                // Pegar string da data do dia
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                String strHoje= formatador.format(new Date(System.currentTimeMillis()));

                this.trasacoes.add(new Transacao(strHoje, this.getSaldoAtual(), qtd, canal,
                        "Pagamento", true));
                this.setDataUMov(strHoje);
                return true;
            }// if else
        } else
            return false;
    }// pagar


    public String toString() {
        return String.format("Cliente: %s\nStatus: %b\nNroConta: %s\nSaldo Atual: %.2f\nData de Abertura: %s\n" +
                        "Data da Última Movimentação: %s\n", this.getCliente(), this.isStatus(), this.getNroConta(),
                this.getSaldoAtual(), this.getDataAbert(), this.getDataUMov());
    }// toString

    // Constructor:
    public Conta(Cliente cliente, String senha, int nroConta, String dataAbert) {
        this.cliente = new ArrayList<Cliente>();
        this.trasacoes = new ArrayList<Transacao>();
        this.cliente.add(cliente);
        this.setStatus(true);
        this.setSenha(senha);
        this.setNroConta(nroConta);
        this.setSaldoAtual(0.0f);
        this.setDataAbert(dataAbert);
        this.proprietarios = 1;
        this.dataUMov = "Não aconteceu";
    }// Conta
}// Conta