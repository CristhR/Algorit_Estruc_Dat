package Ejercicios;

public class OperacionesMatInteger implements Operable<Integer> {
    private Integer valor;

    public OperacionesMatInteger(Integer valor) {
        this.valor = valor;
    }
    @Override
    public Integer sumar(Integer otro) {
        return valor + otro;
    }
    @Override
    public Integer restar(Integer otro) {
        return valor - otro;
    }
    @Override
    public Integer multiplicar(Integer otro) {
        return valor * otro;
    }
    @Override
    public Integer dividir(Integer otro) {
        if (otro == 0) throw new ArithmeticException("No se puede dividir por cero.");
        return valor / otro;
    }
    @Override
    public Integer potencia(Integer exponente) {
        return (int) Math.pow(valor, exponente);
    }
    @Override
    public Integer raizCuadrada() {
        return (int) Math.sqrt(valor);
    }
    @Override
    public Integer raizCubica() {
        return (int) Math.cbrt(valor);
    }
}
