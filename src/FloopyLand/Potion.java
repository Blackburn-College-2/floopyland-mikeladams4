/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloopyLand;

/**
 *
 * @author adams
 */
public abstract class Potion extends Items {

    int uses = 4;
    boolean empty = false;
    
    public Potion(String name) {
        super(name);
    }
    
    public abstract void consume(Heroes x);
    
    public boolean isEmpty(){
        return empty;
    }
    
}
