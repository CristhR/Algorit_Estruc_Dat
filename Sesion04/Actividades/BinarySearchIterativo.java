package Actividades;

public class BinarySearchIterativo {

    int binarySearch(int arr[], int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchIterativo ob = new BinarySearchIterativo();
        int arr[] = {1, 2, 3, 4, 5};
        int x = 3;
        int result = ob.binarySearch(arr, x);
        System.out.println(result == -1 ? "Elemento no encontrado" : "Elemento encontrado en índice: " + result);
    }
}
