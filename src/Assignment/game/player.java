package Assignment.game;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class player extends entity {
    private int goldcarried;//gold carried by player
    private entity[] inventory;//items carried
    //private int atk

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
}
