import java.io.*;
import com.google.gson.*;
//package practicassisinteligentes;

//import practicassisinteligentes.Json;
//import practicassisinteligentes.LecturaJSON;

public class Cubo{

    private int[][] Back;
    private int[][] Down;
    private int[][] Front;
    private int[][] Left;
    private int[][] Right;
    private int[][] Up;

    public Cubo(String json) {
    	lecturaJson(json);
    }
    
    public Cubo(int n) {
    	generateSolvedCube(n);
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

        face = rotatedFace;

    }

    
    private void lecturaJson(String json1) {

        int i = -1, j = 0, n = 0;

        JsonParser parser = new JsonParser();
        JsonObject gsonObj = parser.parse(json1).getAsJsonObject();

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
            i++;
            j = 0;
            for (JsonElement backu : internoBack) {
                back[i][j] = backu.getAsInt();
                j++;
            }
        }

        //Recoger y rellenar la cara DOWN
        i = -1;
        j = 0;
        JsonArray Arrdown = gsonObj.get("DOWN").getAsJsonArray();
        for (JsonElement dowwn : Arrdown) {
            JsonArray internoDown = dowwn.getAsJsonArray();
            i++;
            j = 0;
            for (JsonElement downu : internoDown) {
                down[i][j] = downu.getAsInt();
                j++;
            }
        }

        //Recoger y rellenar la cara FRONT
        i = -1;
        j = 0;
        JsonArray Arrfront = gsonObj.get("FRONT").getAsJsonArray();
        for (JsonElement fronnt : Arrfront) {
            JsonArray internofront = fronnt.getAsJsonArray();
            i++;
            j = 0;
            for (JsonElement frontu : internofront) {
                front[i][j] = frontu.getAsInt();
                j++;
            }
        }

        //Recoger y rellenar la cara LEFT
        i = -1;
        j = 0;
        JsonArray Arrleft = gsonObj.get("LEFT").getAsJsonArray();
        for (JsonElement leftt : Arrleft) {
            JsonArray internoleft = leftt.getAsJsonArray();
            i++;
            j = 0;
            for (JsonElement leftu : internoleft) {
                left[i][j] = leftu.getAsInt();
                j++;
            }
        }

        //Recoger y rellenar la cara RIGHT
        i = -1;
        j = 0;
        JsonArray Arrright = gsonObj.get("RIGHT").getAsJsonArray();
        for (JsonElement righht : Arrright) {
            JsonArray internoright = righht.getAsJsonArray();
            i++;
            j = 0;
            for (JsonElement rightu : internoright) {
                right[i][j] = rightu.getAsInt();
                j++;
            }
        }

        //Recoger y rellenar la cara UP
        i = -1;
        j = 0;
        JsonArray Arrup = gsonObj.get("UP").getAsJsonArray();
        for (JsonElement upp : Arrup) {
            JsonArray internoup = upp.getAsJsonArray();
            i++;
            j = 0;
            for (JsonElement upu : internoup) {
                up[i][j] = upu.getAsInt();
                j++;
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
    			stringFace += face[i][j];
    			if(j + 1 < face.length) stringFace += ",";
    		}
    		stringFace += "]";
    		if(i + 1 < face.length) stringFace += " "; 
    	}
    	
    	stringFace += " ]";
    	
    	return stringFace;
	}
	
    public String Get_MD5() {
    	
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
}
