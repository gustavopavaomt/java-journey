package dev.gustavo.oop;

import java.util.ArrayList;
import java.util.List;

public class Repositorio<T> {

    private List<T> lista = new ArrayList<>();


    public void salvar(T item){
        lista.add(item);
    }

    public List<T> listarTodos(){
        return List.copyOf(lista);
    }

    public int total(){
        return this.lista.size();
    }

}
