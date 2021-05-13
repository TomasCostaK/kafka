/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Message;

/**
 *
 * @author alina
 */
public class Message {

    private String id;
    private double temperature;
    private int timestamp;
    
    public Message() { }

    public Message(String id, double temperature, int timestamp) {
        this.id = id;
        this.temperature = temperature;
        this.timestamp = timestamp;
    }
    
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return this.id + " " + this.temperature + " " + this.timestamp; 
    }
}
