package dev.gustavo.oop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TesteLambdas {

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

        listaMotoristas.sort((m1, m2) -> m1.getNome().compareTo(m2.getNome()));

        for (Motorista list1 : listaMotoristas) {
            System.out.println(list1.descrever());
        }

        listaMotoristas.sort((m1, m2) -> Double.compare(m2.getAvaliacaoMedia(), m1.getAvaliacaoMedia()));

        for (Motorista list2 : listaMotoristas) {
            System.out.println(list2.descrever());
        }

        listaMotoristas.sort(Comparator.comparing(Motorista::getNome));

        for (Motorista list3 : listaMotoristas) {
            System.out.println(list3.descrever());
        }
    }
}
