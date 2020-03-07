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
public class Thief extends Heroes {

    public Thief(GameBoard gameboard, Point location) {
        super(gameboard, location);
        super.name = "Thief";
        super.type = "Thief";
        super.color = "https://vignette.wikia.nocookie.net/roblox/images/6/6f/ThiefPNG.png/revision/latest?cb=20161127134752";
    }

}
