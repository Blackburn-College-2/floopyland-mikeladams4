/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloopyLand;

import com.pauliankline.floopyconnector.Item;
import java.util.ArrayList;

/**
 *
 * @author adams
 */
public class Battle {

    Heroes one;
    Heroes two;
    Heroes holder;
    boolean turnTaken = false;

    public Battle(Heroes one, Heroes two) {
        this.one = one;
        this.two = two;
        one.setInBattle(true);
        one.setEnemy(two);
        one.setBattle(this);
        if (two == null) {
            one.setInBattle(false);
            one.setBattle(null);
        } else {
            two.setInBattle(true);
            two.setEnemy(one);
            two.setBattle(this);
        }
    }

    public void tick() {
        if (turnTaken == false) {
            int y = (int) (Math.random() * 2) + 1;
            int x = (int) (Math.random() * 5) + 1;
            if (one.type == "Thief") {
                if (x < 4) {
                    two.takeAttack(one, one.attack());
                    System.out.println("Attacked");
                } else if (x == 4) {
                    System.out.println("Tries to use a potion");
                    for (int i = 0; i < one.getInventory().size(); i++) {
                        if (one.getInventory().get(i) instanceof Potion) {
                            one.drinkPotion((Potion) one.getInventory().get(i));
                            System.out.println("Used potion");
                        }
                    }
                } else if (x == 5) {
                    if (y == 1) {
                        System.out.println("Thief Tries to steal a potion");
                        if (one.getInventory().size() < one.getInventorySize()) {
                            for (int i = 0; i < two.getInventory().size(); i++) {
                                if (two.getInventory().get(i) instanceof Potion) {
                                    ArrayList<Item> newOne = one.getInventory();
                                    ArrayList<Item> newTwo = two.getInventory();
                                    newOne.add(newTwo.get(i));
                                    newTwo.remove(newTwo.get(i));
                                    one.drinkPotion((Potion) newOne.get(i));
                                    one.setInventory(newOne);
                                    two.setInventory(newTwo);
                                    System.out.println("Thief has stolen and used a potion!");
                                }
                            }
                        }
                    }
                }
                if (two.isDead()) {
                    one.moveTo(two.getLocation());
                    one.setInBattle(false);
                    one.setBattle(null);
                    one.newKill();
                    two.setInBattle(false);
                    two.setBattle(null);
                }
                holder = one;
                one = two;
                two = holder;
                turnTaken = true;
            } else {
                if (x > 1) {
                    int h = two.takeAttack(one, one.attack());
                    if (one.type == "Healer") {
                        one.setHp(one.getHp() + (int) (h * .25));
                        if (one.getHp() > one.getMaxHp()) {
                            one.setHp(one.getMaxHp());
                        }
                        System.out.println("Healer healed for: " + (int) (h * .25));
                    }
                    System.out.println("Attacked");
                } else {
                    System.out.println("Tries to use a potion");
                    for (int i = 0; i < one.getInventory().size(); i++) {
                        if (one.getInventory().get(i) instanceof Potion) {
                            one.drinkPotion((Potion) one.getInventory().get(i));
                            System.out.println("Used potion");
                        }
                    }
                }
                if (two.isDead()) {
                    one.moveTo(two.getLocation());
                    one.setInBattle(false);
                    one.setBattle(null);
                    one.newKill();
                    two.setInBattle(false);
                    two.setBattle(null);
                }
                holder = one;
                one = two;
                two = holder;
                turnTaken = true;
            }
        } else {
            turnTaken = false;
        }
    }
}
