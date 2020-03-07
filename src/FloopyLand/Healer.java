/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloopyLand;

import com.pauliankline.floopyconnector.BaseHero;
import com.pauliankline.floopyconnector.GameBoard;
import java.awt.Point;

/**
 *
 * @author mikel.adams
 */
public class Healer extends Heroes{

    
    public Healer(GameBoard gameboard, Point location) {
        super(gameboard, location);
        super.maxHp = 1000;
        super.name = "Healer";
        super.type = "Healer";
        super.color = "green";
    }
}
