package dev.gustavo.oop;

public class TesteExcecoes {

    public static void main(String[] args) {
        Motorista motorista = new Motorista("Gustavo","569044442","QCF4545");
        Endereco origem = new Endereco("Rua 1",20,"Tangará da serra");
        Endereco destino = new Endereco("Rua 20",11,"Tangará da serra");
        Corrida corrida = new Corrida(motorista,10.0, origem,destino);

        try {
            corrida.finalizar();
        }catch (CorridaNaoIniciadaException e){
            System.out.println(e.getMessage());
        }

        try {
            motorista.registrarCorrida(10.0);
        }catch (NotaInvalidaException e){
            System.out.println(e.getMessage());
        }
    }
}
