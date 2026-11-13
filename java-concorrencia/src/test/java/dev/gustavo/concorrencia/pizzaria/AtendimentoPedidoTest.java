package dev.gustavo.concorrencia.pizzaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AtendimentoPedidoTest {

    @Mock
    private ServicoPedido servicoPedido;
    @Mock
    private Estoque estoque;
    @Mock
    private RelatorioPedidos relatorioPedidos;


    private AtendimentoPedido atendimentoPedido;
    private Pedido pedido;

    @BeforeEach
    void preparar(){
        atendimentoPedido = new AtendimentoPedido(servicoPedido, estoque, relatorioPedidos);
        pedido = new Pedido(1, "Ana", "Calabresa",80.0);
    }
    @Test
    void deveRegistrarRecusadoENaoReservarMassaQuandoPagamentoForRecusado(){
        //preparo
        when(servicoPedido.pagar(pedido))
                .thenThrow(new PagamentoRecusadoException("Recusado"));

        //agir
        atendimentoPedido.atender(pedido);

        //resultado
        verify(relatorioPedidos).registrarRecusado();
        verify(estoque, never()).reservarMassa();
        verify(relatorioPedidos, never()).registrarAceito();
    }
    @Test
    void deveAceitarPagamentoMasDeveRecusarPorFaltaDeMassa(){
        //preparo
        when(estoque.reservarMassa())
                .thenReturn(false);

        //agir
        atendimentoPedido.atender(pedido);

        //resultado
        verify(relatorioPedidos).registrarRecusado();
        verify(servicoPedido, never()).preparar(any());
        verify(relatorioPedidos, never()).registrarAceito();
    }
    @Test
    void deveEntregarAPizzaPreparadaERegistrarAceitoQuandoTudoDerCerto(){
        //preparar
        when(estoque.reservarMassa())
                .thenReturn(true);

        when(servicoPedido.preparar(pedido))
                .thenReturn("Pizza de Calabresa");

        //agir
        atendimentoPedido.atender(pedido);

        //resultado
        verify(servicoPedido).entregar(pedido, "Pizza de Calabresa");
        verify(relatorioPedidos).registrarAceito();
        verify(relatorioPedidos, never()).registrarRecusado();
    }
}
