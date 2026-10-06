package dev.gustavo.concorrencia;

public class ProcessadorPagamento {

    public boolean processar(String cliente, double valor) throws InterruptedException {

        Thread.sleep(1000);
        return valor <= 500;

    }
}
