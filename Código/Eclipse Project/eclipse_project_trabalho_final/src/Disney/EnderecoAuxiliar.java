package Disney;

import Falcon.Endereco;
import java.util.ArrayList;

public class EnderecoAuxiliar {

    // Fields:
    private static ArrayList<Endereco> enderecos0 = new ArrayList<Endereco>();
    private static ArrayList<Endereco> enderecos1 = new ArrayList<Endereco>();    
    
    // Methods:
    public static void push(Endereco endereco, int tipo) {
        /*
         * Tipo é utilizado para diferenciar endereço de  agência(0) e de
         * gerente(1), para criação de nova agência no menu agência admin
         */
        if(tipo == 0)
            enderecos0.add(endereco);
        else
            enderecos1.add(endereco);
    }// adicionarEndereco
    
    public static Endereco pop(int tipo) {
        if(tipo == 0) {

            Endereco end = enderecos0.get(EnderecoAuxiliar.sizeArr(0) - 1);
            enderecos0.remove(end);
            return end;

        } else {

            Endereco end = enderecos1.get(EnderecoAuxiliar.sizeArr(0) - 1);
            enderecos1.remove(end);
            return end;

        }// if else
    }// buscarEndereco
    
    public static ArrayList<Endereco> listar(int tipo) {
        if(tipo == 0)
            return enderecos0;
        else
            return enderecos1;
    }// listar
    
    public static int sizeArr(int tipo) {
        if(tipo == 0)
            return enderecos0.size();
        else
            return enderecos1.size();
    }// sizeArr
    
    public static void limparArrs() {
        
        enderecos0.clear();
        enderecos1.clear();
        
    }// limparArrs

}// EnderecoAuxiliar
