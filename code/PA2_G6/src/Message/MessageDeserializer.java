/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.kafka.common.serialization.Deserializer;

/**
 *
 * @author alina
 */

public class MessageDeserializer implements Deserializer<Message>{

    @Override
    public Message deserialize(String string, byte[] bytes) {
        String encoding = "UTF-8";
        
        Message m = new Message();
        if (bytes != null){
            try {
                ByteBuffer buf = ByteBuffer.wrap(bytes);
                m.setTemperature(buf.getDouble());
                int reg_size = buf.getInt();
                byte[] reg = new byte[reg_size];
                buf.get(reg);
                m.setId(new String(reg, encoding));
                m.setTimestamp(buf.getInt());
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MessageDeserializer.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        
        }
        return m;
    }
    
}
