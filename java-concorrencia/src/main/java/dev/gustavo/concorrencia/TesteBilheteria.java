package dev.gustavo.concorrencia;

public class TesteBilheteria {
    public static void main(String[] args) throws InterruptedException {
        Bilheteria bilheteria = new Bilheteria();

        Runnable atender = () ->{
            for(int i =0; i <50; i++){
                bilheteria.vender();
            }
        };
        Thread atendente1 = new Thread(atender, "Atendente-1");
        Thread atendente2 = new Thread(atender, "Atendente-2");
        Thread atendente3 = new Thread(atender, "Atendente-3");

        atendente1.start();
        atendente2.start();
        atendente3.start();

        atendente1.join();
        atendente2.join();
        atendente3.join();

        System.out.println("Disponiveis: "+bilheteria.getIngressosDisponiveis());
        System.out.println("Vendidos: "+bilheteria.getIngressosVendidos());
    }
}
