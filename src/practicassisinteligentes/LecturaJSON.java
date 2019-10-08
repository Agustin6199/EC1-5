//package practicassisinteligentes;

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
        
        Cubo cuboJSON = new Cubo(json);
        
       // Cubo cuboResuelto = new Cubo(3);
        
        System.out.println(cuboJSON.toString());
        //System.out.println(cuboResuelto.toString());
       
        //System.out.println(cuboJSON.Get_MD5());
        //System.out.println(cuboResuelto.Get_MD5());
        
        //cuboResuelto.Move("D0");
        //System.out.println(cuboResuelto.toString());
        //cuboResuelto.Move("d0");
        //System.out.println(cuboResuelto.toString());

    }
    
}
