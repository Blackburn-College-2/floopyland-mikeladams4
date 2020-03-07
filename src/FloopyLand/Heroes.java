/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloopyLand;

import com.pauliankline.floopyconnector.BaseHero;
import com.pauliankline.floopyconnector.GameBoard;
import com.pauliankline.floopyconnector.Item;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author adams
 */
public class Heroes extends BaseHero {

    boolean inBattle;
    Battle battle;
    Heroes enemy;
    boolean dead;

    public Heroes(GameBoard gameboard, Point location) {
        super(gameboard, location);
        this.gameboard.getGameSquare(location).addHero(this);
        super.maxDamage = 100;
        super.inventorySize = 3;
    }

    public void newKill() {
        kills = kills + 1;
    }

    public void setEnemy(Heroes x) {
        enemy = x;
    }

    public void setInBattle(boolean x) {
        inBattle = x;
    }

    public void setBattle(Battle x) {
        battle = x;
    }

    public int attack() {
        System.out.println("attack");
        return maxDamage;
    }

    public int takeAttack(Heroes attacker, double damage) {
        System.out.println("take attack");
        boolean Tome = false;
        if (!inventory.isEmpty()) {
            for (int i = 0; i < inventory.size(); i++) {
                if ("Tome of Misdirection".equals(inventory.get(i).name)) {
                    Tome = true;
                }
            }
        }
        if (Tome == true) {
            hp = hp - (int) (damage * .9);
            attacker.hp = attacker.hp - (int) ((damage * .1) * .1);
            System.out.println("Tome damage");
        } else {
            hp = hp - (int) damage;
            System.out.println("Normal Damage");
        }
        if (hp <= 0) {
            die();
        }
        return (int) damage;
    }

    public void pickUpItems(ArrayList<Item> items) {
        int x = 0;
        if (inventorySize > inventory.size()) {
            if (items.size() > x) {
                this.inventory.add(items.get(x));
                x = x + 1;
            }
        }
    }


    public ArrayList<Heroes> checkAround() {
        int i = 0;
        ArrayList<Heroes> heroes = new ArrayList();
        Point up = new Point(location.x, location.y - 1);
        Point down = new Point(location.x, location.y + 1);
        Point left = new Point(location.x - 1, location.y);
        Point right = new Point(location.x + 1, location.y);
        Point upLeft = new Point(location.x - 1, location.y - 1);
        Point downLeft = new Point(location.x - 1, location.y + 1);
        Point upRight = new Point(location.x + 1, location.y - 1);
        Point downRight = new Point(location.x + 1, location.y + 1);
        heroes.add(check(up));
        System.out.println(this + " " + up.x + " " + up.y);
        heroes.add(check(down));
        heroes.add(check(left));
        heroes.add(check(right));
        heroes.add(check(upLeft));
        heroes.add(check(upRight));
        heroes.add(check(downLeft));
        heroes.add(check(downRight));
        while (i < heroes.size()) {
            if (heroes.get(i) == null) {
                heroes.remove(i);
            } else {
                i++;
            }
        }
        return heroes;
    }

    public Heroes check(Point point) {
        if (point.x == 10) {
            point.x = 0;
        }
        if (point.x == -1) {
            point.x = 9;
        }
        if (point.y == 10) {
            point.y = 0;
        }
        if (point.y == -1) {
            point.y = 9;
        }
        if (gameboard.getGameSquare(point).heroesArePresent()) {
            if ((Heroes) gameboard.getGameSquare(point).getHeroesPresent().get(0) == this) {
                return null;
            } else {
                return (Heroes) gameboard.getGameSquare(point).getHeroesPresent().get(0);
            }
        } else {
            return null;
        }
    }

    public void fight(ArrayList<Heroes> heroes) {
        battle = new Battle(this, checkAround().get(0));
    }

    public void move() {
        gameboard.getGameSquare(location).removeHero(this);
        Point up = new Point(location.x, location.y - 1);
        Point down = new Point(location.x, location.y + 1);
        Point left = new Point(location.x - 1, location.y);
        Point right = new Point(location.x + 1, location.y);
        int x = (int) (Math.random() * 4) + 1;
        if (up.y == 10) {
            up.y = 0;
        }
        if (down.y == 10) {
            down.y = 0;
        }
        if (left.y == 10) {
            left.y = 0;
        }
        if (right.y == 10) {
            right.y = 0;
        }
        if (up.x == 10) {
            up.x = 0;
        }
        if (down.x == 10) {
            down.x = 0;
        }
        if (left.x == 10) {
            left.x = 0;
        }
        if (right.x == 10) {
            right.x = 0;
        }
        if (up.y == -1) {
            up.y = 9;
        }
        if (down.y == -1) {
            down.y = 9;
        }
        if (left.y == -1) {
            left.y = 9;
        }
        if (right.y == -1) {
            right.y = 9;
        }
        if (up.x == -1) {
            up.x = 9;
        }
        if (down.x == -1) {
            down.x = 9;
        }
        if (left.x == -1) {
            left.x = 9;
        }
        if (right.x == -1) {
            right.x = 9;
        }
        if (x == 1) {
            gameboard.getGameSquare(up).addHero(this);
            location = up;
        } else if (x == 2) {
            gameboard.getGameSquare(down).addHero(this);
            location = down;
        } else if (x == 3) {
            gameboard.getGameSquare(left).addHero(this);
            location = left;
        } else if (x == 4) {
            gameboard.getGameSquare(right).addHero(this);
            location = right;

        }
    }

    @Override
    public boolean isInBattle() {
        return inBattle;
    }

    @Override
    public String enemy() {
        if (enemy == null) {
            return "None";
        } else {
            return enemy.name;
        }
    }

    @Override
    public void gameTickAction(long l) {
        if (dead == false) {
            if (inBattle == false) {
                if (checkAround().isEmpty() == false) {
                    fight(checkAround());
                }
                if (inBattle == false) {
                    move();
                    if (gameboard.getGameSquare(location).hasItems() == true) {
                        pickUpItems(gameboard.getGameSquare(location).getItems());
                    }
                }
                if (checkAround().isEmpty() == false) {
                    fight(checkAround());
                }
            } else {
                battle.tick();
                System.out.println("yes");
            }
        }
    }

    @Override
    protected void die() {
        gameboard.getGameSquare(location).getHeroesPresent().remove(this);
        dead = true;
    }

    @Override
    public boolean isDead() {
        return dead;
    }

}
