
public class Cubo {

	private String ID;
	private int[][] Back;
	private int[][] Down;
	private int[][] Front;
	private int[][] Left;
	private int[][] Right;
	private int[][] Up;

	public Cubo(int[][] b, int[][] d, int[][] f, int[][] l, int[][] r, int[][] u) {
		setBack(b);
		setDown(d);
		setFront(f);
		setLeft(l);
		setRight(r);
		setUp(u);
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public int[][] getDown() {
		return Down;
	}

	public void setDown(int[][] down) {
		Down = down;
	}

	public int[][] getFront() {
		return Front;
	}

	public void setFront(int[][] front) {
		Front = front;
	}

	public int[][] getLeft() {
		return Left;
	}

	public void setLeft(int[][] left) {
		Left = left;
	}

	public int[][] getRight() {
		return Right;
	}

	public void setRight(int[][] right) {
		Right = right;
	}

	public int[][] getUp() {
		return Up;
	}

	public void setUp(int[][] up) {
		Up = up;
	}

	public int[][] getBack() {
		return Back;
	}

	public void setBack(int[][] back) {
		Back = back;
	}
	
	public void Move(String movement) {
		
		if(movement.length() == 2) {
			String move_type = movement.substring(0);
			int move_num = Integer.parseInt(movement.substring(1));
			boolean upper = Character.isUpperCase(move_type.charAt(0));
			
			switch(move_type.toUpperCase()) {
			
				case "L":
					if(upper) Move_L(move_num);
					else Move_l(move_num);
					break;
					
				case "D":
					if(upper) Move_D(move_num);
					else Move_d(move_num);
					break;
					
				case "B":
					if(upper) Move_B(move_num);
					else Move_b(move_num);
					break;
					
				default:
					break;
			}
		}
	}
	
	private void Move_L(int pos) {
		
		int n = Back.length - 1;
		int vToSave, vToReplace = 0;
		
		for(int i = 0; i < n + 1; i++) {
			
			vToSave = Up[n - pos][n - i];
			Up[n - pos][n - i] = Back[pos][i];
			
			vToReplace = vToSave;
			vToSave = Front[pos][i];
			Front[pos][i] = vToReplace;
			
			vToReplace = vToSave;
			vToSave = Down[pos][i];
			Down[pos][i] = vToReplace;
			
			vToReplace = vToSave;
			Back[pos][i] = vToReplace;
			
		}
			
		
		if(pos == 0)
			Rotate_Face(Left, true);
		else if(pos == n)
			Rotate_Face(Right, true);
		
	}
	
	private void Move_D(int pos) {
		
	}
	
	private void Move_B(int pos) {
		
	}
	
	private void Move_l(int pos) {
		
	}
	
	private void Move_d(int pos) {
		
	}
	
	private void Move_b(int pos) {
		
	}
	
	private void Rotate_Face(int[][] face, boolean clockwise) {
		
		int n = face.length;
		int[][] rotatedFace = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				
				if(clockwise) rotatedFace[(n - 1) - j ][i] = face[i][j];
				else rotatedFace[j][(n - 1) - i] = face[i][j];
			}
		}
		
		face = rotatedFace;
		
	}
	
}
