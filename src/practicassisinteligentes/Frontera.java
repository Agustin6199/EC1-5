
import java.util.*;

public class Frontera {
    
    PriorityQueue<NodoArbol> frontera;

    public Frontera() {
        this.frontera = new PriorityQueue<NodoArbol>(new Comparator<NodoArbol>(){
            public int compare(NodoArbol a1, NodoArbol a2) {
            	if (a1.getF() < a2.getF()) {
                    return -1;  
            	}else if (a1.getF() > a2.getF()) {
                    return 1; 
            	}
            	return 0; 
                } 
        });
        
    }
    
    public void Insertar(NodoArbol n){
        frontera.add(n);
        //riorityQueue<NodoArbol> c = new PriorityQueue<NodoArbol>();
    }
    
    public void InsertarLista(ArrayList<NodoArbol> listaNodos) {
    	for(int i=0; i < listaNodos.size(); i++) {
    		frontera.add(listaNodos.get(i));
    	}
    }
    
    public NodoArbol Eliminar(){
        return frontera.poll();
    }
    
    public boolean estaVacia(){
        return frontera.isEmpty();
    }
}
