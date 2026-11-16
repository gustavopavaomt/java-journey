package dev.gustavo.concorrencia.pizzaria;

public class CalculadoraTaxaEntrega {

    public double calcular(double distanciaKm, double valorPedido){
        if(distanciaKm >3 && distanciaKm <=10){
            return distanciaKm *2;
        }
        return 0.0;
    }
}
