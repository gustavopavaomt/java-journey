package dev.gustavo.oop;

public class TesteUsuario {
    public static void main(String[] args) {
        Motorista motoristaTeste = new Motorista("Joao","659949349","QCR8768");
        Passageiro passageiroTeste = new Passageiro("Maria", "6594234523");

        System.out.println(motoristaTeste.descrever());
        System.out.println(passageiroTeste.descrever());
    }
}
