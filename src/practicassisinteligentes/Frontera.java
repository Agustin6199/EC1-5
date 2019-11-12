
import java.util.*;

public class Frontera {
    
    PriorityQueue<NodoArbol> frontera;

    public Frontera() {
        this.frontera = new PriorityQueue<NodoArbol>(new Comparator<NodoArbol>(){
            public int compare(NodoArbol a1, NodoArbol a2) {
                if((a1.getF() - a2.getF()) == 0){
                    return (0);
                }
                return ((int)a2.getF() - (int)a1.getF());
            }
        });
        
    }
    
    public void Insertar(NodoArbol n){
        frontera.add(n);
        //riorityQueue<NodoArbol> c = new PriorityQueue<NodoArbol>();
    }
    
    public NodoArbol Eliminar(){
        return frontera.poll();
    }
    
    public boolean estaVacia(){
        return frontera.isEmpty();
    }
}
