package dev.gustavo.concorrencia.pizzaria;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TesteNoiteMovimentada {

    public static void main(String[] args) throws InterruptedException {
        ServicoPedido servicoPedido = new ServicoPedido();
        RelatorioPedidos relatorioPedidos = new RelatorioPedidos();
        Estoque estoque = new Estoque();

        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50; i++) {
            double valor;
            if (i % 5 == 0) {
                valor = 200.0;
            } else {
                valor = 80.0;
            }
            Pedido pedido = new Pedido(i, "Cliente " + i, "Calabresa", valor);
            executorService.submit(() -> {
                try {
                    servicoPedido.pagar(pedido);
                } catch (PagamentoRecusadoException e) {
                    System.out.println(e.getMessage());
                    relatorioPedidos.registrarRecusado();
                    return;
                }
                if (!estoque.reservarMassa()) {
                    System.out.println("Pedido " + pedido.pedido() + ": sem massa");
                    relatorioPedidos.registrarRecusado();
                    return;
                }
                String pizza = servicoPedido.preparar(pedido);
                servicoPedido.entregar(pedido, pizza);
                relatorioPedidos.registrarAceito();
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
        long tempo = System.currentTimeMillis() - inicio;

        System.out.println("Aceitos: " + relatorioPedidos.getAceitos());
        System.out.println("Recusados: " + relatorioPedidos.getRecusados());
        System.out.println("Total: " + relatorioPedidos.getTotal());
        System.out.println("Massas Restantes: " + estoque.getMassasDisponiveis());
        System.out.println("Tempo: " + tempo + " ms");

    }
}
