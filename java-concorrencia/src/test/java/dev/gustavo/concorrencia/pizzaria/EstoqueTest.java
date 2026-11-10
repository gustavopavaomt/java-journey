package dev.gustavo.concorrencia.pizzaria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueTest {
    @Test
    void deveReservarMassaQuandoTemEstoque() {
        //Preparar
        Estoque estoque = new Estoque();

        //Agir
        boolean reservou = estoque.reservarMassa();

        //Verificar
        assertTrue(reservou);
        assertEquals(19, estoque.getMassasDisponiveis());
    }

    @Test
    void deveRecusarReservaQuandoMassaAcabar(){
        Estoque estoque = new Estoque();
        for(int i = 0; i < 20; i++){
            estoque.reservarMassa();
        }
        boolean reservou = estoque.reservarMassa();

        assertFalse(reservou);
        assertEquals(0, estoque.getMassasDisponiveis());
    }
}
