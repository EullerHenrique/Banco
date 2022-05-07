package Disney;

import DarthVader.Admin;
import DeathStars.Agencia;
import Falcon.Endereco;
import Falcon.ValidaCpf;
import Jabba.ContaPoupanca;
import Siths.DadosAgencias;
import StormTroppers.Cliente;
import StormTroppers.Gerente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    // Fields:
    private static Admin admin = new Admin();
    
    // Getter para Admin:
    public static Admin getAdmin() {
        return admin;
    }// getAdmin
    
    
    // Inicia o Programa:
    public static void main(String[] args) {

        // Inicia agências:
        // Agência 1:
        Gerente g1 = new Gerente("João da Silva", ValidaCpf.toString("14824752604"), "Casado",
                new Endereco(335, "Avenida", "Constelação", "Jardim Brasília",
                "Uberlâdia", "MG"), "0", "MG233811308", "Gerente",
                'M', 5000.0f, "01/04/2005", DadosAgencias.getProxNro(), true,
                "123");

        admin.getAgencias().cadastar("Agencia " + DadosAgencias.getProxNro(), new Endereco(480,
                   "Rua", "Três", "Gávea", "Uberlâdia", "MG"), g1);

        // Agência 2:
        Gerente g2 = new Gerente("Maria Eduarda", ValidaCpf.toString("171974043045"), "Solteiro",
                new Endereco(432, "Rua", "Getúlio Vargas", "Jardim Brasília",
                "Belo Horizonte", "MG"), "1", "MG233811305", "Gerente",
                'F', 5000.0f, "05/06/2014", DadosAgencias.getProxNro(), true,
                "123");

        admin.getAgencias().cadastar("Agencia " + DadosAgencias.getProxNro(), new Endereco(440,
                   "Rua", "Dois", "Tubalina", "Belo Horizonte", "MG"), g2);

        // Agência 3:
        Gerente g3 = new Gerente("Joaquim", ValidaCpf.toString("17345004090"), "Solteiro",
                new Endereco(432, "Rua", "Um", "Asa Norte", "Brasília",
                "DF"), "2", "MG233811301", "Gerente", 'M', 6000.0f,
                "04/05/2018", DadosAgencias.getProxNro(), true, "123");

        admin.getAgencias().cadastar("Agencia " + DadosAgencias.getProxNro(), new Endereco(383,
                   "Rua", "Três", "Asa Sul", "Brasilia", "DF"), g3);

        // Agência 4:
        Gerente g4 = new Gerente("Maria Rita", ValidaCpf.toString("40447499068"), "Solteira",
                new Endereco(432, "Rua", "Vinte", "Asa Norte", "Brasília",
                "DF"), "4", "MG233811235", "Gerente", 'F', 10000.0f,
                "10/02/2019", DadosAgencias.getProxNro(), true, "123");

        admin.getAgencias().cadastar("Agencia " + DadosAgencias.getProxNro(), new Endereco(440,
                   "Rua", "Cinco", "Asa Sul", "Brasília", "DF"), g4);

        // Agência 5:
        Gerente g5 = new Gerente("Joaquina", ValidaCpf.toString("35913740084"), "Solteira",
                new Endereco(432, "Rua", "Dez", "Asa Norte", "Brasília",
                "DF"), "5", "MG233811234", "Gerente", 'F', 8000.0f,
                "01/04/2019", DadosAgencias.getProxNro(), true, "123");

        admin.getAgencias().cadastar("Agencia " + DadosAgencias.getProxNro(), new Endereco(117,
                   "Rua", "Vinte e dois", "Asa Sul", "Brasília", "DF"), g5);

        // Insere Gerente como funcionários de suas Agências:
        Main.getAdmin().getAgencias().listar().get(0).getFuncionarios().inserir(g1);
        Main.getAdmin().getAgencias().listar().get(1).getFuncionarios().inserir(g2);
        Main.getAdmin().getAgencias().listar().get(2).getFuncionarios().inserir(g3);
        Main.getAdmin().getAgencias().listar().get(3).getFuncionarios().inserir(g4);
        Main.getAdmin().getAgencias().listar().get(4).getFuncionarios().inserir(g5);

        // Iniciar Clientes e Contas para testes (De rendimento mensal):
        // Cliente 1:
        Cliente cliente1 = new Cliente("Jaqueline Ana Almeida", ValidaCpf.toString("20869132652"),
                "Solteira", new Endereco(895, "Rua", "Doutor Carlos Marengo Pereira" +
                " Filho", "Shopping Park", "Uberlândia", "MG"), "Superior",
                "26/04/1990");
        Main.getAdmin().getAgencias().listar().get(0).getContas().cadastar(cliente1, "123",
                "01/04/2019", 2);

        // Cliente 2:
        Cliente cliente2 = new Cliente("Geraldo Gael Leandro Mendes", ValidaCpf.toString("25406073656"),
                "Casado", new Endereco(577 ,"Rua", "Raimundo Gonçalves Cunha",
                "Valle", "Uberlâdia", "MG"), "Superior", "19/01/1964");
        Main.getAdmin().getAgencias().listar().get(0).getContas().cadastar(cliente2, "123",
                "01/04/2015", 2);

        // Insere Clientes como clientes da agência:
        Main.getAdmin().getAgencias().listar().get(0).getClientes().inserir(cliente1);
        Main.getAdmin().getAgencias().listar().get(0).getClientes().inserir(cliente2);

        // Inserir saldo às contas para testar rendimento mensal:
        Main.getAdmin().getAgencias().listar().get(0).getContas().listar().get(0).setSaldoAtual(  10000  );
        Main.getAdmin().getAgencias().listar().get(0).getContas().listar().get(1).setSaldoAtual( 5000000 );

        // Inicia o menu de Login:
        MenuLogin.menuLogin();

    }// main

}// Main