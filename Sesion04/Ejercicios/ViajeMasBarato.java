package Ejercicios;

public class ViajeMasBarato {

    public static int viajeMasBarato(int[][] T) {
        int n = T.length;
        int[][] C = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) C[i][j] = 0;
                else {
                    C[i][j] = T[i][j];
                    for (int k = i + 1; k < j; k++) {
                        C[i][j] = Math.min(C[i][j], T[i][k] + C[k][j]);
                    }
                }
            }
        }
        return C[0][n - 1];
    }

    public static void main(String[] args) {
        int[][] tarifas = {
            {0, 2, 9, 10, 99},
            {0, 0, 6, 4, 99},
            {0, 0, 0, 8, 7},
            {0, 0, 0, 0, 5},
            {0, 0, 0, 0, 0}
        };

        int resultado = viajeMasBarato(tarifas);
        System.out.println("Costo mínimo de 0 a n-1: " + resultado);
    }
}
