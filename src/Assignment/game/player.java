package Assignment.game;

import Assignment.game.items.Ssword;
import Assignment.game.items.hvial;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class player extends entity {
    private int goldcarried = 10;//gold carried by player
    private item[] inventory = new item[10];//items carried
    //private int Inv_stat [] = {0,0,0};//atk def heal
    //private int atk

    public player() {
        //entity[] inventory = new inventory {};
        //this.inventory(new hvial());
        //populate
        this.inventory[0] = new hvial();
    }

    public void pickup_gold(int goldcollected){//add gold to the players inventory
        this.goldcarried = this.goldcarried + goldcollected;
    }
    public void spend_gold (int goldspent){//remove gold from the players inventory
        this.goldcarried = this.goldcarried - goldspent;
    }
    public boolean canafford(int itemcost){
        //if((goldcarried-itemcost) >0 )
        if (itemcost<=this.goldcarried){//if gold cost of item is less than or equal to gold carried
            return true;
        }
        else{
            return false;
        }
    }
    //public ;
    public void try_heal(){
        //if (this.Inv_stat[2] > 0){
        if (this.num_heals>0){
            //this.heal(10);//replace with do heal
            for(int i=0;i>this.inventory.length;i++){
                if(this.inventory[i].I_name.equals("vial")){
                    this.heal(inventory[i].I_value);
                    break;
                }
                else{
                    System.out.println("Unable to heal");
                }
            }
            //this.Inv_stat[2]--;
            this.num_heals -- ;
        }
    }
    public void addheal(int numh){//adds potions
        this.num_heals = this.num_heals+numh;
    }

    public void addto_atk(int additional){//adds to attack value
        this.atk = this.atk+additional;
    }
    public void addto_def(int additional){//adds to defence value
        this.def = this.def+additional;
    }
    public void addto_health(int additional){//adds to raw health vaue
        this.health = this.health+additional;
    }
    public void addto_atkmod(int additional){//adds to attackmod
        this.atk_m = this.atk_m+additional;
    }
    public void addsword(){
        if (this.inventory[1].I_name !="SuperSword")
            this.inventory[1] = new Ssword();
    }
    public String get_invbyslot(int slotno){
        return this.inventory[slotno].I_name;//returns name of item, in slot
    }
    public String hassword(){//was int
        //if (get_invbyslot(1).equals("SuperSword")){
        //@@@@@
        if (1 == 1){
            return "1";
        }
        else {
            return "0";
        }
    }
    public int getmoney(){
        return goldcarried;
    }
//    public void addto_numheals(){
//
    //}

}
