package dev.gustavo.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TesteEstruturas {

    public static void main(String[] args) {
        Map<String, Motorista> motoristasPorPlaca = new HashMap<>();
        Motorista motorista1 = new Motorista("Gustavo", "659993993", "QCR5454");
        Motorista motorista2 = new Motorista("Joao", "659993323", "JRC1232");
        Motorista motorista3 = new Motorista("Mateus", "659993545", "KLM4049");

        motoristasPorPlaca.put(motorista1.getPlaca(), motorista1);
        motoristasPorPlaca.put(motorista2.getPlaca(), motorista2);
        motoristasPorPlaca.put(motorista3.getPlaca(), motorista3);

        Motorista achado = motoristasPorPlaca.get("QCR5454");
        System.out.println(achado.descrever());

        System.out.println(motoristasPorPlaca.keySet());

        Map<String, Motorista> ordenado = new TreeMap<>(motoristasPorPlaca);
        System.out.println(ordenado.keySet());

    }
}
