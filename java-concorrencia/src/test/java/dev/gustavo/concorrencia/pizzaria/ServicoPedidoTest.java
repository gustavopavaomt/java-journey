package dev.gustavo.concorrencia.pizzaria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServicoPedidoTest {

    @Test
    void deveRecusarPagamentoQuandoValorAcimaDe150(){
        Pedido pedido = new Pedido(1,"Gustavo", "Calabresa", 200.0);
        ServicoPedido servicoPedido = new ServicoPedido();
        assertThrows(PagamentoRecusadoException.class, () -> servicoPedido.pagar(pedido));
    }
    @Test
    void deveAprovarPagamentoQuandoValorAte150(){
        Pedido pedido = new Pedido(1,"Gustavo", "Calabresa", 90.0);
        ServicoPedido servicoPedido = new ServicoPedido();
        assertEquals("Pagamento do pedido " + pedido.pedido() + " aprovado.", servicoPedido.pagar(pedido));

    }

    @Test
    void deveAprovarPagamentoQuandoValorForExato150(){
        Pedido pedido = new Pedido(1,"Gustavo", "Calabresa", 150.0);
        ServicoPedido servicoPedido = new ServicoPedido();
        assertEquals("Pagamento do pedido " + pedido.pedido() + " aprovado.", servicoPedido.pagar(pedido));

    }
}
