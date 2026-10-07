package dev.gustavo.concorrencia;

import java.util.concurrent.CompletableFuture;

public class TesteCompra {

    public static void main(String[] args) {

        ServicoCompra servico = new ServicoCompra();
        long inicio = System.currentTimeMillis();

        CompletableFuture<Void> compraAna = comprar(servico, "Ana");
        CompletableFuture<Void> compraBruno = comprar(servico, "Bruno");
        CompletableFuture<Void> compraJoao = comprar(servico, "Joao");

        CompletableFuture.allOf(compraAna,compraBruno,compraJoao).join();

        long tempo = System.currentTimeMillis() - inicio;
        System.out.println("Tempo total: " + tempo + " ms");
    }

    static CompletableFuture<Void> comprar(ServicoCompra servicoCompra, String cliente){
        return CompletableFuture
                .supplyAsync(() -> servicoCompra.pagar(cliente))
                .thenApply(pagamento -> servicoCompra.emitirIngresso(pagamento))
                .thenAccept(ingresso -> servicoCompra.emitirIngresso(ingresso));
    }
}
