package Assignment.game;

/**
 * Created by Spartan 2 on 2017-05-19.
 */

//parent superclass for items
public class item {
    protected String I_name = "Generic Thing";//stores name of item
    protected int I_ShopCost = 0;//stores cost at shop
    protected int I_value = 0;//stores arbitrary value of item
    protected String I_Description = "Im an item!";//the item description printed by the engine
    protected String I_usesnd = "Iuse.wav";

    //
    //item(){
    //    this.I_name = "Generic Thing";
    //    this.I_ShopCost = 0;
    //    this.I_value = 0;
    //    this.I_Description = "Something of no real significance, this really should'nt be here..";
    //}
    public void giveitem(){
        System.out.println("did nothing!!!");

    }

    //item name
    public String getI_name() {
        return I_name;
    }

    public void setI_name(String i_name) {
        I_name = i_name;
    }

    //cost in shop
    public int getI_ShopCost() {
        return I_ShopCost;
    }

    public void setI_ShopCost(int i_ShopCost) {
        I_ShopCost = i_ShopCost;
    }

    //item value
    public int getI_value() {
        return I_value;
    }

    public void setI_value(int i_value) {
        I_value = i_value;
    }

    //item description
    public String getI_Description() {
        return I_Description;
    }

    public void setI_Description(String i_Description) {
        I_Description = i_Description;
    }
}
