package dev.gustavo.concorrencia.pizzaria;

public class PagamentoRecusadoException extends RuntimeException {
    public PagamentoRecusadoException(String message) {
        super(message);
    }
}
