import java.io.FileReader;
import java.util.ArrayList;

public class Estado {
	
	private Cubo c;
	
	
	public Estado(FileReader json) {
		
		setC(new Cubo(json));
		 
	}
	
	public Estado(Cubo c) {
		
		setC(c);
		
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
	
	public ArrayList<Sucesor> Sucesores(){
		int n = this.c.getBack().length;
		ArrayList<Sucesor> listaSucesores = new ArrayList<Sucesor>();
		
		for(int i = 0; i < n; i++) {
			//generar estado con movimiento B"n"
			Cubo c5 = this.c.clone();
			c5.Move("B"+i);
			Estado e5 = new Estado(c5);
			Sucesor sucesor5 = new Sucesor("B"+i, e5, 1);
			listaSucesores.add(sucesor5);
		}

		for(int i = 0; i < n; i++) {
			Cubo c6 = this.c.clone();
			c6.Move("b"+i);
			Estado e6 = new Estado(c6);
			Sucesor sucesor6 = new Sucesor("b"+i, e6, 1);
			listaSucesores.add(sucesor6);
		}
		
		for(int i = 0; i < n; i++) {	
			//generar estado con movimiento D"n"
			Cubo c3 = this.c.clone();
			c3.Move("D"+i);
			Estado e3 = new Estado(c3);
			Sucesor sucesor3 = new Sucesor("D"+i, e3, 1);
			listaSucesores.add(sucesor3);
		}
		
		for(int i = 0; i < n; i++) {	
			Cubo c4 = this.c.clone();
			c4.Move("d"+i);
			Estado e4 = new Estado(c4);
			Sucesor sucesor4 = new Sucesor("d"+i, e4, 1);
			listaSucesores.add(sucesor4);
		}
		
		for(int i = 0; i < n; i++) {
			//generar estado con movimiento L"n"
			Cubo c1 = this.c.clone();
			c1.Move("L"+i);
			Estado e1 = new Estado(c1);
			Sucesor sucesor1 = new Sucesor("L"+i, e1, 1);
			listaSucesores.add(sucesor1);
		}
		
		for(int i = 0; i < n; i++) {	
			Cubo c2 = this.c.clone();
			c2.Move("l"+i);
			Estado e2 = new Estado(c2);
			Sucesor sucesor2 = new Sucesor("l"+i, e2, 1);
			listaSucesores.add(sucesor2);
		}

		
		
		return listaSucesores;
	}
}
