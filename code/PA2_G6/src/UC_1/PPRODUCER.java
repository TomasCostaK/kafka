/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_1;

import java.net.Socket;
import java.io.*;
import java.net.InetAddress;

/**
 *
 * @author tomascosta
 */
public class PPRODUCER extends Thread {
    
    private int producerId;
    private GUIPRODUCER guiProducer = new GUIPRODUCER();
    
    public PPRODUCER (int producerId, GUIPRODUCER guiProducer) {
        this.producerId = producerId;
        this.guiProducer = guiProducer;
    }
    
    @Override
    public void run() {    
        try {
            InetAddress ip = InetAddress.getByName("localhost");

            while (true) {
                
                Socket s = new Socket(ip, 7777);
                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                
                dos.writeUTF("ready");   // sinalize server(source) that producer is ready to accept data
                  
                String received = dis.readUTF();
                System.out.println("Producer " + this.producerId + " / Received from Source: " + received);
                guiProducer.updateTextArea("Producer " + this.producerId + " / Received from Source: " + received);
                
                dis.close();
                dos.close();
                s.close();
                
                if(received.equals("end")) {
                    break;
                } 
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
       
    }
    
}
