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
public class StrengthPotion extends Potion {

    int timer = 0;
    int originalDamage;

    public StrengthPotion() {
        super("Potion of Strength");
        super.color = "https://gamepedia.cursecdn.com/lolesports_gamepedia_en/f/f7/Hunter%27s_Potion.png?version=611d0e9fea5c5610f60f43be40c91370";
    }

    @Override
    public void consume(Heroes x) {
        uses = uses - 1;
        x.strength = this;
        if (x.strengthActive == false) {
            originalDamage = x.getMaxdamage();
            x.setMaxdamage((int) (x.getMaxdamage() * 1.1));
            timer = 21;
            x.strengthActive = true;
        } else {
            timer = 21;
        }
        if (uses <= 0) {
            empty = true;
        }
    }

    public void tick(Heroes x) {
        timer = timer - 1;
        if (timer == 0) {
            x.setMaxdamage(originalDamage);
            x.strengthActive = false;
        }
    }
}
