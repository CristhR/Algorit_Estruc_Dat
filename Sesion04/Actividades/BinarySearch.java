package Actividades;

public class BinarySearch {

    int binarySearch(int arr[], int lo, int hi, int x) {
        if (hi >= lo && lo < arr.length) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] > x) return binarySearch(arr, lo, mid - 1, x);
            return binarySearch(arr, mid + 1, hi, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {1, 2, 3, 4, 5};
        int x = 4;
        int result = ob.binarySearch(arr, 0, arr.length - 1, x);
        System.out.println(result == -1 ? "Elemento no encontrado" : "Elemento encontrado en índice: " + result);
    }
}
