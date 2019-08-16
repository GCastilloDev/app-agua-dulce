package com.examples.aguadulce.utilidades;

import com.examples.aguadulce.clave_aleatoria.ParametrosClave;

public class ClaveAleatoria {

    public static String generarClave(){

        NumeroAleatorio num = new NumeroAleatorio();
        Object mayusculas [] = {ParametrosClave.TEXTO_MAYUSCULA, "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        Object minusculas [] = {ParametrosClave.TEXTO_MINUSCULA, "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        Object numeros [] =  {ParametrosClave.NUMEROS, "1","2","3","4","5","6","7","8","9","0"};
        Object caracteresEspeciales [] = {ParametrosClave.CARACTERES_ESPECIALES, "|","¬","#","$","%","&","/","(",")","=","?","'","¿","¡","*","+","~","[","{","^","]","}","`",";",",",".","!"};

        String pswNuevo = "";

        for(int i = 1; i <= ParametrosClave.LONGITUD; i++){

            boolean repetir = true;
            String caracter = "";

            do {
                int tipoCaracter = num.generarNumeroAleatorio(1,5);

                if(tipoCaracter == 1 ){
                    int posicion = num.generarNumeroAleatorio(1,(mayusculas.length));
                    caracter = mayusculas[posicion].toString();
                    repetir = (boolean) mayusculas[0];
                }

                if(tipoCaracter == 2 ){
                    int posicion = num.generarNumeroAleatorio(1,(minusculas.length));
                    caracter = minusculas[posicion].toString();
                    repetir = (boolean) minusculas[0];
                }

                if(tipoCaracter == 3 ){
                    int posicion = num.generarNumeroAleatorio(1,(numeros.length));
                    caracter = numeros[posicion].toString();
                    repetir = (boolean) numeros[0];
                }

                if(tipoCaracter == 4 ){
                    int posicion = num.generarNumeroAleatorio(1,(caracteresEspeciales.length));
                    caracter = caracteresEspeciales[posicion].toString();
                    repetir = (boolean) caracteresEspeciales[0];
                }

            }while(!repetir);

            pswNuevo += caracter;
        }

        return pswNuevo;
    }
}
