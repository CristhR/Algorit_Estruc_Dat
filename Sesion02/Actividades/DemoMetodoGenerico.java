package Actividades;

class DemoMetodoGenerico {
    static boolean igualArrays(Number[] x, Number[] y) {
        // Si las longitudes de los arrays son diferentes, entonces los arrays son diferentes
        if (x.length != y.length)
            return false;

        for (int i = 0; i < x.length; i++) {
            if (x[i].doubleValue() != y[i].doubleValue()) // Se convierten a double para comparación
                return false;
        }

        return true; // Contenido de arrays son equivalentes
    }

    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5};
        Integer nums2[] = {1, 2, 3, 4, 5};
        Integer nums3[] = {1, 2, 7, 4, 5};
        Integer nums4[] = {1, 2, 7, 4, 5, 6};

        if (igualArrays(nums, nums))
            System.out.println("nums es igual a nums");
        if (igualArrays(nums, nums2))
            System.out.println("nums es igual a nums2");
        if (igualArrays(nums, nums3))
            System.out.println("nums es igual a nums3");
        if (igualArrays(nums, nums4))
            System.out.println("nums es igual a nums4");

        // Ahora la comparación entre Integer y Double funciona
        Double dvals[] = {1.0, 2.0, 3.0, 4.0, 5.0}; // Se usan valores exactos
        if (igualArrays(nums, dvals))
            System.out.println("nums es igual a dvals");
    }
}
