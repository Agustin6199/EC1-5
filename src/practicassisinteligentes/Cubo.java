
import practicassisinteligentes.Json;
import practicassisinteligentes.LecturaJSON;

public class Cubo implements Json {

    private String ID;
    private int[][] Back;
    private int[][] Down;
    private int[][] Front;
    private int[][] Left;
    private int[][] Right;
    private int[][] Up;

    public Cubo(String json) {
        Json.lecturaJson(json);
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
        this.Down = new int[down.length][down.length];
        System.arraycopy(down, 0, Down, 0, down.length);
    }

    public int[][] getFront() {
        return Front;
    }

    public void setFront(int[][] front) {
        this.Front = new int[front.length][front.length];
        System.arraycopy(front, 0, Front, 0, front.length);
    }

    public int[][] getLeft() {
        return Left;
    }

    public void setLeft(int[][] left) {
        this.Left = new int[left.length][left.length];
        System.arraycopy(left, 0, Left, 0, left.length);
    }

    public int[][] getRight() {
        return Right;
    }

    public void setRight(int[][] right) {
        this.Right = new int[right.length][right.length];
        System.arraycopy(right, 0, Right, 0, right.length);
    }

    public int[][] getUp() {
        return Up;
    }

    public void setUp(int[][] up) {
        this.Up = new int[up.length][up.length];
        System.arraycopy(up, 0, Up, 0, up.length);
    }

    public int[][] getBack() {
        return Back;
    }

    public void setBack(int[][] back) {
        this.Back = new int[back.length][back.length];
        System.arraycopy(back, 0, Back, 0, back.length);
    }

    public void Move(String movement) {

        if (movement.length() == 2) {
            String move_type = movement.substring(0);
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

}
