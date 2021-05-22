/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_2;


/**
 *
 * @author alina
 */
public class Main {
    
    public static void main(String args[]) throws InterruptedException {
    
        final int NUMBER_PRODUCERS = 1;
        final int NUMBER_CONSUMERS = 6;
        
        final PSOURCE source = new PSOURCE();
        final PPRODUCER[] producers = new PPRODUCER[NUMBER_PRODUCERS];
        final PCONSUMER[] consumers = new PCONSUMER[NUMBER_CONSUMERS];
        
        source.start();

        for(int i = 0; i < NUMBER_PRODUCERS; i++){
            
                producers[i] = new PPRODUCER(i);
                producers[i].start();

        }
        
       
        for(int i = 0; i < NUMBER_CONSUMERS; i++){
            
                consumers[i] = new PCONSUMER(i);
                consumers[i].start();

        }        
        
        
        try {
            for ( int i = 0; i < NUMBER_PRODUCERS; i++ )
                producers[i].join();
            for ( int i = 0; i < NUMBER_CONSUMERS; i++ )
                consumers[i].join();
            source.join();
            
        } catch ( Exception ex ) {} 
    }
    
}
