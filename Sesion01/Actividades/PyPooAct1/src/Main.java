import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ingreso de datos para el primer rectángulo
        System.out.println("Ingrese las coordenadas de una esquina del 1er rectángulo: ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        System.out.println("Ingrese la esquina opuesta del 1er rectángulo: ");
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        Rectangulo rect1 = new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));

        // Ingreso de datos para el segundo rectángulo
        System.out.println("Ingrese las coordenadas de una esquina del 2do rectángulo: ");
        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        System.out.println("Ingrese la esquina opuesta del 2do rectángulo: ");
        double x4 = sc.nextDouble();
        double y4 = sc.nextDouble();

        Rectangulo rect2 = new Rectangulo(new Coordenada(x3, y3), new Coordenada(x4, y4));

        // Mostrar información de los rectángulos
        System.out.println("Rectángulo A = " + rect1);
        System.out.println("Rectángulo B = " + rect2);

        // Determinar la relación entre los rectángulos
        String resultado = Verificador.determinarRelacion(rect1, rect2);
        System.out.println(resultado);

        // Si los rectángulos se sobreponen, calcular el área de intersección
        if (resultado.contains("se sobreponen")) {
            double areaSobreposicion = rect1.calcularAreaSobreposicion(rect2);
            System.out.println("Área de sobreposición = " + areaSobreposicion);
        }

        sc.close();
    }
}
