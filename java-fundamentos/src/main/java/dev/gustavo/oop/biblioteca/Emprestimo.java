package dev.gustavo.oop.biblioteca;

public class Emprestimo {

    private Leitor leitor;
    private Livro livro;
    private int prazo;
    private StatusEmprestimo statusEmprestimo;

    public Emprestimo(Leitor leitor, Livro livro) {
        this.leitor = leitor;
        this.livro = livro;
        this.statusEmprestimo = StatusEmprestimo.ATIVO;
        this.prazo = leitor.prazoDeEmprestimo();
    }

    public void devolver(){
        if(statusEmprestimo != StatusEmprestimo.ATIVO){
        
            throw new IllegalStateException("Status do emprestimo: " + statusEmprestimo + " | Precisa estar ATIVA.");
        }
        this.statusEmprestimo = StatusEmprestimo.DEVOLVIDO;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getPrazo() {
        return prazo;
    }

    public StatusEmprestimo getStatusEmprestimo() {
        return statusEmprestimo;
    }

    public boolean isAtivo() {
        return statusEmprestimo == StatusEmprestimo.ATIVO;
    }
}
