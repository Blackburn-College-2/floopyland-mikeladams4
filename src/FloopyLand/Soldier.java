/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloopyLand;

import com.pauliankline.floopyconnector.GameBoard;
import java.awt.Point;

/**
 *
 * @author adams
 */
public class Soldier extends Heroes{
    
    public Soldier(GameBoard gameboard, Point location) {
        super(gameboard, location);
        super.name = "Soldier";
        super.type = "Soldier";
        super.color = "https://www.pikpng.com/pngl/b/526-5264691_medieval-helmet-png-465361-norman-helmet-png-clipart.png";
        super.inventorySize = 4;
    }
    
}
