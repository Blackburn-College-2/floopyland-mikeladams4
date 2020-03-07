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
            int z = (int) (Math.random() * 6) + 1;
            if (z == 1) {
                heroes.add(new Healer(gb, new Point(x, y)));
            } else if (z == 2) {
                heroes.add(new Tanker(gb, new Point(x, y)));
            } else if (z == 3) {
                heroes.add(new Thief(gb, new Point(x, y)));
            } else if (z == 4) {
                heroes.add(new Ninja(gb, new Point(x, y)));
            } else if (z == 5) {
                heroes.add(new Soldier(gb, new Point(x, y)));
            } else if (z == 6) {
                heroes.add(new Veteran(gb, new Point(x, y)));
            }
        }
        return heroes;
    }

    @Override
    public GameBoard mkGameBoard() {
        GameBoard board = new GameBoard();
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new Tome());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new Tome());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new Tome());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new HealthPotion());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new StrengthPotion());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new HealthPotion());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new StrengthPotion());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new HealthPotion());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new StrengthPotion());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new HealthPotion());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new StrengthPotion());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new PoisonPotion());
        board.getGameSquare(new Point((int) (Math.random() * 9) + 1, (int) (Math.random() * 9) + 1)).addItem(new PoisonPotion());
        return board;
    }

}
