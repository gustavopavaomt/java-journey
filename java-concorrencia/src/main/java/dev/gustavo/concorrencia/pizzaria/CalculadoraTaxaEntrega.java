package dev.gustavo.concorrencia.pizzaria;

public class CalculadoraTaxaEntrega {

    public double calcular(double distanciaKm, double valorPedido){
        if(distanciaKm > 10){
            throw new EntregaForaDaAreaException("Não entregamos para distâncias acima de 10 km");

        }
        if(valorPedido > 100){
            return 0.0;
        }
        if(distanciaKm <=3 ){
            return 0.0;
        }
        return distanciaKm * 2;
    }
}
