package dev.gustavo.concorrencia.pizzaria;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
