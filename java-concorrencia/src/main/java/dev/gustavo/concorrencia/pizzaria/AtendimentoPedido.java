package dev.gustavo.concorrencia.pizzaria;

public class AtendimentoPedido {

    private final ServicoPedido servicoPedido;
    private final Estoque estoque;
    private final RelatorioPedidos relatorioPedidos;


    public AtendimentoPedido(ServicoPedido servicoPedido, Estoque estoque, RelatorioPedidos relatorioPedidos) {
        this.servicoPedido = servicoPedido;
        this.estoque = estoque;
        this.relatorioPedidos = relatorioPedidos;
    }

    public void atender(Pedido pedido){
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
    }
}
