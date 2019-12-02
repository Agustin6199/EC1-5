
public class Sucesor {
	private int coste;
	private String accion;
	private Estado estado;

	public Sucesor(String accion, Estado estado, int coste) {
		this.accion = accion;
		this.estado = estado;
		this.coste = coste;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
