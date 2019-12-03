import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class Busqueda {

	public enum Estrategia{Anchura, Profundidad_Simple, Profundidad_Iterativa, Profundidad_Acotada, Coste_Uniforme, Voraz, Aasterisco}
	
	public static void main(String[] args){
		
		Problema Prob = null;
		
		
		try {
        	FileReader f = new FileReader("cube.json");
    		Prob = new Problema(f);
        }catch(FileNotFoundException e){
        	System.out.println("Error, fichero no encontrado.");
        }
		
		long ini = System.currentTimeMillis();
		boolean resultado = Busqueda_Acotada(Prob, Estrategia.Voraz, 6);
		float t = ((System.currentTimeMillis() - ini) / 1000f);
		
		if(resultado) System.out.println("La solución se ha encontrado en " + t + " segundos.");
		else System.out.println("No existe solución.");

	}
	
	
	private static boolean Busqueda_Acotada(Problema prob, Estrategia est, int prof_max) {
		
		NodoArbol n_actual = null;
		Frontera frontera = new Frontera();
		boolean sol = false;

		HashMap<String,String> nodosFrontera = new HashMap<String, String>();
        NodoArbol.reiniciarID();

		NodoArbol n_inicial = new NodoArbol(null, prob.getEstadoInicial(), 0, "None", 0, 0);
		frontera.Insertar(n_inicial);

		while(!sol && !frontera.estaVacia()) {
			n_actual = frontera.Eliminar(); //Seleccionamos nodo de la frontera.
				//System.out.println("id: "+n_actual.getIdNodo()+" md5 actual: "+n_actual+" md5 padre: "+n_actual.getNodoPadre()+ " movimiento: "+ n_actual.getAccion()+" profundidad: "+n_actual.getD()+ " f: "+n_actual.getF());
				//System.out.println(n_actual.getEstado().getC().toString());

			if(prob.isSolved(n_actual.getEstado())) {
				sol = true;	
			}else {
				if(n_actual.getD() < prof_max) {
				ArrayList<Sucesor> ls = n_actual.getEstado().Sucesores();
				ArrayList<NodoArbol> ln = CrearListaNodosArbol(ls, n_actual, prof_max, est, nodosFrontera);
				frontera.InsertarLista(ln);
					}
				}	
		}
		
		if(sol) {
			Stack<NodoArbol> pilaCamino = new Stack<NodoArbol>();
			
			do{
				pilaCamino.push(n_actual);
				n_actual = n_actual.getNodoPadre();
			}while(n_actual != null);
			
			System.out.println(StringEstrategia(est));
			System.out.println("=================");
			while(!pilaCamino.isEmpty()) {
				NodoArbol n = pilaCamino.pop();
				System.out.println("["+n.getIdNodo()+"](["+n.getAccion()+"]"+n.getEstado().getC().get_MD5()+",c="+n.getCosteCamino()+",p="+n.getD()+",f="+n.getF()+")");
			}
			System.out.println("");
			System.out.println("");

		}else {
			System.out.println("No existe solución.");
		}
		
		return sol;
	}

	public static boolean Busqueda_Iterativa(Problema prob, Estrategia est, int prof_max, int incremento) {
		int prof_actual = incremento;
		boolean sol = false;
		
		while(!sol && (prof_actual <= prof_max)) {
			sol = Busqueda_Acotada(prob, est, prof_max);
			prof_actual+=incremento;
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
			float f = ObtainF(est, coste, profundidad, s.getEstado().getC());
			
			NodoArbol n = new NodoArbol(n_actual, s.getEstado(), coste, s.getAccion(), profundidad, f);
			if(est == Estrategia.Profundidad_Simple || est == Estrategia.Profundidad_Acotada || est == Estrategia.Profundidad_Iterativa) {
				if(nodosFrontera.containsKey(s.getEstado().getC().get_MD5())){
					if(f > Float.valueOf(nodosFrontera.get(s.getEstado().getC().get_MD5()))){
						
						nodosFrontera.put(s.getEstado().getC().get_MD5(), Float.toString(f));
						lna.add(n);
						
					}
				}else{
					
					nodosFrontera.put(s.getEstado().getC().get_MD5(), Float.toString(f));
					lna.add(n);	
				}
			}else {
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
			
			
		}
		
		return lna;
		
	}
	
	private static float ObtainF(Estrategia e, int coste, int profundidad, Cubo cubo) {
		float f = 1;
		
		switch(e) {
		case Anchura:
			f = profundidad;
			break;
		case Profundidad_Simple:
			f = 1f/(1f + profundidad);
			break;
		case Profundidad_Acotada:
			f = 1f/(1f + profundidad);
			break;
		case Profundidad_Iterativa:
			f = 1f/(1f + profundidad);
			break;
		case Coste_Uniforme:
			f = coste;
			break;
		case Voraz:
			f = Heuristica(cubo);
			break;
		case Aasterisco:
			f = coste + Heuristica(cubo);
			break;
		}
		
		return f;
	}
	
	public static float Heuristica(Cubo c){

		float h = 0;
		
		h += CalcularEntropia(c.getBack());
		h += CalcularEntropia(c.getFront());
		h += CalcularEntropia(c.getRight());
		h += CalcularEntropia(c.getLeft());
		h += CalcularEntropia(c.getUp());
		h += CalcularEntropia(c.getDown());

		return h;

	}

	private static float CalcularEntropia(int[][] face){

		float entropia = 0;
		int N = face.length;
		int[] contador = new int[6];

		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				contador[face[i][j]] += 1;
				
		for(int c = 0; c < 6; c++)
			if(contador[c] > 0)
				entropia += ((float)contador[c])/(N*N) * (float)log(((float)contador[c])/(N*N), 6);
					
		return -entropia;
		
	}
	
	private static double log(float num, int base) {
		return (Math.log10(num) / Math.log10(base));
	}
	
	private static String StringEstrategia(Estrategia e) {
		
		String r = "";
		
		switch(e) {
		case Anchura:
			r = "Breadth (Anchura)";
			break;
		case Profundidad_Simple:
			r = "Depth (Profundidad Simple)";
			break;
		case Profundidad_Acotada:
			r = "Depth (Profundidad Acotada)";
			break;
		case Profundidad_Iterativa:
			r = "Depth (Profundidad Iterativa Acotada)";
			break;
		case Coste_Uniforme:
			r = "Uniforme (Costo Uniforme)";
			break;
		case Voraz:
			r = "Greedy (Voraz)";
			break;
		case Aasterisco:
			r = "A";
			break;
		}
		
		return r;
	}
}

