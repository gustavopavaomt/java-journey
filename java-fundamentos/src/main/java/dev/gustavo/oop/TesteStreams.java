package dev.gustavo.oop;

import java.util.ArrayList;
import java.util.List;

public class TesteStreams {

    public static void main(String[] args) {
        Motorista motorista1 = new Motorista("Gustavo", "6599434553", "QCR4245");
        Motorista motorista2 = new Motorista("Jose", "659945666", "ATX1920");
        Motorista motorista3 = new Motorista("Mateus", "659945446", "JPQ1029");
        motorista1.registrarCorrida(3.0);
        motorista2.registrarCorrida(4.0);
        motorista3.registrarCorrida(1.0);
        List<Motorista> listaMotoristas = new ArrayList<>();

        listaMotoristas.add(motorista1);
        listaMotoristas.add(motorista2);
        listaMotoristas.add(motorista3);
        List<String> nomes = listaMotoristas.stream()
                .filter(m -> m.getAvaliacaoMedia() >= 3.0)
                .map(m -> m.descrever())
                .toList();
        System.out.println(nomes);

        listaMotoristas.stream()
                .map(m -> m.getNome())
                .forEach(System.out::println);

        long avaliacaoMenorQue3 = listaMotoristas.stream()
                .filter(m -> m.getAvaliacaoMedia() <3)
                .count();
        System.out.println(avaliacaoMenorQue3);
        System.out.println(listaMotoristas.size());
    }
}
