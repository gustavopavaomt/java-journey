package dev.gustavo.concorrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TesteBilheteriaPool {


    public static void main(String[] args) throws InterruptedException {
        Bilheteria bilheteria = new Bilheteria();
        ExecutorService atendentes = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 150; i++){
            atendentes.submit(bilheteria::vender);
        }

        atendentes.shutdown();
        atendentes.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Disponiveis: "+ bilheteria.getIngressosDisponiveis());
        System.out.println("Vendidos: "+ bilheteria.getIngressosVendidos());
        System.out.println("Bilheteria fechada!");
    }
}
