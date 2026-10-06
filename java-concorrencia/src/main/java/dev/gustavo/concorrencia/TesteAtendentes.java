package dev.gustavo.concorrencia;

public class TesteAtendentes {

    public static void main(String[] args) throws InterruptedException {
        Runnable vender = () -> {
            String nome = Thread.currentThread().getName();
            for(int i = 0; i <=5; i++){
                System.out.println("Atendente-"+ nome + " vendeu o ingresso " + i);
            }
        };
        Thread atendente1 = new Thread(vender, "Atendente-1");
        Thread atendente2 = new Thread(vender, "Atendente-2");
        Thread atendente3 = new Thread(vender, "Atendente-3");

        atendente1.run();
        atendente2.run();
        atendente3.run();

        System.out.println("Bilheteria fechada");
    }
}
