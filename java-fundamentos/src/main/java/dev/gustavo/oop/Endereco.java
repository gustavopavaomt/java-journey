package dev.gustavo.oop;

public record Endereco(String rua, int numero, String cidade) {

    public Endereco {
        if(rua.isBlank() || cidade.isBlank()){
            throw new IllegalArgumentException("Rua ou Cidade não podem ser vazias");
        }
        if(numero <=0){
            throw new IllegalArgumentException("O numero não pode ser negativo.");
        }
    }
}
