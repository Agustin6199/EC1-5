import java.io.FileReader;

public class Estado {
	
	private Cubo c;
	
	
	public Estado(FileReader json) {
		
		setC(new Cubo(json));
		 
	}
	
	public Cubo getC() {
		return c;
	}

	public void setC(Cubo c) {
		this.c = c;
	}
	
	public boolean EsObjetivo() {
		return getC().isSolved();
	}
	
}
