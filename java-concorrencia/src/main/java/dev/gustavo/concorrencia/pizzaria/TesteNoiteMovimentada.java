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
        AtendimentoPedido atendimento = new AtendimentoPedido(servicoPedido,estoque,relatorioPedidos);
        for (int i = 1; i <= 50; i++) {
            double valor;
            if (i % 5 == 0) {
                valor = 200.0;
            } else {
                valor = 80.0;
            }
            Pedido pedido = new Pedido(i, "Cliente " + i, "Calabresa", valor);
            executorService.submit(() -> atendimento.atender(pedido));
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
