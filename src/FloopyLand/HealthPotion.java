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
public class HealthPotion extends Potion {

    public HealthPotion() {
        super("Potion of Health");
        super.color = "https://www.pngfind.com/pngs/m/293-2930388_62kib-864x1022-health-potion-transparent-potion-hd-png.png";
    }

    @Override
    public void consume(Heroes x) {
        uses = uses - 1;
        x.setHp((x.getHp() + 250));
        if (uses <= 0) {
            empty = true;
        }
        if (x.getHp() > x.getMaxHp()) {
            x.setHp(x.getMaxHp());
        }
    }

}
