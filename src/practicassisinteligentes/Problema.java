import java.io.FileReader;

public class Problema {

	Estado estadoInicial;

	public Problema(FileReader json) {
		setEstadoInicial(new Estado(json));
	}
	
	public Estado getEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(Estado estadoInicial) {
		this.estadoInicial = estadoInicial;
	}
	
	public boolean isSolved(Estado e) {
		
    	boolean solved = true;
    	boolean[] colorSeen = new boolean[6];

    	for(int i = 0; i < 6; i++) colorSeen[i] = false;
		Cubo c = e.getC();
    	
    	solved = checkSolveFace(c.getBack(), solved, colorSeen);
    	solved = checkSolveFace(c.getDown(), solved, colorSeen);
    	solved = checkSolveFace(c.getFront(), solved, colorSeen);
    	solved = checkSolveFace(c.getLeft(), solved, colorSeen);
    	solved = checkSolveFace(c.getRight(), solved, colorSeen);
    	solved = checkSolveFace(c.getUp(), solved, colorSeen);
    	
    	return solved;
    }
    
    private boolean checkSolveFace(int[][] face, boolean solved, boolean[] colorSeen) {
    	
    	boolean ret = solved;
    	int faceNum = 0;
    	
    	for(int i = 0; i < face.length && ret; i++) 
    		for(int j = 0; j < face.length && ret; j++) 
    			
    			if(i == 0 && j == 0) 
    				if(colorSeen[face[i][j]])
    					ret = false;
    				else {
    					colorSeen[face[i][j]] = true;
    					faceNum = face[i][j];
    				}
    			else
    				if(face[i][j] != faceNum) ret = false;
    	
    	return ret;
    	
    }
	
}

