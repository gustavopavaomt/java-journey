package dev.gustavo.concorrencia;

public class ServicoCompra {

    //etapa1: recebe o nome, devolve o comprovante de pagamento
    public String pagar(String cliente){
        esperar(1000);
        return "pagamento de " + cliente;
    }

    //etapa2: recebe o comprovante, devolve o ingresso
    public String emitirIngresso(String pagamento){
        esperar(500);
        return "Ingresso (" + pagamento + ")";
    }

    //etapa3: recebe o ingresso e envia. Não devolve nada.
    public void enviarEmail(String ingresso){
        System.out.println("Email enviado: " + ingresso);
    }
    //simula a demora, sem obrigar quem chama a tratar exceptions
    private void esperar(int milissegundos) {
       try {
           Thread.sleep(milissegundos);
       }catch (InterruptedException e){
           Thread.currentThread().interrupt();
       }
    }
}
