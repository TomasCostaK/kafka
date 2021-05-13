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
import org.apache.kafka.common.serialization.Serializer;

/**
 *
 * @author alina
 */
public class MessageSerializer implements Serializer<Message>{

    @Override
    public byte[] serialize(String string, Message m) {
        String encoding = "UTF-8";
        int int_size = 4;
        int reg_size;
        byte[] serialized_reg;
        
        if(m != null){
            try {
                serialized_reg = m.getId().getBytes(encoding);
                reg_size = serialized_reg.length;
                
                ByteBuffer buf = ByteBuffer.allocate(8 + int_size + 
                            reg_size + int_size);
                    buf.putDouble(m.getTemperature());
                    buf.putInt(reg_size);
                    buf.put(serialized_reg);
                    buf.putInt(m.getTimestamp());
                    return buf.array();

            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(MessageSerializer.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
