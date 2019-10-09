
import java.io.*;

public class LecturaJSON {

    public static void main(String[] args) {
        
        Cubo cuboResuelto = new Cubo(3);
        Cubo cuboJSON = null;
        
        try {
        	FileReader f = new FileReader("cube.json");
            cuboJSON = new Cubo(f);
        }catch(FileNotFoundException e){
        	System.out.println("Error, fichero no encontrado.");
        }
        
        if(cuboJSON != null)
        	System.out.println(cuboJSON.toString());
        System.out.println(cuboResuelto.toString());
       
        System.out.println("///////////////////////////////////////");
        
        Cubo cuboClonado = cuboResuelto.clone();
        cuboClonado.Move("L0");
        
        System.out.println(cuboResuelto.toString());
        System.out.println(cuboClonado.toString());

        //System.out.println(cuboJSON.Get_MD5());
        //System.out.println(cuboResuelto.Get_MD5());
        
        //cuboResuelto.Move("L0");
        //System.out.println(cuboResuelto.toString());
        //cuboResuelto.Move("l0");
        //System.out.println(cuboResuelto.toString());

    }
    
}
