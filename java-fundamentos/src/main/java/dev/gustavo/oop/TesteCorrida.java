package dev.gustavo.oop;

public class TesteCorrida {

    public static void main(String[] args) {
        Motorista motorista = new Motorista("Gustavo", "6599343565", "QCR3844");
        Corrida corrida = new Corrida(motorista, 10.0);
        try {
            System.out.println(corrida.getStatusCorrida());
            corrida.iniciar();
            System.out.println(corrida.getStatusCorrida());
            corrida.finalizar();
            System.out.println(corrida.getStatusCorrida());
        }catch (IllegalStateException e){
            System.out.println(e.getMessage());
        }
    }
}
