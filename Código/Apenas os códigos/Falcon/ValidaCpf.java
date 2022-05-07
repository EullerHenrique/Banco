package Falcon;

public class ValidaCpf {
    // Methods:
    public static boolean ehNumerico(String str) {
        int i;

        for(i = 0; i < str.length(); ++i) {
            char aux = str.charAt(i);
            if(aux > '9' || aux < '0')
                return false;
        }// for

        return true;
    }// ehNumerico

    public static boolean validaCpf(String cpf) {
        /*
         * A verificação se a String só tem números é feita antes da chamada desse métodos.
         */
        if(cpf.length() != 11 ||
                cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999"))
            return false;

        // Digito 10:
        int sm = 0, num, peso = 10, i;
        for(i = 0; i < 9; ++i, --peso)
            sm += (cpf.charAt(i) - '0') * peso;

        num = 11 - (sm % 11);

        if(num == 10 || num == 11)
            num = 0;

        if(num != (cpf.charAt(9) - '0'))
            return false;

        // Digito 11:
        sm = 0; peso = 11;
        for(i = 0; i < 10; ++i, --peso)
            sm += (cpf.charAt(i) - '0') * peso;

        num = 11 - (sm % 11);

        if(num == 10 || num == 11)
            num = 0;

        return num == (cpf.charAt(10) - '0');
    }// validaCpf

    public static String toString(String cpf) {
        return String.format("%c%c%c.%c%c%c.%c%c%c-%c%c", cpf.charAt(0), cpf.charAt(1), cpf.charAt(2),
                cpf.charAt(3), cpf.charAt(4), cpf.charAt(5), cpf.charAt(6), cpf.charAt(7), cpf.charAt(8),
                cpf.charAt(9), cpf.charAt(10));
    }// toString
}// ValidaCpf