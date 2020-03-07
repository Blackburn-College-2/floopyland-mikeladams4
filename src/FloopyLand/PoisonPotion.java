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
        super.color = "https://vignette.wikia.nocookie.net/ageofmagicgame/images/4/48/Experience_Potion.png/revision/latest?cb=20170915103844";
    }

    @Override
    public void consume(Heroes x) {
        uses = uses - 1;
        x.setHp((x.getHp() - 30));
        if (uses <= 0) {
            empty = true;
        }
        if (x.getHp() <= 0){
            x.die();
        }
    }
    
}
