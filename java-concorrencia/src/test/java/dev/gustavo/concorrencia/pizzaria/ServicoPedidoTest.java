package dev.gustavo.concorrencia.pizzaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
class ServicoPedidoTest {
    private ServicoPedido servicoPedido;

    @BeforeEach
    void preparar(){
        servicoPedido = new ServicoPedido();
    }
    @Test
    void deveRecusarPagamentoQuandoValorAcimaDe150(){
        Pedido pedido = new Pedido(1,"Gustavo", "Calabresa", 200.0);
        assertThatThrownBy(() -> servicoPedido.pagar(pedido))
                .isInstanceOf(PagamentoRecusadoException.class)
                .hasMessageContaining("$150 recusado!");
    }
    @Test
    void deveAprovarPagamentoQuandoValorAte150(){
        Pedido pedido = new Pedido(1,"Gustavo", "Calabresa", 90.0);
        assertThat(servicoPedido.pagar(pedido)).isEqualTo("Pagamento do pedido 1 aprovado.");
    }

    @Test
    void deveAprovarPagamentoQuandoValorForExato150(){
        Pedido pedido = new Pedido(1,"Gustavo", "Calabresa", 150.0);
        assertThat(servicoPedido.pagar(pedido)).isEqualTo("Pagamento do pedido 1 aprovado.");
    }
}
