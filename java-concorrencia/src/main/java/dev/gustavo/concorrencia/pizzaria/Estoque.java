package dev.gustavo.concorrencia.pizzaria;


public class Estoque {

    private int massasDisponiveis = 20;

    public synchronized boolean reservarMassa(){
        if(massasDisponiveis >0){
            massasDisponiveis--;
            return true;
        }else {
            return false;
        }
    }
    public int getMassasDisponiveis(){
        return massasDisponiveis;
    }
}
