package Assignment.game;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class player extends entity {
    private int goldcarried;//gold carried by player
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
    public void addheal(int numh){

    }
}
