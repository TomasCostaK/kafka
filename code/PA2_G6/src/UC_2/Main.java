/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_2;

import UC_4.GUICONSUMER;
import UC_4.GUIPRODUCER;
import UC_4.PCONSUMER;
import UC_4.PPRODUCER;

/**
 *
 * @author alina
 */
public class Main {
    
    public static void main(String args[]) throws InterruptedException {
    
        final int NUMBER_PRODUCERS = 1;
        final int NUMBER_CONSUMERS = 5;
        
        final PPRODUCER[] producers = new PPRODUCER[NUMBER_PRODUCERS];
        final PCONSUMER[] consumers = new PCONSUMER[NUMBER_CONSUMERS];

        final GUIPRODUCER guiProducer = new GUIPRODUCER();
        final GUICONSUMER guiConsumer = new GUICONSUMER();

        for(int i = 0; i < NUMBER_PRODUCERS; i++){

                producers[i] = new PPRODUCER(i, guiProducer);
                producers[i].start();

        }
        
       
        for(int i = 0; i < NUMBER_CONSUMERS; i++){

                consumers[i] = new PCONSUMER(i, guiConsumer);
                consumers[i].start();
        }        
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                guiProducer.setVisible(true);
            }
        });

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                guiConsumer.setVisible(true);
            }
        });
        
        try {
            for ( int i = 0; i < NUMBER_PRODUCERS; i++ )
                producers[i].join();
            for ( int i = 0; i < NUMBER_CONSUMERS; i++ )
                consumers[i].join();
            
        } catch ( Exception ex ) {} 
    }
    
}
