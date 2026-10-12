package dev.gustavo.concorrencia.pizzaria;

public class TesteEstoque {

    public static void main(String[] args) throws InterruptedException {
        Estoque estoque = new Estoque();
        RelatorioPedidos relatorioPedidos = new RelatorioPedidos();
        Runnable testeMassas = () -> {
            for (int i = 0; i < 10; i++) {
                boolean reservou = estoque.reservarMassa();
                if (!reservou) {
                    relatorioPedidos.registrarRecusado();
                } else {
                   relatorioPedidos.registrarAceito();
                }

                System.out.println(Thread.currentThread().getName() + " - " + reservou);
            }
        };
        Thread t1 = new Thread(testeMassas, "T1");
        Thread t2 = new Thread(testeMassas, "T2");
        Thread t3 = new Thread(testeMassas, "T3");

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("Aceitos: " + relatorioPedidos.getAceitos());
        System.out.println("Recusados: " + relatorioPedidos.getRecusados());
        System.out.println("Total: " + relatorioPedidos.getTotal());
        System.out.println("Estoque ao fim: " + estoque.getMassasDisponiveis());
    }
}
