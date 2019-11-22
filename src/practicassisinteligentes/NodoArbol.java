public class NodoArbol {
	
	//Información del nodo
	NodoArbol nodoPadre;
	static int id; 
	
	//Información del dominio
	Estado estado;
	int idNodo;
	int costeCamino;
	String accion;				//Accion desde el padre para alcanzar el estado actual
	int d; 						//Profundidad del nodo
	float f; 						//Valor que determina la posicion de insercion en la frontera
	

	public NodoArbol(NodoArbol np, Estado estado, int cc, String ac, int d, float f) {
		this.nodoPadre = np;
		this.estado = estado;
		this.costeCamino = cc;
		this.accion = ac;
		this.d = d;
		this.f = f;
		this.idNodo = id++;
	}

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        NodoArbol.id = id;
    }

    public int getIdNodo() {
        return idNodo;
    }

    public void setIdNodo(int idNodo) {
        this.idNodo = idNodo;
    }
        
        public static void reiniciarID(){
            id = 0;
        }

	public NodoArbol getNodoPadre() {
		return nodoPadre;
	}

	public void setNodoPadre(NodoArbol nodoPadre) {
		this.nodoPadre = nodoPadre;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}
	
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public float getF() {
		return f;
	}

	public void setF(float f) {
		this.f = f;
	}
	
}
