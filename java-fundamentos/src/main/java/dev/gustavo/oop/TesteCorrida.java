package dev.gustavo.oop;

public class TesteCorrida {

    public static void main(String[] args) {
        Motorista motorista = new Motorista("Gustavo", "6599343565", "QCR3844");
        Endereco origem = new Endereco("Rua A", 10, "Cuiaba");
        Endereco destino = new Endereco("Rua B", 22, "Cuiaba");
        Corrida corrida = new Corrida(motorista, 10.0, origem, destino);
        System.out.println(origem);
//        System.out.println(corrida.getStatusCorrida());
//        corrida.iniciar();
//        System.out.println(corrida.getStatusCorrida());
//        corrida.finalizar();
//        System.out.println(corrida.getStatusCorrida());

    }
}
