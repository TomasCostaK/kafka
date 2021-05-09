/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UC_1;

/**
 *
 * @author tomascosta
 */
public class PCONSUMER extends Thread {

    private final int consumerId;
    private GUICONSUMER guiConsumer = new GUICONSUMER();

    public PCONSUMER(int consumerId, GUICONSUMER guiConsumer) {
        this.consumerId = consumerId;
        this.guiConsumer = guiConsumer;
    }
    
    @Override
    public void run() {
        
    }

    
}
