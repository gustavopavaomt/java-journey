package dev.gustavo.oop;

public class TesteMotorista {

    public static void main(String[] args){
        Motorista gustavo = new Motorista("Gustavo","QCR7465");
        gustavo.registrarCorrida(4.0);
        gustavo.registrarCorrida(4.0);
        gustavo.registrarCorrida(4.0);
        gustavo.registrarCorrida(5.0);

        System.out.println(gustavo.getAvaliacaoMedia());

        try {
            gustavo.registrarCorrida(10.0);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
