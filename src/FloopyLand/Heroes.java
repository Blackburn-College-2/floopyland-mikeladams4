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
public class Heroes extends BaseHero {

    BaseHero enemy;
    boolean battle = false;

    public Heroes(GameBoard gameboard, Point location) {
        super(gameboard, location);
        super.inventorySize = 3;
        super.color = "green";
    }

    public void Check() {
        if (battle == false) {
            Point up = new Point(location.x, location.y - 1);
            Point down = new Point(location.x, location.y + 1);
            Point left = new Point(location.x - 1, location.y);
            Point right = new Point(location.x + 1, location.y);
            Point upLeft = new Point(location.x - 1, location.y - 1);
            Point downLeft = new Point(location.x - 1, location.y + 1);
            Point upRight = new Point(location.x + 1, location.y - 1);
            Point downRight = new Point(location.x + 1, location.y + 1);
            if (up.y == 10) {
                up.y = 9;
            }
            if (down.y == 10) {
                down.y = 9;
            }
            if (left.y == 10) {
                left.y = 9;
            }
            if (right.y == 10) {
                right.y = 9;
            }
            if (up.x == 10) {
                up.x = 9;
            }
            if (down.x == 10) {
                down.x = 9;
            }
            if (left.x == 10) {
                left.x = 9;
            }
            if (right.x == 10) {
                right.x = 9;
            }
            if (up.y == -1) {
                up.y = 0;
            }
            if (down.y == -1) {
                down.y = 0;
            }
            if (left.y == -1) {
                left.y = 0;
            }
            if (right.y == -1) {
                right.y = 0;
            }
            if (up.x == -1) {
                up.x = 0;
            }
            if (down.x == -1) {
                down.x = 0;
            }
            if (left.x == -1) {
                left.x = 0;
            }
            if (right.x == -1) {
                right.x = 0;
            }
            if (gameboard.getGameSquare(up).heroesArePresent() == true) {
                enemy = gameboard.getGameSquare(up).getHeroesPresent().get(0);
                battle = true;
            } else if (gameboard.getGameSquare(down).heroesArePresent() == true) {
                enemy = gameboard.getGameSquare(down).getHeroesPresent().get(0);
                battle = true;
            } else if (gameboard.getGameSquare(left).heroesArePresent() == true) {
                enemy = gameboard.getGameSquare(left).getHeroesPresent().get(0);
                battle = true;
            } else if (gameboard.getGameSquare(right).heroesArePresent() == true) {
                enemy = gameboard.getGameSquare(right).getHeroesPresent().get(0);
                battle = true;
            }else if (gameboard.getGameSquare(upLeft).heroesArePresent() == true) {
                enemy = gameboard.getGameSquare(upLeft).getHeroesPresent().get(0);
                battle = true;
            } else if (gameboard.getGameSquare(downLeft).heroesArePresent() == true) {
                enemy = gameboard.getGameSquare(downLeft).getHeroesPresent().get(0);
                battle = true;
            } else if (gameboard.getGameSquare(upRight).heroesArePresent() == true) {
                enemy = gameboard.getGameSquare(upRight).getHeroesPresent().get(0);
                battle = true;
            } else if (gameboard.getGameSquare(downRight).heroesArePresent() == true) {
                enemy = gameboard.getGameSquare(downRight).getHeroesPresent().get(0);
                battle = true;
            }
        }
    }

    public void Move() {
        gameboard.getGameSquare(location).removeHero(this);
        Point up = new Point(location.x, location.y - 1);
        Point down = new Point(location.x, location.y + 1);
        Point left = new Point(location.x - 1, location.y);
        Point right = new Point(location.x + 1, location.y);
        int x = (int) (Math.random() * 4) + 1;
        if (up.y == 10) {
            up.y = 9;
        }
        if (down.y == 10) {
            down.y = 9;
        }
        if (left.y == 10) {
            left.y = 9;
        }
        if (right.y == 10) {
            right.y = 9;
        }
        if (up.x == 10) {
            up.x = 9;
        }
        if (down.x == 10) {
            down.x = 9;
        }
        if (left.x == 10) {
            left.x = 9;
        }
        if (right.x == 10) {
            right.x = 9;
        }
        if (up.y == -1) {
            up.y = 0;
        }
        if (down.y == -1) {
            down.y = 0;
        }
        if (left.y == -1) {
            left.y = 0;
        }
        if (right.y == -1) {
            right.y = 0;
        }
        if (up.x == -1) {
            up.x = 0;
        }
        if (down.x == -1) {
            down.x = 0;
        }
        if (left.x == -1) {
            left.x = 0;
        }
        if (right.x == -1) {
            right.x = 0;
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

    public void Attack(Heroes enemy) {
        enemy.hp = enemy.hp - maxDamage;
    }

    @Override
    public boolean isInBattle() {
        return battle;
    }

    @Override
    public String enemy() {
        if (battle == true) {
            return enemy.name;
        } else {
            return "None";
        }
    }

    @Override
    public void gameTickAction(long l) {
        if (battle == false) {
            Move();
            Check();
        } else if (battle == true) {
            if (hp <= 0) {
                die();
            }
            Attack((Heroes) enemy);
            if (enemy.isDead()) {
                enemy = null;
                battle = false;
            }
        }
    }

    @Override
    protected void die() {
        battle = false;
        enemy = null;
        gameboard.getGameSquare(location).removeHero(this);
        System.out.println("Ran Die()");
    }

    @Override
    public boolean isDead() {
        if (hp > 0) {
            return false;
        } else {
            return true;
        }
    }

}
