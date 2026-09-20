package dev.gustavo.oop;

import java.util.HashSet;

public class TesteIgualdade {

    public static void main(String[] args) {
        Motorista motorista1 = new Motorista("Gustavo", "6599434553", "QCR4245");
        Motorista motorista2 = new Motorista("Jose", "659945666", "QCR4245");
        HashSet<Motorista> lista = new HashSet<>();
        lista.add(motorista1);
        lista.add(motorista2);

        System.out.println(lista.size());

        Endereco endereco1 = new Endereco("Rua 1", 10, "Tangara da serra");
        Endereco endereco2 = new Endereco("Rua 1", 10, "Tangara da serra");

        System.out.println(endereco1.equals(endereco2));
    }

}
