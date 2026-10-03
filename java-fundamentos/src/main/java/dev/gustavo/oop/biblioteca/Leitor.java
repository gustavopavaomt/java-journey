package dev.gustavo.oop.biblioteca;

public abstract sealed class Leitor permits Aluno, Professor {

    private String nome;

    public Leitor(String nome) {

        if(nome == null || nome.isBlank()){
            throw new IllegalArgumentException("O leitor precisa de um nome");
        }
        this.nome = nome;
    }

    public int prazoDeEmprestimo(){
            return switch (this){
                case Professor p -> 14;
                case Aluno a -> 7;
            };
    }

    public String getNome() {
        return nome;
    }
}
