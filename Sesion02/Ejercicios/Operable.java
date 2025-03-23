package Ejercicios;

public interface Operable<E> {
    E sumar(E otro);
    E restar(E otro);
    E multiplicar(E otro);
    E dividir(E otro);
    E potencia(E exponente);
    E raizCuadrada();
    E raizCubica();
}
