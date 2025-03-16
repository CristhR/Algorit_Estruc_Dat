package Ejercicio1;

import java.util.ArrayList;

public class ContainerRect {
    private Rectangulo[] rectangulos;
    private double[] distancias;
    private double[] areas;
    private int capacidad;
    private int numRec = 0;

    public ContainerRect(int capacidad) {
        this.capacidad = capacidad;
        this.rectangulos = new Rectangulo[capacidad];
        this.distancias = new double[capacidad];
        this.areas = new double[capacidad];
    }

    public void addRectangulo(Rectangulo r) {
        if (numRec < capacidad) {
            rectangulos[numRec] = r;
            distancias[numRec] = r.getEsquina1().distancia(r.getEsquina2());
            areas[numRec] = r.calculoArea();
            numRec++;
        } else {
            System.out.println("No se puede agregar más rectángulos. Capacidad máxima alcanzada.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rectángulo | Coordenadas | Distancia | Área\n");
        for (int i = 0; i < numRec; i++) {
            sb.append(i + 1).append(" | ")
              .append(rectangulos[i]).append(" | ")
              .append(String.format("%.3f", distancias[i])).append(" | ")
              .append(String.format("%.2f", areas[i])).append("\n");
        }
        return sb.toString();
    }
}
