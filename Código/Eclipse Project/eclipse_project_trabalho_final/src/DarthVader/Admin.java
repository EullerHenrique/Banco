package DarthVader;

import DeathStars.Agencia;
import Force.Conta;
import Siths.DadosAgencias;

public class Admin {
    // Fields:
    private DadosAgencias agencias;

    private static final String SENHA = "CTTDS"; // "ComeToTheDarkSide"

    // Getters:
    public DadosAgencias getAgencias() {
        return agencias;
    }// getAgencias

    public String getSenha() {
        return Admin.SENHA;
    }// getSenha

    // Constructor:
    public Admin() {
        agencias = new DadosAgencias();
    }// Admin
}// Admin