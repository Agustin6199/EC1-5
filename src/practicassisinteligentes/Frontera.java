
import java.util.PriorityQueue;

public class Frontera {
    
    PriorityQueue<NodoArbol> arbolBusqueda;

    public Frontera() {
        this.arbolBusqueda = new PriorityQueue<NodoArbol>(new Comparator<NodoArbol>() {
            public int compare(NodoArbol a1, NodoArbol a2) {
                if((a1.getF() - a2.getF()) == 0){
                    return (a2.getE().getC().get_MD5() - a1.getE().getC().get_MD5());
                }
                return (a2.getF() - a1.getF());
            }
        });
    }
    
    public void instertar(NodoArbol n){
        arbolBusqueda.add(n);
    }
    
    public void eliminar(){
        arbolBusqueda.poll();
    }
    
    public void estaVacia(){
        arbolBusqueda.isEmpty();
    }
}
