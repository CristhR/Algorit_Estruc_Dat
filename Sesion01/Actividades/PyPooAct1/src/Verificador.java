public class Verificador {

    // Método que determina la relación entre dos rectángulos
    public static String determinarRelacion(Rectangulo rect1, Rectangulo rect2) {
        // Obtener las coordenadas de los rectángulos
        Coordenada A1 = rect1.getEsquina1();
        Coordenada A2 = rect1.getEsquina2();
        Coordenada B1 = rect2.getEsquina1();
        Coordenada B2 = rect2.getEsquina2();

        // Caso 3: Rectángulos son disjuntos (no se tocan ni se sobreponen)
        if (A2.getX() < B1.getX() || B2.getX() < A1.getX() ||  // Uno está a la izquierda/derecha del otro
            A2.getY() < B1.getY() || B2.getY() < A1.getY()) {  // Uno está arriba/abajo del otro
            return "Los rectángulos A y B son disjuntos.";
        }

        // Caso 2: Rectángulos están juntos (comparten borde sin superposición)
        if (A2.getX() == B1.getX() || B2.getX() == A1.getX() ||  // Tocan por los lados verticales
            A2.getY() == B1.getY() || B2.getY() == A1.getY()) {  // Tocan por los lados horizontales
            return "Los rectángulos A y B están juntos.";
        }

        // Caso 1: Rectángulos se sobreponen (comparten área interna)
        return "Los rectángulos A y B se sobreponen.";
    }
}
