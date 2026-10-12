package dev.gustavo.concorrencia.pizzaria;

public class ServicoPedido {


    public String pagar(Pedido pedido) {
        esperar(500);
        if (pedido.valor() > 150) {
            throw new PagamentoRecusadoException("Pedido "+ pedido.pedido()+" recusado, valor acima de R$150 recusado!");
        }
        return "Pagamento do pedido " + pedido.pedido() + " aprovado.";
    }

    public String preparar(Pedido pedido) {
        esperar(1000);
        return "Pizza de " + pedido.sabor();
    }

    public void entregar(Pedido pedido, String pizza) {
        esperar(500);
        System.out.println(
                "Pedido: " + pedido.pedido() + " entregue para " + pedido.cliente() + ": " +
                        pizza
        );
    }

    private void esperar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
