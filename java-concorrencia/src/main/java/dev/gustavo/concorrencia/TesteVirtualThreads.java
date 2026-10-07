package dev.gustavo.concorrencia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TesteVirtualThreads {

    public static void main(String[] args) throws InterruptedException {

        ProcessadorPagamento processadorPagamento = new ProcessadorPagamento();

        //ExecutorService caixas = Executors.newFixedThreadPool(100);

        ExecutorService caixas = Executors.newVirtualThreadPerTaskExecutor();

        long inicio = System.currentTimeMillis();

        for(int i = 0; i <=1000; i++){
            String cliente = "Cliente " +i;
            caixas.submit(() -> processadorPagamento.processar(cliente, 100.0));
        }

        caixas.shutdown();
        caixas.awaitTermination(1, TimeUnit.MINUTES);

        long tempo = System.currentTimeMillis() - inicio;
        System.out.println("1000 pagamentos em " +tempo+ " ms");
    }
}
