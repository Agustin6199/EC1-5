
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
			
			vToSave = Up[n - i][n - pos];
			Up[n - i][n - pos] = Back[i][pos];
			
			vToReplace = vToSave;
			vToSave = Front[i][pos];
			Front[i][pos] = vToReplace;
			
			vToReplace = vToSave;
			vToSave = Down[i][pos];
			Down[i][pos] = vToReplace;
			
			vToReplace = vToSave;
			Back[i][pos] = vToReplace;
			
		}
			
		
		if(pos == 0)
			Rotate_Face(Left, true);
		else if(pos == n)
			Rotate_Face(Right, true);
		
	}
	
	private void Move_D(int pos) {
		
		int n = Back.length - 1;
		int vToSave, vToReplace = 0;
		
		for(int i = 0; i < n + 1; i++) {
			
			vToSave = Right[n - i][pos];
			Right[n - i][pos] = Back[n - pos][n - i];
			
			vToReplace = vToSave;
			vToSave = Front[pos][i];
			Front[pos][i] = vToReplace;
			
			vToReplace = vToSave;
			vToSave = Left[i][n - pos];
			Left[i][n - pos] = vToReplace;
			
			vToReplace = vToSave;
			Back[n - pos][n - i] = vToReplace;
			
		}
			
		
		if(pos == 0)
			Rotate_Face(Down, true);
		else if(pos == n)
			Rotate_Face(Up, true);
		
	}
	
	private void Move_B(int pos) {

		int n = Back.length - 1;
		int vToSave, vToReplace = 0;
		
		for(int i = 0; i < n + 1; i++) {
			
			vToSave = Right[pos][i];
			Right[pos][i] = Down[pos][i];
			
			vToReplace = vToSave;
			vToSave = Up[pos][i];
			Up[pos][i] = vToReplace;
			
			vToReplace = vToSave;
			vToSave = Left[pos][i];
			Left[pos][i] = vToReplace;
			
			vToReplace = vToSave;
			Down[pos][i] = vToReplace;
			
		}
			
		
		if(pos == 0)
			Rotate_Face(Back, true);
		else if(pos == n)
			Rotate_Face(Front, true);
		
	}
	
	private void Move_l(int pos) {

		int n = Back.length - 1;
		int vToSave, vToReplace = 0;
		
		for(int i = 0; i < n + 1; i++) {
			
			vToSave = Up[n - i][n - pos];
			Up[n - i][n - pos] = Front[i][pos];
			
			vToReplace = vToSave;
			vToSave = Back[i][pos];
			Back[i][pos] = vToReplace;
			
			vToReplace = vToSave;
			vToSave = Down[i][pos];
			Down[i][pos] = vToReplace;
			
			vToReplace = vToSave;
			Front[i][pos] = vToReplace;

		}
			
		
		if(pos == 0)
			Rotate_Face(Left, false);
		else if(pos == n)
			Rotate_Face(Right, false);
		
	}
	
	private void Move_d(int pos) {

		int n = Back.length - 1;
		int vToSave, vToReplace = 0;
		
		for(int i = 0; i < n + 1; i++) {
			
			vToSave = Right[n - i][pos];
			Right[n - i][pos] = Front[pos][i];
			
			vToReplace = vToSave;
			vToSave = Back[n - pos][n - i];
			Back[n - pos][n - i] = vToReplace;
			
			vToReplace = vToSave;
			vToSave = Left[i][n - pos];
			Left[i][n - pos] = vToReplace;
			
			vToReplace = vToSave;
			Front[pos][i] = vToReplace;

		}
			
		
		if(pos == 0)
			Rotate_Face(Down, false);
		else if(pos == n)
			Rotate_Face(Up, false);
		
	}
	
	private void Move_b(int pos) {

		int n = Back.length - 1;
		int vToSave, vToReplace = 0;
		
		for(int i = 0; i < n + 1; i++) {
			
			vToSave = Right[pos][i];
			Right[pos][i] = Up[pos][i];
			
			vToReplace = vToSave;
			vToSave = Down[pos][i];
			Down[pos][i] = vToReplace;
			
			vToReplace = vToSave;
			vToSave = Left[pos][i];
			Left[pos][i] = vToReplace;
			
			vToReplace = vToSave;
			Up[pos][i] = vToReplace;

		}
			
		
		if(pos == 0)
			Rotate_Face(Back, false);
		else if(pos == n)
			Rotate_Face(Front, false);
		
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
