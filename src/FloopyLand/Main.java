/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloopyLand;

import com.pauliankline.floopyconnector.Floopy;
import com.pauliankline.floopyconnector.GameController;

/**
 *
 * @author paul.kline
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Floopy floop = new Floopy(new MyController());
        floop.begin(2);
    }
    
}
