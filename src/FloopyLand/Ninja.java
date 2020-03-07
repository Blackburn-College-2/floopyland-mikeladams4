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
public class Ninja extends Heroes {

    public Ninja(GameBoard gameboard, Point location) {
        super(gameboard, location);
        super.name = "Ninja";
        super.type = "Ninja";
        super.color = "https://www.llumac.cat/iconpics/f/38/385716/ninja-mask-png.png";
    }

    @Override
    public int takeAttack(Heroes attacker, double damage) {
        boolean Tome = false;
        int x = (int) (Math.random() * 10) + 1;
        if (!inventory.isEmpty()) {
            for (int i = 0; i < inventory.size(); i++) {
                if ("Tome of Misdirection".equals(inventory.get(i).name)) {
                    Tome = true;
                }
            }
        }
        if (x == 1) {
            System.out.println("The ninja dodged some of the attack!");
            damage = (int) damage * .6;
            if (Tome == true) {
                hp = hp - (int) (damage * .9);
                attacker.setHp(attacker.getHp() - (int) ((damage * .1) * .1));
                damage = (int) (damage * .9);
            } else {
                hp = hp - (int) damage;
            }
            if (hp <= 0) {
                die();
            }
            System.out.println(damage);
            return (int) damage;
        } else {
            if (Tome == true) {
                hp = hp - (int) (damage * .9);
                attacker.setHp(attacker.getHp() - (int) ((damage * .1) * .1));
                damage = (int) (damage * .9);
            } else {
                hp = hp - (int) damage;
            }
            if (hp <= 0) {
                die();
            }
            System.out.println(damage);
            return (int) damage;
        }
    }
}
