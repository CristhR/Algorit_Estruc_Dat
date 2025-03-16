import java.util.*;

public class Rectangulo {
    private Coordenada esquina1; // Esquina inferior izquierda
    private Coordenada esquina2; // Esquina superior derecha

    // Constructor que ordena las coordenadas correctamente
    public Rectangulo(Coordenada c1, Coordenada c2) {
        double minX = Math.min(c1.getX(), c2.getX());
        double minY = Math.min(c1.getY(), c2.getY());
        double maxX = Math.max(c1.getX(), c2.getX());
        double maxY = Math.max(c1.getY(), c2.getY());

        this.esquina1 = new Coordenada(minX, minY);
        this.esquina2 = new Coordenada(maxX, maxY);
    }

    // Setters
    public void setEsquina1(Coordenada coo) {
        this.esquina1 = coo;
    }

    public void setEsquina2(Coordenada coo) {
        this.esquina2 = coo;
    }

    // Getters
    public Coordenada getEsquina1() {
        return esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    // Método que calcula el área del rectángulo
    public double calculoArea() {
        double base = esquina2.getX() - esquina1.getX();
        double altura = esquina2.getY() - esquina1.getY();
        return base * altura;
    }
    
    public double calcularAreaSobreposicion(Rectangulo otro) {
        double x1 = Math.max(this.esquina1.getX(), otro.getEsquina1().getX());
        double y1 = Math.max(this.esquina1.getY(), otro.getEsquina1().getY());
        double x2 = Math.min(this.esquina2.getX(), otro.getEsquina2().getX());
        double y2 = Math.min(this.esquina2.getY(), otro.getEsquina2().getY());

        double ancho = x2 - x1;
        double alto = y2 - y1;

        // Si no hay intersección, el área es 0
        if (ancho > 0 && alto > 0) {
            return ancho * alto;
        } else {
            return 0;
        }
    }


    // Método toString() para imprimir el rectángulo en formato adecuado
    @Override
    public String toString() {
        return "Rectángulo: (" + esquina1 + ", " + esquina2 + ")";
    }

    public static void main(String[] args) {
        // Prueba de la clase Rectangulo
        Coordenada c1 = new Coordenada(1.5, 0.3);
        Coordenada c2 = new Coordenada(7.6, 2.2);
        Rectangulo r1 = new Rectangulo(c1, c2);

        System.out.println(r1);
        System.out.println("Área del rectángulo: " + r1.calculoArea());
    }
}
