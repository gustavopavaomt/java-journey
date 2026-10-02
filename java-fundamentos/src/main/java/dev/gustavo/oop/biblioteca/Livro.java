package dev.gustavo.oop.biblioteca;

public class Livro {

    private String codigo;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(int anoPublicacao, String codigo, String titulo, String autor) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Codigo é obrigatório.");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Titulo é obrigatório.");
        }
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("Autor é obrigatório.");
        }
        if (anoPublicacao <=0 ){
            throw new IllegalArgumentException("Ano precisa ser positivo.");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }
}
