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
public class PoisonPotion extends Potion{

    public PoisonPotion() {
        super("Vial of Poison");
        super.color = "purple";
    }

    @Override
    public void consume(Heroes x) {
        uses = uses - 1;
        x.setHp((x.getHp() - 30));
        if (uses <= 0) {
            empty = true;
        }
    }
    
}
