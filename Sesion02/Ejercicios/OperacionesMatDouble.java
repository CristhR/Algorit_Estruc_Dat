package Ejercicios;

public class OperacionesMatDouble implements Operable<Double> {
    private Double valor;

    public OperacionesMatDouble(Double valor) {
        this.valor = valor;
    }
    @Override
    public Double sumar(Double otro) {
        return valor + otro;
    }
    @Override
    public Double restar(Double otro) {
        return valor - otro;
    }
    @Override
    public Double multiplicar(Double otro) {
        return valor * otro;
    }
    @Override
    public Double dividir(Double otro) {
        if (otro == 0) throw new ArithmeticException("No se puede dividir por cero.");
        return valor / otro;
    }
    @Override
    public Double potencia(Double exponente) {
        return Math.pow(valor, exponente);
    }
    @Override
    public Double raizCuadrada() {
        return Math.sqrt(valor);
    }
    @Override
    public Double raizCubica() {
        return Math.cbrt(valor);
    }
}
