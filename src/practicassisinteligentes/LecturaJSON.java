
import java.io.*;

public class LecturaJSON {

    public static void main(String[] args) {
        
        Cubo cuboResuelto = new Cubo(3);
        Cubo cuboJSON = null;
        
        try {
        	FileReader f = new FileReader("10x10cube.json");
            cuboJSON = new Cubo(f);
        }catch(FileNotFoundException e){
        	System.out.println("Error, fichero no encontrado.");
        }
        
        if(cuboJSON != null)
        	System.out.println(cuboJSON.toString());
        System.out.println(cuboResuelto.toString());
       
        System.out.println("///////////////////TESTING////////////////////\n");
        System.out.println("Primer Cubo: " + cuboJSON.Get_MD5());
        cuboJSON.Move("l3");
        System.out.println("Aplicado movimiento l3: " + cuboJSON.Get_MD5());
        System.out.println(cuboJSON.toString());
        cuboJSON.Move("D1");
        System.out.println("Aplicado movimiento D1: " + cuboJSON.Get_MD5());
        System.out.println(cuboJSON.toString());
        cuboJSON.Move("l1");
        System.out.println("Aplicado movimiento l1: " + cuboJSON.Get_MD5());
        System.out.println(cuboJSON.toString());
        
        
        cuboJSON.Move("d0");
        System.out.println("Aplicado movimiento d0: " + cuboJSON.Get_MD5()); //Este es a partir del cual dan mal
        System.out.println(cuboJSON.toString());
        cuboJSON.Move("B0");
        System.out.println("Aplicado movimiento B0: " + cuboJSON.Get_MD5());
        System.out.println(cuboJSON.toString());
        cuboJSON.Move("b5");
        System.out.println("Aplicado movimiento b5: " + cuboJSON.Get_MD5());
        System.out.println(cuboJSON.toString());
        cuboJSON.Move("l2");
        System.out.println("Aplicado movimiento l2: " + cuboJSON.Get_MD5());
        System.out.println(cuboJSON.toString());
        cuboJSON.Move("d1");
        System.out.println("Aplicado movimiento d1: " + cuboJSON.Get_MD5());
        System.out.println(cuboJSON.toString());
        
        //System.out.println("El cubo del fichero JSON " + (cuboJSON.isSolved()?"si":"no") + " está resuelto.");
        //System.out.println("El cubo creado mediante el constructor que tiene un entero como parámetro " + (cuboResuelto.isSolved()?"si":"no") + " está resuelto.");


        //System.out.println(cuboJSON.Get_MD5());
        //System.out.println(cuboResuelto.Get_MD5());
        
        //cuboResuelto.Move("L0");
        //System.out.println(cuboResuelto.toString());
        //cuboResuelto.Move("l0");
        //System.out.println(cuboResuelto.toString());

    }
    
}
