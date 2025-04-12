package Ejercicios;

public class SubconjuntoRestringido {

    public static boolean esPotenciaDe2(int n) {
        return (n != 0) && ((n & (n - 1)) == 0);
    }

    public static boolean resolver(int[] arr, int index, int sumaActual, int objetivo, boolean[] incluir) {
        if (index == arr.length) {
            int suma = 0;
            for (int i = 0; i < arr.length; i++) {
                if (incluir[i]) suma += arr[i];
            }
            return suma == objetivo;
        }

        int actual = arr[index];

        // Potencia de 2 → incluir obligatoriamente
        if (esPotenciaDe2(actual)) {
            incluir[index] = true;
            return resolver(arr, index + 1, sumaActual + actual, objetivo, incluir);
        }

        // Múltiplo de 5 y seguido de impar → excluir obligatoriamente
        if (actual % 5 == 0 && index + 1 < arr.length && arr[index + 1] % 2 != 0) {
            incluir[index] = false;
            return resolver(arr, index + 1, sumaActual, objetivo, incluir);
        }

        // Opción 1: incluir
        incluir[index] = true;
        if (resolver(arr, index + 1, sumaActual + actual, objetivo, incluir)) return true;

        // Opción 2: no incluir
        incluir[index] = false;
        return resolver(arr, index + 1, sumaActual, objetivo, incluir);
    }

    public static boolean puedeFormarSuma(int[] arr, int objetivo) {
        return resolver(arr, 0, 0, objetivo, new boolean[arr.length]);
    }

    public static void main(String[] args) {
        int[][] casos = {
            {4, 8, 10, 3, 5},
            {4, 8, 10, 3, 6},
            {2, 16, 5, 7, 10},
            {2, 16, 5, 3, 10},
            {2, 5, 1, 6}
        };
        int[] objetivos = {27, 27, 33, 33, 13};

        for (int i = 0; i < casos.length; i++) {
            System.out.println("Entrada: " + java.util.Arrays.toString(casos[i]) +
                               ", Objetivo: " + objetivos[i] +
                               " → Resultado: " + puedeFormarSuma(casos[i], objetivos[i]));
        }
    }
}
