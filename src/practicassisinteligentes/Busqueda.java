import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Busqueda {

	public enum Estrategia{Anchura, Profundidad_Simple, Profundidad_Iterativa, Profundidad_Acotada, Coste_Uniforme}
	
	public static void main(String[] args){
		
		Problema Prob = null;
		
		
		try {
			Cubo c = new Cubo(3);
			c.Move("L0");
			Estado e = new Estado(c);
			Prob = new Problema(e);
        	FileReader f = new FileReader("cube.json");
    		//Prob = new Problema(f);
        }catch(FileNotFoundException e){
        	System.out.println("Error, fichero no encontrado.");
        }
		
		boolean resultado = Busqueda_Acotada(Prob, Estrategia.Anchura, 4);
	}
	
	
	private static boolean Busqueda_Acotada(Problema prob, Estrategia est, int prof_max) {
		
		NodoArbol n_actual = null;
		Frontera frontera = new Frontera();
		boolean sol = false;

		HashMap<String,String> nodosFrontera = new HashMap<String, String>();
                NodoArbol.reiniciarID();

		NodoArbol n_inicial = new NodoArbol(null, prob.getEstadoInicial(), 0, "Init", 0, 0);
		frontera.Insertar(n_inicial);


		while(!sol && !frontera.estaVacia()) {
			n_actual = frontera.Eliminar(); //Seleccionamos nodo de la frontera.
			System.out.println(n_actual.getD() +"   " +n_actual.getNodoPadre() + "   " + n_actual.getAccion());
			System.out.println(n_actual.getEstado().getC().toString());
			if(prob.isSolved(n_actual.getEstado())) {
				sol = true;
				System.out.print("Hay solucion");
			}else {
				ArrayList<Sucesor> ls = n_actual.getEstado().Sucesores();
				ArrayList<NodoArbol> ln = CrearListaNodosArbol(ls, n_actual, prof_max, est, nodosFrontera);
				frontera.InsertarLista(ln);
			}
			
		}
		
		return sol;
	}

	private static ArrayList<NodoArbol> CrearListaNodosArbol(ArrayList<Sucesor> ls, NodoArbol n_actual, int prof_max, Estrategia est, HashMap<String,String> nodosFrontera) {
		
		ArrayList<NodoArbol> lna = new ArrayList<NodoArbol>();
		
		Iterator<Sucesor> it = ls.iterator();
		while(it.hasNext()) {
			
			Sucesor s = it.next();
			
			int coste = n_actual.getCosteCamino() + s.getCoste();
			int profundidad = n_actual.getD() + 1;
			float f = ObtainF(est, coste, profundidad);
			
			NodoArbol n = new NodoArbol(n_actual, s.getEstado(), coste, s.getAccion(), profundidad, f);
			
			if(nodosFrontera.containsKey(s.getEstado().getC().get_MD5())){
				if(f < Float.valueOf(nodosFrontera.get(s.getEstado().getC().get_MD5()))){
					
					nodosFrontera.put(s.getEstado().getC().get_MD5(), Float.toString(f));
					lna.add(n);
					
				}
			}else{
				
				nodosFrontera.put(s.getEstado().getC().get_MD5(), Float.toString(f));
				lna.add(n);
				
			}

		}
		
		return lna;
		
	}
	
	private static float ObtainF(Estrategia e, int coste, int profundidad) {
		float f = 1;
		
		switch(e) {
		case Anchura:
			f = profundidad;
			break;
		case Profundidad_Simple:
			f = 1/(1 + profundidad);
			break;
		case Profundidad_Acotada:
			f = 1/(1 + profundidad);
			break;
		case Profundidad_Iterativa:
			f = 1/(1 + profundidad);
			break;
		case Coste_Uniforme:
			f = coste;
			break;
		}
		
		return f;
	}
	
}

