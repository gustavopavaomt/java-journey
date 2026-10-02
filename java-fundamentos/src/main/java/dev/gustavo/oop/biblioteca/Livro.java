package dev.gustavo.oop.biblioteca;

public class Livro {

    private final String codigo;
    private final String titulo;
    private final String autor;
    private final int anoPublicacao;

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

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo='" + codigo + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                '}';
    }
}
