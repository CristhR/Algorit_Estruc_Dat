package Ejercicios;

import java.util.Random;

public class KEsimoMenor {

    static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];

        int pivotIndex = new Random().nextInt(right - left + 1) + left;
        pivotIndex = partition(arr, left, right, pivotIndex);

        int length = pivotIndex - left + 1;

        if (k == length) return arr[pivotIndex];
        else if (k < length) return quickSelect(arr, left, pivotIndex - 1, k);
        else return quickSelect(arr, pivotIndex + 1, right, k - length);
    }

    static int partition(int[] arr, int left, int right, int pivotIndex) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, right, storeIndex);
        return storeIndex;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[][] casos = {
            {4, 2, 7, 10, 4, 17},
            {4, 2, 7, 10, 4, 1, 6},
            {4, 2, 7, 1, 4, 6},
            {9, 2, 7, 1, 7}
        };
        int[] ks = {3, 5, 1, 4};

        for (int i = 0; i < casos.length; i++) {
            int res = quickSelect(casos[i], 0, casos[i].length - 1, ks[i]);
            System.out.println("Entrada: " + java.util.Arrays.toString(casos[i]) +
                               ", k = " + ks[i] + " → Resultado: " + res);
        }
    }
}
