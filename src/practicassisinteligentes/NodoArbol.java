
public class NodoArbol {
	
	//Información del nodo
	NodoArbol nodoPadre;
	
	//Información del dominio
	Estado e;
	int costeCamino;
	String accion;				//Accion desde el padre para alcanzar el estado actual
	int d; 						//Profundidad del nodo
	int f; 						//Valor que determina la posicion de insercion en la frontera
	
	public NodoArbol(NodoArbol np, Estado e, int cc, String ac, int d, int f) {
		this.nodoPadre = np;
		this.e = e;
		this.costeCamino = cc;
		this.accion = ac;
		this.d = d;
		this.f = f;
	}

	public NodoArbol getNodoPadre() {
		return nodoPadre;
	}

	public void setNodoPadre(NodoArbol nodoPadre) {
		this.nodoPadre = nodoPadre;
	}

	public Estado getE() {
		return e;
	}

	public void setE(Estado e) {
		this.e = e;
	}

	public int getCosteCamino() {
		return costeCamino;
	}

	public void setCosteCamino(int costeCamino) {
		this.costeCamino = costeCamino;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}
	
}
