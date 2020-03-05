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
public class Tanker extends Heroes{
    
    public Tanker(GameBoard gameboard, Point location) {
        super(gameboard, location);
        super.maxHp = 1500;
        super.hp = maxHp;
        super.name = "Tanker";
        super.type = "Tanker";
    }
    
}
