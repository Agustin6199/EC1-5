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
	
	public ArrayList<Sucesor> sucesores(Estado e){
		int n = e.c.getBack().length;
		ArrayList<Sucesor> listaSucesores = new ArrayList<Sucesor>();
		
		for(int i = 0; i < n; i++) {
			//generar estado con movimiento L"n"
			Cubo c1 = e.c.clone();
			c1.Move("L"+n);
			Estado e1 = new Estado(c1);
			Sucesor sucesor1 = new Sucesor("L"+n,e1);
			listaSucesores.add(sucesor1);
			
			Cubo c2 = e.c.clone();
			c2.Move("l"+n);
			Estado e2 = new Estado(c2);
			Sucesor sucesor2 = new Sucesor("l"+n,e2);
			listaSucesores.add(sucesor2);

			//generar estado con movimiento D"n"
			Cubo c3 = e.c.clone();
			c3.Move("D"+n);
			Estado e3 = new Estado(c3);
			Sucesor sucesor3 = new Sucesor("D"+n,e3);
			listaSucesores.add(sucesor3);
			
			Cubo c4 = e.c.clone();
			c4.Move("d"+n);
			Estado e4 = new Estado(c4);
			Sucesor sucesor4 = new Sucesor("d"+n,e4);
			listaSucesores.add(sucesor4);

			//generar estado con movimiento B"n"
			Cubo c5 = e.c.clone();
			c5.Move("B"+n);
			Estado e5 = new Estado(c5);
			Sucesor sucesor5 = new Sucesor("B"+n,e5);
			listaSucesores.add(sucesor5);

			Cubo c6 = e.c.clone();
			c6.Move("b"+n);
			Estado e6 = new Estado(c6);
			Sucesor sucesor6 = new Sucesor("b"+n,e6);
			listaSucesores.add(sucesor6);

		}
		
		return listaSucesores;
	}
}
