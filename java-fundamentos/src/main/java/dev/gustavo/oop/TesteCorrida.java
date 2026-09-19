package dev.gustavo.oop;

public class TesteCorrida {

    public static void main(String[] args) {
       Motorista motorista = new Motorista("Gustavo","6599343565","QCR3844");
       Corrida corrida = new Corrida(motorista, 10.0);

        System.out.println("Valor a ser cobrado: " + corrida.calcularValor());
    }
}
