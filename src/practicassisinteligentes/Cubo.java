import java.io.FileReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Cubo{

    private int[][] Back;
    private int[][] Down;
    private int[][] Front;
    private int[][] Left;
    private int[][] Right;
    private int[][] Up;

    public Cubo(FileReader jsonFile) {
    	lecturaJson(jsonFile);
    }
    
    public Cubo(int n) {
    	generateSolvedCube(n);
    }

    public Cubo clone() {
    	Cubo clone = new Cubo(this.Back.length);
    	
        System.arraycopy(this.Back, 0, clone.getBack(), 0, this.Back.length);
        System.arraycopy(this.Down, 0, clone.getDown(), 0, this.Back.length);
        System.arraycopy(this.Front, 0, clone.getFront(), 0, this.Back.length);
        System.arraycopy(this.Left, 0, clone.getLeft(), 0, this.Back.length);
        System.arraycopy(this.Right, 0, clone.getRight(), 0, this.Back.length);
        System.arraycopy(this.Up, 0, clone.getUp(), 0, this.Back.length);

    	return clone;
    }
    
    public int[][] getDown() {
        return this.Down;
    }

    public void setDown(int[][] down) {
        this.Down = new int[down.length][down.length];
        System.arraycopy(down, 0, this.Down, 0, down.length);
    }

    public int[][] getFront() {
        return this.Front;
    }

    public void setFront(int[][] front) {
        this.Front = new int[front.length][front.length];
        System.arraycopy(front, 0, this.Front, 0, front.length);
    }

    public int[][] getLeft() {
        return this.Left;
    }

    public void setLeft(int[][] left) {
        this.Left = new int[left.length][left.length];
        System.arraycopy(left, 0, this.Left, 0, left.length);
    }

    public int[][] getRight() {
        return this.Right;
    }

    public void setRight(int[][] right) {
        this.Right = new int[right.length][right.length];
        System.arraycopy(right, 0, this.Right, 0, right.length);
    }

    public int[][] getUp() {
        return this.Up;
    }

    public void setUp(int[][] up) {
        this.Up = new int[up.length][up.length];
        System.arraycopy(up, 0, this.Up, 0, up.length);
    }

    public int[][] getBack() {
        return this.Back;
    }

    public void setBack(int[][] back) {
        this.Back = new int[back.length][back.length];
        System.arraycopy(back, 0, this.Back, 0, back.length);
    }

    public void Move(String movement) {

        if (movement.length() == 2) {
            String move_type = movement.substring(0,1);
            int move_num = Integer.parseInt(movement.substring(1));
            boolean upper = Character.isUpperCase(move_type.charAt(0));
            
            switch (move_type.toUpperCase()) {

                case "L":
                    if (upper) {
                        Move_L(move_num);
                    } else {
                        Move_l(move_num);
                    }
                    break;

                case "D":
                    if (upper) {
                        Move_D(move_num);
                    } else {
                        Move_d(move_num);
                    }
                    break;

                case "B":
                    if (upper) {
                        Move_B(move_num);
                    } else {
                        Move_b(move_num);
                    }
                    break;

                default:
                    break;
            }
        }
    }

    private void Move_L(int pos) {

        int n = Back.length - 1;
        int vToSave, vToReplace = 0;

        for (int i = 0; i < n + 1; i++) {

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

        if (pos == 0) {
            Rotate_Face(Left, true);
        } else if (pos == n) {
            Rotate_Face(Right, true);
        }

    }

    private void Move_D(int pos) {

        int n = Back.length - 1;
        int vToSave, vToReplace = 0;

        for (int i = 0; i < n + 1; i++) {

            vToSave = Right[pos][n - i];
            Right[pos][n - i] = Back[n - i][n - pos];

            vToReplace = vToSave;
            vToSave = Front[i][pos];
            Front[i][pos] = vToReplace;

            vToReplace = vToSave;
            vToSave = Left[n - pos][i];
            Left[n - pos][i] = vToReplace;

            vToReplace = vToSave;
            Back[n - i][n - pos] = vToReplace;

        }

        if (pos == 0) {
            Rotate_Face(Down, true);
        } else if (pos == n) {
            Rotate_Face(Up, true);
        }

    }

    private void Move_B(int pos) {

        int n = Back.length - 1;
        int vToSave, vToReplace = 0;

        for (int i = 0; i < n + 1; i++) {

            vToSave = Right[i][pos];
            Right[i][pos] = Down[i][pos];

            vToReplace = vToSave;
            vToSave = Up[i][pos];
            Up[i][pos] = vToReplace;

            vToReplace = vToSave;
            vToSave = Left[i][pos];
            Left[i][pos] = vToReplace;

            vToReplace = vToSave;
            Down[i][pos] = vToReplace;

        }

        if (pos == 0) {
            Rotate_Face(Back, true);
        } else if (pos == n) {
            Rotate_Face(Front, true);
        }

    }

    private void Move_l(int pos) { 

        int n = Back.length - 1;
        int vToSave, vToReplace = 0;

        for (int i = 0; i < n + 1; i++) {

            vToSave = Up[n - pos][n - i];
            Up[n - pos][n - i] = Front[pos][i];

            vToReplace = vToSave;
            vToSave = Back[pos][i];
            Back[pos][i] = vToReplace;

            vToReplace = vToSave;
            vToSave = Down[pos][i];
            Down[pos][i] = vToReplace;

            vToReplace = vToSave;
            Front[pos][i] = vToReplace;

        }

        if (pos == 0) {
            Rotate_Face(Left, false);
        } else if (pos == n) {
            Rotate_Face(Right, false);
        }

    }
    
    private void Move_d(int pos) {

        int n = Back.length - 1;
        int vToSave, vToReplace = 0;

        for (int i = 0; i < n + 1; i++) {

            vToSave = Right[pos][n - i];
            Right[pos][n - i] = Front[i][pos];

            vToReplace = vToSave;
            vToSave = Back[n - i][n - pos];
            Back[n - i][n - pos] = vToReplace;

            vToReplace = vToSave;
            vToSave = Left[n- pos][i];
            Left[n - pos][i] = vToReplace;

            vToReplace = vToSave;
            Front[i][pos] = vToReplace;

        }

        if (pos == 0) {
            Rotate_Face(Down, false);
        } else if (pos == n) {
            Rotate_Face(Up, false);
        }

    }

    private void Move_b(int pos) {

        int n = Back.length - 1;
        int vToSave, vToReplace = 0;

        for (int i = 0; i < n + 1; i++) {

            vToSave = Right[i][pos];
            Right[i][pos] = Up[i][pos];

            vToReplace = vToSave;
            vToSave = Down[i][pos];
            Down[i][pos] = vToReplace;

            vToReplace = vToSave;
            vToSave = Left[i][pos];
            Left[i][pos] = vToReplace;

            vToReplace = vToSave;
            Up[i][pos] = vToReplace;

        }

        if (pos == 0) {
            Rotate_Face(Back, false);
        } else if (pos == n) {
            Rotate_Face(Front, false);
        }

    }

    private void Rotate_Face(int[][] face, boolean clockwise) {

        int n = face.length;
        int[][] rotatedFace = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (clockwise) {
                    rotatedFace[(n - 1) - j][i] = face[i][j];
                } else {
                    rotatedFace[j][(n - 1) - i] = face[i][j];
                }
            }
        }
        
        System.arraycopy(rotatedFace, 0, face, 0, n);
 
    }

    
    private void lecturaJson(FileReader jsonFile) {

        int j = -1, i = 0, n = 0;

        JsonParser parser = new JsonParser();
        JsonObject gsonObj = parser.parse(jsonFile).getAsJsonObject();

        JsonArray Arrback = gsonObj.get("BACK").getAsJsonArray();

        for (JsonElement contador : Arrback) {
            n++;
        }

        int[][] back = new int[n][n];
        int[][] down = new int[n][n];
        int[][] front = new int[n][n];
        int[][] left = new int[n][n];
        int[][] right = new int[n][n];
        int[][] up = new int[n][n];

        //Recoger y rellenar la cara BACK
        for (JsonElement bacck : Arrback) {
            JsonArray internoBack = bacck.getAsJsonArray();
            j++;
            i = 0;
            for (JsonElement backu : internoBack) {
                back[i][j] = backu.getAsInt();
                i++;
            }
        }

        //Recoger y rellenar la cara DOWN
        i = 0;
        j = -1;
        JsonArray Arrdown = gsonObj.get("DOWN").getAsJsonArray();
        for (JsonElement dowwn : Arrdown) {
            JsonArray internoDown = dowwn.getAsJsonArray();
            j++;
            i = 0;
            for (JsonElement downu : internoDown) {
                down[i][j] = downu.getAsInt();
                i++;
            }
        }

        //Recoger y rellenar la cara FRONT
        i = 0;
        j = -1;
        JsonArray Arrfront = gsonObj.get("FRONT").getAsJsonArray();
        for (JsonElement fronnt : Arrfront) {
            JsonArray internofront = fronnt.getAsJsonArray();
            j++;
            i = 0;
            for (JsonElement frontu : internofront) {
                front[i][j] = frontu.getAsInt();
                i++;
            }
        }

        //Recoger y rellenar la cara LEFT
        i = 0;
        j = -1;
        JsonArray Arrleft = gsonObj.get("LEFT").getAsJsonArray();
        for (JsonElement leftt : Arrleft) {
            JsonArray internoleft = leftt.getAsJsonArray();
            j++;
            i = 0;
            for (JsonElement leftu : internoleft) {
                left[i][j] = leftu.getAsInt();
                i++;
            }
        }

        //Recoger y rellenar la cara RIGHT
        i = 0;
        j = -1;
        JsonArray Arrright = gsonObj.get("RIGHT").getAsJsonArray();
        for (JsonElement righht : Arrright) {
            JsonArray internoright = righht.getAsJsonArray();
            j++;
            i = 0;
            for (JsonElement rightu : internoright) {
                right[i][j] = rightu.getAsInt();
                i++;
            }
        }

        //Recoger y rellenar la cara UP
        i = 0;
        j = -1;
        JsonArray Arrup = gsonObj.get("UP").getAsJsonArray();
        for (JsonElement upp : Arrup) {
            JsonArray internoup = upp.getAsJsonArray();
            j++;
            i = 0;
            for (JsonElement upu : internoup) {
                up[i][j] = upu.getAsInt();
                i++;
            }
        }
        
        setBack(back);
        setDown(down);
        setFront(front);
        setLeft(left);
        setRight(right);
        setUp(up);

    }

    private void generateSolvedCube(int n) {
    	
    	this.Back = new int[n][n];
    	this.Front = new int[n][n];
    	this.Up = new int[n][n];
    	this.Down = new int[n][n];
    	this.Right = new int[n][n];
    	this.Left = new int[n][n];

    	setFace(this.Up, 0);
    	setFace(this.Down, 1);
    	setFace(this.Front, 2);
    	setFace(this.Back, 3);
    	setFace(this.Left, 4);
    	setFace(this.Right, 5);

    }
    
    private void setFace(int[][] face, int num) {
    	
    	for(int i = 0; i < face.length;i++) 
    		for(int j = 0; j < face.length; j++) 
    			face[i][j] = num;
    	
    }
    
	@Override
	public String toString() {
		return "Cubo [\n\tBack=" + faceToString(Back) + ",\n\tDown=" + faceToString(Down) + ",\n\tFront="
				+ faceToString(Front) + ",\n\tLeft=" + faceToString(Left) + ",\n\tRight=" + faceToString(Right)
				+ ",\n\tUp=" + faceToString(Up) + "\n]\n";
	}
	
	private String faceToString(int[][] face) {
		
		String stringFace = "\t[ ";
		
    	for(int i = 0; i < face.length;i++) {
    		stringFace += "[";
    		for(int j = 0; j < face.length; j++) {
    			if(j != 0) stringFace += " ";
    			stringFace += face[j][i];
    			if(j + 1 < face.length) stringFace += ",";
    		}
    		stringFace += "]";
    		if(i + 1 < face.length) stringFace += " "; 
    	}
    	
    	stringFace += " ]";
    	
    	return stringFace;
	}
	
    public String get_MD5() {
    	
    	String toConvert = "";
    		
    	for(int i = 0; i < this.Back.length; i++)
    		for(int j = 0; j < this.Back.length; j++)
   				toConvert += this.Back[j][i];
    	for(int i = 0; i < this.Down.length; i++)
    		for(int j = 0; j < this.Down.length; j++)
   				toConvert += this.Down[j][i];
    	for(int i = 0; i < this.Front.length; i++)
    		for(int j = 0; j < this.Front.length; j++)
   				toConvert += this.Front[j][i];
    	for(int i = 0; i < this.Left.length; i++)
    		for(int j = 0; j < this.Left.length; j++)
   				toConvert += this.Left[j][i];
    	for(int i = 0; i < this.Right.length; i++)
    		for(int j = 0; j < this.Right.length; j++)
   				toConvert += this.Right[j][i];
    	for(int i = 0; i < this.Up.length; i++)
    		for(int j = 0; j < this.Up.length; j++)
   				toConvert += this.Up[j][i];

       	return convertToMD5(toConvert);
    	
    }
    
    private String convertToMD5(String toConvert) {
    	
    	StringBuffer sb = new StringBuffer();
    	
    	try {
    		
    		java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
    		byte[] array = md.digest(toConvert.getBytes("UTF-8"));
    		
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
    		
    		
    	}catch(java.security.NoSuchAlgorithmException e) {
    		System.out.println("Error. Algoritmo no soportado.");
    	}catch(UnsupportedEncodingException e) {
    		System.out.println("Error. Codificación no soportada.");
    	}
    	
    	return sb.toString();
    }
    
    public boolean isSolved() {
    	boolean solved = true;
    	boolean[] colorSeen = new boolean[6];
    	for(int i = 0; i < 6; i++) colorSeen[i] = false;
    	
    	solved = checkSolveFace(this.Back, solved, colorSeen);
    	solved = checkSolveFace(this.Down, solved, colorSeen);
    	solved = checkSolveFace(this.Front, solved, colorSeen);
    	solved = checkSolveFace(this.Left, solved, colorSeen);
    	solved = checkSolveFace(this.Right, solved, colorSeen);
    	solved = checkSolveFace(this.Up, solved, colorSeen);
    	
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
