package dev.gustavo.oop.biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {
    private final Map<String, Livro> acervo = new HashMap<>();
    private final List<Emprestimo> emprestimos = new ArrayList<>();


    public void cadastrarLivro(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException(("Livro nao pode ser nulo"));
        }

        if (acervo.containsKey(livro.getCodigo())) {
            throw new IllegalArgumentException("Ja existe um livro com o codigo: " + livro.getCodigo());
        }

        acervo.put(livro.getCodigo(), livro);

    }

    public Optional<Livro> buscarPorCodigo(String codigo) {
        return Optional.ofNullable(acervo.get(codigo));
    }

    public Emprestimo emprestarLivro(String codigo, Leitor leitor) {
        Livro livro = buscarPorCodigo(codigo).orElseThrow(() -> new NoSuchElementException(
                "Livro com codigo " + codigo + " não encontrado."
        ));

        if (estaEmprestado(codigo)) {
            throw new LivroJaEmprestadoException("O livro com o codigo " + livro.getCodigo() + " ja esta em um emprestimo ativo.");
        }

        Emprestimo emprestimo = new Emprestimo(leitor, livro);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public List<String> titulosDisponiveis() {
        return acervo.values()
                .stream()
                .filter(livro -> !estaEmprestado(livro.getCodigo()))
                .map(Livro::getTitulo)
                .toList();
    }

    private boolean estaEmprestado(String codigo) {
        return emprestimos.stream()
                .anyMatch(emprestimo ->
                        emprestimo.isAtivo()
                                && emprestimo.getLivro()
                                .getCodigo()
                                .equals(codigo)
                );
    }

    public long quantidadeEmprestimosAtivos() {
        return emprestimos.stream()
                .filter(Emprestimo::isAtivo)
                .count();
    }

    public List<Livro> livrosPorAutor(String autor) {
        return acervo.values()
                .stream()
                .filter(livro -> livro.getAutor().equalsIgnoreCase(autor))
                .sorted(Comparator.comparingInt(Livro::getAnoPublicacao))
                .toList();
    }

}
