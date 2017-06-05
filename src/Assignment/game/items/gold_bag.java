package Assignment.game.items;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class gold_bag extends gold {
    public gold_bag(){
        this.I_name = "bag of gold";
        this.I_value = 1;
        this.I_ShopCost = 0;
        this.I_Description = "a bag containing gold worth ";//+toString(this.I_value);
    }
    public void changevalue(int new_I_value){//changed amount in bag
        this.I_value = new_I_value;
    }
}
