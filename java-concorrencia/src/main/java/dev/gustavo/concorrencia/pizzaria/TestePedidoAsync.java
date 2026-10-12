package dev.gustavo.concorrencia.pizzaria;

import java.util.concurrent.CompletableFuture;

public class TestePedidoAsync  {
    public static void main(String[] args) {
        ServicoPedido servicoPedido = new ServicoPedido();
        RelatorioPedidos relatorioPedidos = new RelatorioPedidos();
        Pedido pedido1 = new Pedido(1,"Ana","Calabresa",60.0);
        Pedido pedido2 = new Pedido(2,"Joao","Frango",200.0);
        Pedido pedido3 = new Pedido(3,"Maria","Queijo",90.0);
        long inicio = System.currentTimeMillis();

        CompletableFuture<Void> pedidoAna = processar(servicoPedido,relatorioPedidos, pedido1);
        CompletableFuture<Void> pedidoJoao = processar(servicoPedido,relatorioPedidos, pedido2);
        CompletableFuture<Void> pedidoMaria = processar(servicoPedido,relatorioPedidos, pedido3);

        CompletableFuture.allOf(pedidoAna,pedidoJoao,pedidoMaria).join();

        long tempo = System.currentTimeMillis() - inicio;
        System.out.println("Tempo: " +tempo + " ms");
        System.out.println("Aceitos: "+relatorioPedidos.getAceitos());
        System.out.println("Recusados: "+relatorioPedidos.getRecusados());
    }

    static CompletableFuture<Void> processar(
            ServicoPedido servicoPedido,
            RelatorioPedidos relatorioPedidos,
            Pedido pedido) {
        return CompletableFuture
                .supplyAsync(() -> servicoPedido.pagar(pedido))
                .thenApply(pagamento -> servicoPedido.preparar(pedido))
                .thenAccept(pizza -> {
                    servicoPedido.entregar(pedido, pizza);
                    relatorioPedidos.registrarAceito();
                }).exceptionally(erro -> {
                    relatorioPedidos.registrarRecusado();
                    System.out.println(erro.getCause().getMessage());
                    return null;
                });
    }
}
