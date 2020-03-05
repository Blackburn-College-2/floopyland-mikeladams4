/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloopyLand;

import com.pauliankline.floopyconnector.BaseHero;
import com.pauliankline.floopyconnector.GameBoard;
import com.pauliankline.floopyconnector.GameController;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author adams
 */
public class MyController extends GameController {

    @Override
    public ArrayList<BaseHero> createHeroes(GameBoard gb, int i) {
        ArrayList<BaseHero> heroes = new ArrayList<>();
        for (int t = 0; t < i; t++) {
            int x = (int) (Math.random() * 9) + 1;
            int y = (int) (Math.random() * 9) + 1;
            int z = (int) (Math.random() * 4) + 1;
            System.out.println(x + " " + y);
            Heroes p = null;
            if (z == 0) {
                p = new Healer(gb, new Point(x,y));
            } else if (z == 1) {
                p = new Tanker(gb, new Point(x,y));
            } else if (z == 2) {
                p = new Thief(gb, new Point(x,y));
            } else if (z == 3) {
                p = new Ninja(gb, new Point(x,y));
            } else if (z == 4) {
                p = new Soldier(gb, new Point(x,y));
            }
            heroes.add(p);
        }
        return heroes;
    }

    @Override
    public GameBoard mkGameBoard() {
        GameBoard board = new GameBoard();
        return board;
    }

}
