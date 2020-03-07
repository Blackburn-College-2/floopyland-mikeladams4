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
public class Veteran extends Heroes {

    public Veteran(GameBoard gameboard, Point location) {
        super(gameboard, location);
        super.name = "Veteran";
        super.type = "Veteran";
        super.color = "https://upload.wikimedia.org/wikipedia/commons/2/27/Army-USA-OR-05.svg";
    }

    @Override
    public int attack() {
        int x = (int) (Math.random() * 5) + 1;
        if (x == 5) {
            maxDamage = maxDamage + 30;
        }
        System.out.println(maxDamage);
        return maxDamage;
    }

}
