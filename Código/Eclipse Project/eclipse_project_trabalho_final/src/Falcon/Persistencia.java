package Falcon;

import java.io.*;

public class Persistencia {
    // Fields:
    private static FileOutputStream arquivoGrav;
    private static ObjectOutputStream obj;

    // Methods:
    public static boolean criar(String arquivo) {
        try {
            Persistencia.arquivoGrav = new FileOutputStream(arquivo);
            Persistencia.obj = new ObjectOutputStream(Persistencia.arquivoGrav);
            return true;
        } catch(Exception exc)
        {
            return false;
        }// try catch

    }// criar

    public static boolean gravar(Object obj) {
        try {
            Persistencia.obj.writeObject(obj);
            return true;
        } catch(Exception exc) {
            return false;
        }// try catch

    }// gravar

    public static boolean fechar() {
        try {
            Persistencia.obj.flush();
            Persistencia.obj.close();
            Persistencia.arquivoGrav.flush();
            Persistencia.arquivoGrav.close();
            return true;
        } catch(Exception exc) {
            return false;
        }// try catch
    }// fechar
}// Persistencia