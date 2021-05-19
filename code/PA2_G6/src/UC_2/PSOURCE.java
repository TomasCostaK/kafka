package UC_2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
/**
 *
 * @author tomascosta
 */
public class PSOURCE extends Thread {

    private static final String filePath = System.getProperty("user.dir") + "/src/Data/sensor.txt";
    
    @Override
    public void run() {
        try {
 
            FileInputStream fis = new FileInputStream(filePath);
            Scanner sc = new Scanner(fis); 
            
            ServerSocket ss = new ServerSocket(7777);
          
            while (true) {
                
                Socket s = null;

                try {
                   
                    s = ss.accept();     // socket object to receive incoming client(producers) requests

                    DataInputStream dis = new DataInputStream(s.getInputStream());
                    DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                    
                    while (true) {
                        String received = dis.readUTF();
                        if(received.equals("ready")) { 
                            if(sc.hasNextLine()) {     // if there are more lines in file, send to a producer
                                dos.writeUTF(sc.nextLine());
                                break;
                            }
                            else  {
                                dos.writeUTF("end");      // if there are no more line, send a finish message to close connection
                                s.close();
                                break;
                            }
                        }
                    }
                }
                catch (Exception e){
                    try {
                        s.close();
                    } catch (IOException ex) {
                       e.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
       
}
