
import java.util.*;

public class Frontera {
    
    PriorityQueue<NodoArbol> frontera;

    public Frontera() {
        this.frontera = new PriorityQueue<NodoArbol>(new Comparator<NodoArbol>(){
            public int compare(NodoArbol a1, NodoArbol a2) { //Ordena de menor a mayor seg�n el valor que tenga de F
            	if (a1.getF() < a2.getF()) {
                    return -1;  
            	}else if (a1.getF() > a2.getF()) {
                    return 1; 
            	}else { //En caso de que tengan la misma f se guiar� por el menor de los ID ya que este no podr� estar repetido
            		if(a1.getIdNodo() < a2.getIdNodo()) {
            			return -1;
            		}else  {
            			return 1;
            		}
            	}} 
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
