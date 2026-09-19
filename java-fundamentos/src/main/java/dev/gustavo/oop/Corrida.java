package dev.gustavo.oop;

public class Corrida implements Cobravel {

    private Motorista motorista;
    private double distanciaKm;

    public Corrida(Motorista motorista, double distanciaKm) {
        if (distanciaKm <=0) {
            throw new IllegalArgumentException("A distância precisa ser positiva.");
        }
        this.motorista = motorista;
        this.distanciaKm = distanciaKm;
    }

    @Override
    public double calcularValor() {
        return 5.0 + 2.0 * distanciaKm;
    }
}
