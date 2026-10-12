package dev.gustavo.concorrencia.pizzaria;


public class TestePedido {

    public static void main(String[] args) {
        ServicoPedido servicoPedido = new ServicoPedido();
        Pedido pedido = new Pedido(1,"Ana", "Calabresa", 90.0);
        Pedido pedido2 = new Pedido(2,"Joao", "Catupiri", 200.0);
        long inicio = System.currentTimeMillis();

        String pagamento = servicoPedido.pagar(pedido);
        String pizza = servicoPedido.preparar(pedido);
        servicoPedido.entregar(pedido, pizza);


        long tempo = System.currentTimeMillis() - inicio;
        System.out.println("Tempo: " +tempo +" ms");

        try{
            String pagamento2= servicoPedido.pagar(pedido2);
        }catch (PagamentoRecusadoException e){
            System.out.println(e.getMessage());
        }

    }


}
