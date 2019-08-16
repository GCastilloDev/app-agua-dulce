package com.examples.aguadulce.utilidades;

/**
 * Esta clase genera números aleatorios a partir de un rango.
 * @author Gustavo Castillo
 * @version 16/08/2019/A
 */

public class NumeroAleatorio {


    /**
     * @param min de tipo entero, para definir el número mínimo que el método devolvera.
     * @param max de tipo entero, para definir el número máximo que el método devolvera, <br>no incluyendose</br>.
     * @return El número aleatorio
     */
    public int generarNumeroAleatorio(int min, int max){
        return (int) (Math.random()*(max - min)) + min;
    }


}
