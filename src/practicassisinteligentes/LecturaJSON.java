package practicassisinteligentes;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class LecturaJSON {

    public static void main(String[] args) {

        String json = "{\n"
                + "\"BACK\":[[4,4,4],[3,3,3],[3,3,3]],"
                + "\"DOWN\":[[1,1,1],[2,4,4],[1,1,1]],"
                + "\"FRONT\":[[2,2,2],[2,2,2],[5,5,5]],"
                + "\"LEFT\":[[2,4,4],[0,0,0],[2,4,4]],"
                + "\"RIGHT\":[[5,5,3],[1,1,1],[5,5,3]],"
                + "\"UP\":[[0,0,0],[5,5,3],[0,0,0]]"
                + "}";
        
        Cubo cubo = new Cubo(json);
        
        cubo.MostrarCara(cubo.getBack());
    }

    public static void lectorJson(String json1) {

        int j = -1, i = 0, n = 0;

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
        
        
    }

    //Mostrar matriz que pasa por parámetro
    public static void MostrarCara(int[][] back) {

        for (int x = 0; x < back.length; x++) {
            System.out.println("");
            for (int y = 0; y < back[0].length; y++) {
                System.out.print(back[y][x]);
            }
        }
        System.out.println("");

    }
}
