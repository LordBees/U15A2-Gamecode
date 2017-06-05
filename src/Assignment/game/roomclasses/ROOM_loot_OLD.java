package Assignment.game.roomclasses;

import Assignment.game.RoomParent;
import Assignment.game.items.gold_bag;
import Assignment.game.player;

import java.util.Random;

/**
 * Created by 10740071 on 23/05/2017.
 */
public class ROOM_loot_OLD extends RoomParent {
    //
    //setup attributes
    protected Random RNG = new Random();//rng
    int maxgold = 5;

    private gold_bag[] lootin  = new gold_bag[2];
    //

    public ROOM_loot_OLD() {
        roombgm = "GotLoot.wav";
        rtype = "LOOT";
        lootin[0] = new gold_bag();
        lootin[1] = new gold_bag();
        rngroom();

    }
    public void rngroom(){
        int nogold = RNG.nextInt(maxgold-1);//no of coins in room
        int lootbag = RNG.nextInt(100);
        int lootbagcontents = RNG.nextInt(50);

        if (lootbag>75){
            //lootin[0] = new gold_bag();
            lootin[0].setI_value(lootbagcontents);//need to remove method form lootbag

        }
        else{
            lootin[0].setI_value(0);
        }
        System.out.println("bag additonal bag contains:"+lootin[0].getI_value());
        /**
         * system for adding coins to roomloot(broken)
        System.out.println(nogold);
        for (int i=1;i>4;i++){
            System.out.println(i);
            lootin[i] = new gold_coin();

        }
         */
        //setting other loot
        //lootin[1] = new gold_bag();
        this.lootin[1].setI_value(nogold);//set gold bag as value of coins instead of multiple coins

        System.out.println("lootdump size-"+lootin.length);
        for (int i=0;i<lootin.length;i++) {
            System.out.print(">"+i);
            System.out.println(this.lootin[i].getI_value());
        }

    }
    public void givereward(player target){//gives loot reward to player
        //for (int i=0;i<lootin.length;i++) {

        //    System.out.print("you got :"++"gold");
        //    lootin[i].givegolditem(target);
        //}

        if (lootin[0].getI_value()!=0){
            System.out.print("BONUS LOOT! +gold:"+lootin[0].getI_value());
            lootin[0].givegolditem(target);
        }
        lootin[1].givegolditem(target);


    }

    //
}
