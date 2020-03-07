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
        super.maxHp = 1000;
        super.name = "Soldier";
        super.type = "Soldier";
        super.color = "red";
        super.inventorySize = 4;
    }
    
}
