package dev.gustavo.concorrencia.pizzaria;

import java.util.concurrent.atomic.AtomicInteger;

public class RelatorioPedidos {

    private final AtomicInteger aceitos = new AtomicInteger(0);
    private final AtomicInteger recusados = new AtomicInteger(0);

    public void registrarAceito(){
        aceitos.incrementAndGet();
    }
    public void registrarRecusado(){
        recusados.incrementAndGet();
    }

    public int getAceitos() {
        return aceitos.get();
    }

    public int getRecusados() {
        return recusados.get();
    }

    public int getTotal(){
        int total = aceitos.get() + recusados.get();
        return total;
    }
}
