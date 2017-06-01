package Assignment.game.items;

import Assignment.game.item;
import Assignment.game.player;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class gold extends item {
    public gold(){
        this.I_name = "gold piece(super)";
        this.I_value = 1;
        this.I_ShopCost = 0;
        this.I_Description = "a single gold piece(super)";
    }

    //@Override
    public void giveitem(player target) {
        target.pickup_gold(this.I_value);
    }
}
