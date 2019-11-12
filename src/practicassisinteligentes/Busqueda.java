import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Busqueda {

	public enum Estrategia{Anchura, Profundidad_Simple, Profundidad_Iterativa, Profundidad_Acotada, Coste_Uniforme}
	
	public static void main(String[] args){
		
		Problema Prob = null;
		
		try {
        	FileReader f = new FileReader("10x10cube.json");
    		Prob = new Problema(f);
        }catch(FileNotFoundException e){
        	System.out.println("Error, fichero no encontrado.");
        }
		
		boolean resultado = Busqueda_Acotada(Prob, Estrategia.Anchura, 20);
	
	}
	
	
	private static boolean Busqueda_Acotada(Problema prob, Estrategia est, int prof_max) {
		
		NodoArbol n_actual = null;
		Frontera frontera = new Frontera();
		NodoArbol n_inicial = new NodoArbol(null, prob.getEstadoInicial(), 0, "Init", 0, 0);
		frontera.Insertar(n_inicial);
		boolean sol = false;

		while(!sol && !frontera.estaVacia()) {
			n_actual = frontera.Eliminar(); //Seleccionamos nodo de la frontera.
			
			if(prob.isSolved(n_actual.getEstado())) {
				sol = true;
			}else {
				ArrayList<Sucesor> ls = n_actual.getEstado().Sucesores();
				//ArrayList<NodoArbol> ln = CrearListaNodosArbol(ls, n_actual, prof_max, est);
				//frontera.InsertarLista(ln);
			}
			
		}
		
		return sol;
	}
	
}

