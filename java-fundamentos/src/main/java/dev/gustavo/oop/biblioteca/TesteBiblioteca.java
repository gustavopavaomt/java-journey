package dev.gustavo.oop.biblioteca;

public class TesteBiblioteca {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro1 = new Livro(
                1881,
                "L001",
                "Memorias Postumas de Bras Cubas",
                "Machado de Assis"
        );

        Livro livro2 = new Livro(
                1899,
                "L002",
                "Dom Casmundo",
                "Machado de Assis"
        );

        Livro livro3 = new Livro(
                1903,
                "L003",
                "O Hobbit",
                "J.R.R. Tolkien"
        );

        Livro livro4 = new Livro(
                1984,
                "L004",
                "As aventuras de Pi",
                "George Orwell"
        );

        Livro livro5 = new Livro(
                1989,
                "L005",
                "O Pequeno Principe",
                "Antoine de Saint-Exupery"
        );
        biblioteca.cadastrarLivro(livro1);
        biblioteca.cadastrarLivro(livro2);
        biblioteca.cadastrarLivro(livro3);
        biblioteca.cadastrarLivro(livro4);
        biblioteca.cadastrarLivro(livro5);


        Leitor aluno = new Aluno("Carlos");

        Leitor professor = new Professor("Marcos");

        Emprestimo emprestimoAluno =
                biblioteca.emprestarLivro("L001", aluno);

        Emprestimo emprestimoProfessor =
                biblioteca.emprestarLivro("L003", professor);

        System.out.println(
                aluno.getNome()
                        + " pegou "
                        + emprestimoAluno.getLivro().getTitulo()
                        + " por "
                        + emprestimoAluno.getPrazo()
                        + " dias."
        );

        System.out.println(
                professor.getNome()
                        + " pegou "
                        + emprestimoProfessor.getLivro().getTitulo()
                        + " por "
                        + emprestimoProfessor.getPrazo()
                        + " dias."
        );


        try {

            biblioteca.emprestarLivro("L001", professor);

        } catch (LivroJaEmprestadoException e) {

            System.out.println(e.getMessage());
        }

        System.out.println(
                "L001: "
                        + biblioteca.buscarPorCodigo("L001")
                        .map(Livro::getTitulo)
                        .orElse("Nao encontrado")
        );

        System.out.println(
                "L999: "
                        + biblioteca.buscarPorCodigo("L999")
                        .map(Livro::getTitulo)
                        .orElse("Nao encontrado")
        );

        biblioteca.titulosDisponiveis()
                .forEach(System.out::println);

        System.out.println(
                biblioteca.quantidadeEmprestimosAtivos()
        );

        biblioteca.livrosPorAutor("Machado de Assis")
                .forEach(System.out::println);

        emprestimoAluno.devolver();

        System.out.println(
                emprestimoAluno.getLivro().getTitulo()
                        + " devolvido."
        );

        try {

            emprestimoAluno.devolver();

        } catch (IllegalStateException e) {

            System.out.println(e.getMessage());
        }

        biblioteca.titulosDisponiveis()
                .forEach(System.out::println);
    }
}
