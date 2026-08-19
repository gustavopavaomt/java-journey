package dev.gustavo.fundamentos;

public class Aplicacao{
    public static void main(String[] args){
        Calculadora calculadora = new Calculadora();

        System.out.println("2 + 3 = "+ calculadora.somar(2,3));
    }
}