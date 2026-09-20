package dev.gustavo.oop;

public class Corrida implements Cobravel {

    private Motorista motorista;
    private double distanciaKm;
    private StatusCorrida statusCorrida;
    private Endereco origem,destino;

    public Corrida(Motorista motorista, double distanciaKm, Endereco origem, Endereco destino) {
        if (distanciaKm <= 0) {
            throw new IllegalArgumentException("A distância precisa ser positiva.");
        }
        this.motorista = motorista;
        this.distanciaKm = distanciaKm;
        this.statusCorrida = StatusCorrida.SOLICITADA;
        this.origem = origem;
        this.destino = destino;
    }

    @Override
    public double calcularValor() {
        return 5.0 + 2.0 * distanciaKm;
    }

    public void iniciar() {
        if(statusCorrida != StatusCorrida.SOLICITADA){
            throw new IllegalStateException("A corrida precisa ter sido solicitada");
        }
        this.statusCorrida = StatusCorrida.EM_ANDAMENTO;
    }

    public void finalizar() {
        if(statusCorrida != StatusCorrida.EM_ANDAMENTO){
            throw new IllegalStateException("A corrida precisa estar em andamento");
        }
        this.statusCorrida = StatusCorrida.FINALIZADA;
    }

    public StatusCorrida getStatusCorrida() {
        return statusCorrida;
    }
}
