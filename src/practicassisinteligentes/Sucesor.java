
public class Sucesor {
	private int coste = 1;
	private String accion;
	private Estado cubo;

	public Sucesor(String accion, Estado cubo) {
		this.accion = accion;
		this.cubo = cubo;
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

	public Estado getCubo() {
		return cubo;
	}

	public void setCubo(Estado cubo) {
		this.cubo = cubo;
	}
}
