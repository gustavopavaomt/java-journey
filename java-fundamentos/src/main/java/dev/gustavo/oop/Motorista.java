package dev.gustavo.oop;

import java.util.Objects;

public final class Motorista extends Usuario {

    private String placa;
    private double avaliacaoMedia;
    private int corridasConcluidas;

    public String getPlaca() {
        return placa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(placa, motorista.placa);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(placa);
    }

    public Motorista(String nome, String telefone, String placa) {
        super(nome, telefone);
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("Placa inválida.");
        }
        this.placa = placa;
        this.avaliacaoMedia = 5.0;
        this.corridasConcluidas = 0;
    }


    public void registrarCorrida(double nota) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("Nota inválida. apenas pode ser de 1 a 5.");
        }
        double somaAntiga = avaliacaoMedia * corridasConcluidas;
        double somaNova = somaAntiga + nota;
        this.avaliacaoMedia = somaNova / (corridasConcluidas + 1);
        this.corridasConcluidas++;
    }

    public int getCorridasConcluidas() {
        return corridasConcluidas;
    }

    public double getAvaliacaoMedia() {
        return avaliacaoMedia;
    }

    @Override
    public String descrever() {
        return super.descrever() + " | " + placa + " | " +avaliacaoMedia;
    }
}