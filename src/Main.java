import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String numeroDeTarjeta = "4539319503436467";


        if (numeroDeTarjetaEsValidoModuloDiez(numeroDeTarjeta)) {
            System.out.println("Numero valido");
        } else {
            System.out.println("Numero invalido");
        }

        String numeroDeTarjetaValidoParaModulo2 = "4739319503436467";

        if (numeroDeTarjetaEsValidoModuloN(numeroDeTarjetaValidoParaModulo2, 2)) {
            System.out.println("Numero valido");
        } else {
            System.out.println("Numero invalido");
        }
    }

    private static boolean numeroDeTarjetaEsValidoModuloN(String numerosDeTarjeta, int modulo) {
        //Separo cada digito en un espacio del arreglo
        int[] numerosDeTarjetaSeparados = new int[numerosDeTarjeta.length()];

        int auxiliarParaIndice = 0;

        //Los guardo iniciando desde la derecha para que me sea mas facil conseguir cada segundo digito

        for (int i= numerosDeTarjeta.length()-1 ; i>=0 ; i--){
            numerosDeTarjetaSeparados[auxiliarParaIndice] = Character.getNumericValue(numerosDeTarjeta.charAt(i));
            auxiliarParaIndice++;
        }

        //Aplico el algoritmo
        for (int i=0; i<numerosDeTarjetaSeparados.length;i++){
            if (i % 2 != 0) {
                numerosDeTarjetaSeparados[i] *= 2;
                if (numerosDeTarjetaSeparados[i] > 9) {
                    numerosDeTarjetaSeparados[i] -= 9;
                }
            }
        }

        int sumaTotal = 0;

        for (int numeroDeTarjeta : numerosDeTarjetaSeparados) {
            sumaTotal += numeroDeTarjeta;
        }

        System.out.println(Arrays.toString(numerosDeTarjetaSeparados) + sumaTotal);

        return sumaTotal % modulo == 0;
    }

    private static boolean numeroDeTarjetaEsValidoModuloDiez(String numerosDeTarjeta) {
        return numeroDeTarjetaEsValidoModuloN(numerosDeTarjeta, 10);
    }
}