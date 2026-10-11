package dev.gustavo.concorrencia;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestePagamentos {


    public static void main(String[] args) throws Exception {
        ProcessadorPagamento processadorPagamento = new ProcessadorPagamento();
        ExecutorService caixas = Executors.newFixedThreadPool(3);
        long inicio = System.currentTimeMillis();

        //Mandando 3 pagamentos pro pool sem esperar nenhum
        Future<Boolean> senhaAna = caixas.submit(() -> processadorPagamento.processar("Ana", 200.0));
        Future<Boolean> senhaBruno = caixas.submit(() -> processadorPagamento.processar("Bruno", 750));
        Future<Boolean> senhaJoao = caixas.submit(() -> processadorPagamento.processar("Joao", 480.0));

        // Só depois vai buscar os resultados
        System.out.println("Ana: "+ (senhaAna.get() ? "aprovado" : "recusado"));
        System.out.println("Bruno: "+ (senhaBruno.get() ? "aprovado" : "recusado"));
        System.out.println("Joao: "+ (senhaJoao.get() ? "aprovado" : "recusado"));

        long tempo = System.currentTimeMillis() - inicio;
        System.out.println("Tempo total: " + tempo +" ms");
        caixas.shutdown();
    }
}
