package Ejercicios;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\nMenú de Operaciones Clases Genéricas:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Producto");
            System.out.println("4. División");
            System.out.println("5. Potencia");
            System.out.println("6. Raíz Cuadrada");
            System.out.println("7. Raíz Cúbica");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 5) {
                System.out.print("Ingrese el tipo de dato (1: Integer, 2: Double): ");
                int tipo = scanner.nextInt();

                if (tipo == 1) {
                    System.out.print("Ingrese el primer número entero: ");
                    int num1 = scanner.nextInt();
                    OperacionesMatInteger opInt = new OperacionesMatInteger(num1);

                    if (opcion != 6 && opcion != 7) { 
                        System.out.print("Ingrese el segundo número entero: ");
                        int num2 = scanner.nextInt();

                        ejecutarOperacion(opcion, opInt, num2);
                    } else {
                        ejecutarOperacion(opcion, opInt, 0);
                    }

                } else if (tipo == 2) {
                    System.out.print("Ingrese el primer número decimal: ");
                    double num1 = scanner.nextDouble();
                    OperacionesMatDouble opDouble = new OperacionesMatDouble(num1);

                    if (opcion != 6 && opcion != 7) { 
                        System.out.print("Ingrese el segundo número decimal: ");
                        double num2 = scanner.nextDouble();

                        ejecutarOperacion(opcion, opDouble, num2);
                    } else {
                        ejecutarOperacion(opcion, opDouble, 0.0);
                    }
                } else {
                    System.out.println("Tipo no válido.");
                }
            } else if (opcion != 8) {
                System.out.println("Opción no válida.");
            }
        } while (opcion != 8);

        System.out.println("Programa finalizado.");
        scanner.close();
    }

    private static <E> void ejecutarOperacion(int opcion, Operable<E> operacion, E valor) {
        switch (opcion) {
            case 1 -> System.out.println("Resultado: " + operacion.sumar(valor));
            case 2 -> System.out.println("Resultado: " + operacion.restar(valor));
            case 3 -> System.out.println("Resultado: " + operacion.multiplicar(valor));
            case 4 -> {
                try {
                    System.out.println("Resultado: " + operacion.dividir(valor));
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 5 -> System.out.println("Resultado: " + operacion.potencia(valor));
            case 6 -> System.out.println("Resultado: " + operacion.raizCuadrada());
            case 7 -> System.out.println("Resultado: " + operacion.raizCubica());
            default -> System.out.println("Opción no válida.");
        }
    }
}
