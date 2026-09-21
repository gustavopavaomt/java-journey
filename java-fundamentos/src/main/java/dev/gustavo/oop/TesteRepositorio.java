package dev.gustavo.oop;

import java.util.Optional;

public class TesteRepositorio {

    public static void main(String[] args) {
        Repositorio<Motorista> motoristaRepositorio = new Repositorio<>();
        Repositorio<Endereco> enderecoRepositorio = new Repositorio<>();

        Motorista motorista1 = new Motorista("Gustavo", "6599434553", "PAQ4245");
        Motorista motorista2 = new Motorista("Jose", "659945666", "QCR4145");
        motoristaRepositorio.salvar(motorista1);
        motoristaRepositorio.salvar(motorista2);

        System.out.println(motoristaRepositorio.total());

        Endereco endereco1 = new Endereco("Rua 1", 10, "Tangara da serra");
        enderecoRepositorio.salvar(endereco1);

        for (Motorista motorista : motoristaRepositorio.listarTodos()) {
            System.out.println(motorista.descrever());
        }
        Optional<Motorista> achado = motoristaRepositorio.buscarPorIndice(0);
        achado.ifPresent(motorista -> System.out.println(motorista.descrever()));

        Optional<Motorista> naoAchado = motoristaRepositorio.buscarPorIndice(99);
        String motorista = naoAchado
                .map(motorista3 -> motorista3.descrever())
                .orElse("Não encontrado");
        System.out.println(motorista);
    }
}
