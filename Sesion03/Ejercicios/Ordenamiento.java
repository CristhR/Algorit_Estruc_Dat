package Ejercicios;

import java.util.Arrays;

public class Ordenamiento {
    public static void ordenar(int[] arreglo) {
        if (arreglo.length < 2) return;

        int mitad = arreglo.length / 2;
        int[] izquierda = Arrays.copyOfRange(arreglo, 0, mitad);
        int[] derecha = Arrays.copyOfRange(arreglo, mitad, arreglo.length);

        ordenar(izquierda);
        ordenar(derecha);
        combinar(arreglo, izquierda, derecha);
    }

    private static void combinar(int[] arreglo, int[] izquierda, int[] derecha) {
        int i = 0, j = 0, k = 0;

        while (i < izquierda.length && j < derecha.length) {
            arreglo[k++] = (izquierda[i] <= derecha[j]) ? izquierda[i++] : derecha[j++];
        }

        while (i < izquierda.length) arreglo[k++] = izquierda[i++];
        while (j < derecha.length) arreglo[k++] = derecha[j++];
    }

    public static void main(String[] args) {
        int[] numeros = {12, 11, 13, 5, 6, 7};
        ordenar(numeros);
        System.out.println(Arrays.toString(numeros));
    }
}
