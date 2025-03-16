package Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContainerRect contenedor = new ContainerRect(10); // Se pueden almacenar hasta 10 rectángulos

        for (int i = 1; i <= 2; i++) {
            System.out.println("Ingrese las coordenadas de una esquina del " + i + "er rectángulo: ");
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();

            System.out.println("Ingrese la esquina opuesta del " + i + "er rectángulo: ");
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();

            Rectangulo rect = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
            contenedor.addRectangulo(rect);
        }

        System.out.println("\n" + contenedor);

        sc.close();
    }
}
