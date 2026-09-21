package dev.gustavo.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<T> buscarPorIndice(int indice){
          if(indice >=0 && indice < lista.size()){
              return Optional.of(lista.get(indice));
          }
          return Optional.empty();
    }
}
