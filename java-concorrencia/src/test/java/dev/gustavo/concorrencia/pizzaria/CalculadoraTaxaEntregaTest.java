package dev.gustavo.concorrencia.pizzaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculadoraTaxaEntregaTest {

    private CalculadoraTaxaEntrega calculadoraTaxaEntrega;

    @BeforeEach
    void preparar(){
        calculadoraTaxaEntrega = new CalculadoraTaxaEntrega();
    }
    @Test
    void deveSerGratisQuandoDistanciaForAte3km(){
        double taxa = calculadoraTaxaEntrega.calcular(2.0, 50.0);

        assertThat(taxa).isEqualTo(0.0);
    }

    @Test
    void deveCobrar2ReaisQuandoADistanciaForEntre3a10Km(){
        double taxa = calculadoraTaxaEntrega.calcular(5.0,50.0);

        assertThat(taxa).isEqualTo(10.0);
    }
    @Test
    void deveCobrar20EmDistanciaExataDe10Km(){
        double taxa = calculadoraTaxaEntrega.calcular(10.0, 50.0);

        assertThat(taxa).isEqualTo(20.0);
    }
    @Test
    void deveNaoEntregarParaPedidosAcimaDe10Km(){
        assertThatThrownBy(() -> calculadoraTaxaEntrega.calcular(12.0, 50.0))
                .isInstanceOf(EntregaForaDaAreaException.class);
    }

    @Test
    void entregaDeveSerGratisParaPedidosAcimaDe100Reais(){
        double taxa = calculadoraTaxaEntrega.calcular(5.0, 120.0);

        assertThat(taxa).isEqualTo(0.0);
    }
    @Test
    void entregaDevePagarNormalParaUmPedidoDeExatos100Reais(){
        double taxa = calculadoraTaxaEntrega.calcular(5.0, 100.0);

        assertThat(taxa).isEqualTo(10.0);
    }
    @Test
    void deveNaoEntregarParaUmPedidoAcimaDe100ParaDistanciaForaDoPadrao(){
        assertThatThrownBy(() -> calculadoraTaxaEntrega.calcular(12.0, 200.0))
                .isInstanceOf(EntregaForaDaAreaException.class);
    }
}
