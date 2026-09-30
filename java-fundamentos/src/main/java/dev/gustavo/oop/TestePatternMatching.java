package dev.gustavo.oop;

import java.util.ArrayList;
import java.util.List;

public class TestePatternMatching {

    public static void main(String[] args) {
        Motorista motorista = new Motorista("Gustavo","659942242","QRC1233");
        Passageiro passageiro = new Passageiro("Joao","564223232");
        List<Usuario> lista = new ArrayList<>();
        lista.add(motorista);
        lista.add(passageiro);

        for(Usuario u : lista){
            System.out.println(resumo(u));
        }


    }
    
    static String resumo(Usuario usuario){
        return switch (usuario){
            case Motorista m -> "Motorista: " + m.getNome() + " | Placa " + m.getPlaca();
            case Passageiro p -> "Passageiro: " + p.getNome();
        };
    }
}
