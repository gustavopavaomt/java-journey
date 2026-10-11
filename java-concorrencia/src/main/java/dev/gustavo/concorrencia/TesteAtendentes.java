package dev.gustavo.concorrencia;

public class TesteAtendentes {

    public static void main(String[] args) throws InterruptedException {
        Runnable vender = () -> {
            String nome = Thread.currentThread().getName();
            for(int i = 1; i <=5; i++){
                System.out.println(nome + " vendeu o ingresso " + i);
            }
        };
        Thread atendente1 = new Thread(vender, "Atendente-1");
        Thread atendente2 = new Thread(vender, "Atendente-2");
        Thread atendente3 = new Thread(vender, "Atendente-3");

        atendente1.start();
        atendente2.start();
        atendente3.start();

        atendente1.join();
        atendente2.join();
        atendente3.join();
        System.out.println("Bilheteria fechada");
    }
}
