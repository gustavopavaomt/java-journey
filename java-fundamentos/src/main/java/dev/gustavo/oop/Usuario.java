package dev.gustavo.oop;

public abstract sealed class Usuario permits Motorista, Passageiro {

    private String nome;
    private String telefone;

    public Usuario(String nome, String telefone) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone é obrigatório.");
        }

        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String descrever(){
        return nome + " - " + telefone;
    }
}
