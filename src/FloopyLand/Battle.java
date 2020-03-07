/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FloopyLand;

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
            two.takeAttack(one, one.attack());
            if (two.isDead()) {
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
            turnTaken = false;
        }
    } 
}
