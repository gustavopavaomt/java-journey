package dev.gustavo.concorrencia;

public class Bilheteria {

    private int ingressosDisponiveis = 100;
    private int ingressosVendidos = 0;

    public synchronized void vender(){
        if(ingressosDisponiveis >0){
            System.out.println(Thread.currentThread().getName()
            + " vendeu o ingresso " + ingressosDisponiveis);
            ingressosDisponiveis--;
            ingressosVendidos++;
        }
    }

    public int getIngressosDisponiveis() {
        return ingressosDisponiveis;
    }

    public int getIngressosVendidos() {
        return ingressosVendidos;
    }
}
