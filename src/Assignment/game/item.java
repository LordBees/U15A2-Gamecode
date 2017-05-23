package Assignment.game;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class item {
    protected String I_name;//stores name of item
    protected int I_ShopCost;//stores cost at shop
    protected int I_value;//stores arbitrary value of item
    protected String I_Description;//the item description printed by the engine

    //
    item(){
        this.I_name = "Generic Thing";
        this.I_ShopCost = 0;
        this.I_value = 0;
        this.I_Description = "Something of no real significance, this really should'nt be here..";
    }
    public void giveitem(){
        System.out.println("did nothing!!!");

    }
}
