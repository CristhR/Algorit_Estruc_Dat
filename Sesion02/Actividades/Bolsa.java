package Actividades;

import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa<T> implements Iterable<T> {
    private ArrayList<T> lista = new ArrayList<>();
    private int tope;

    public Bolsa(int tope) {
        this.tope = tope;
    }

    public void add(T objeto) {
        if (lista.size() < tope) { // Se corrigió la condición
            lista.add(objeto);
        } else {
            throw new RuntimeException("No caben más elementos");
        }
    }

    public Iterator<T> iterator() {
        return lista.iterator();
    }
}
