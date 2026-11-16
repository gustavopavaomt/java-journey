package dev.gustavo.concorrencia.pizzaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
