package Ejercicios;

import java.util.Arrays;

public class OrdenamientoMejorado {
    private static final int LIMITE = 5; // Cuando el subarreglo tiene menos de 5 elementos, usamos Insertion Sort

    public static void ordenar(int[] arreglo) {
        if (arreglo.length < LIMITE) {
            ordenarPorInsercion(arreglo);
            return;
        }

        int mitad = arreglo.length / 2;
        int[] izquierda = Arrays.copyOfRange(arreglo, 0, mitad);
        int[] derecha = Arrays.copyOfRange(arreglo, mitad, arreglo.length);

        ordenar(izquierda);
        ordenar(derecha);
        combinar(arreglo, izquierda, derecha);
    }

    private static void ordenarPorInsercion(int[] arreglo) {
        for (int i = 1; i < arreglo.length; i++) {
            int clave = arreglo[i];
            int j = i - 1;
            while (j >= 0 && arreglo[j] > clave) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = clave;
        }
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
        int[] numeros = {12, 11, 13, 5, 6, 7, 3, 1, 4, 2};
        System.out.println("Arreglo original: " + Arrays.toString(numeros));

        ordenar(numeros);

        System.out.println("Arreglo ordenado: " + Arrays.toString(numeros));
    }
}
