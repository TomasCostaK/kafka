
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tomascosta
 */
public class PSOURCE {
    // Here, declare filepath, java socket
    private static final String filePath = System.getProperty("user.dir") + "/src/Data/sensors.txt";

    public static void main(String args[]) {
        try {
        //the file to be opened for reading  
            FileInputStream fis = new FileInputStream(filePath);
            Scanner sc = new Scanner(fis);   
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
                System.out.println("Sending to Producer"); // Here send on the server conn to producer, usar server do trab1?
            }
            sc.close(); 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
