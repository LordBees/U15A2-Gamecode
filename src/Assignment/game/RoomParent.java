package Assignment.game;

import Assignment.game.items.gold_bag;

import java.util.Random;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class RoomParent {
    //has array of execuatable objects that are passed to the  invoker
    //attributes
    protected entity[] foes;
    protected entity [] room_contents;
    protected String enterstring = "this is the parent";
    protected String roombgm = "Test.wav";
    protected String rtype = "blankx";
    //protected ;
    protected int roomid =0;
    protected int nextid =0;


    //loot stuff
    protected Random RNG = new Random();//rng
    int maxgold = 5;

    protected gold_bag[] lootin  = new gold_bag[2];

    //constructor
    /**
    RoomParent(){//int xroomid,int xnextid){
        //this.roomid=xroomid;
        //this.nextid=xnextid;
        this.roomid = 0;
        this.nextid = 0;

    }
     */

    //methods
    public void enterroom(){//called when player enters room
        System.out.println(this.enterstring);

    }
    public void winroom(){//called if victory condition met in room

    }
    //public void setup(int xid,int xnext){
    public void setup(int xid,int xnext_array){
        this.set_roomid(xid);
        //this.set_nextid(xnext);
        this.set_nextid(xnext_array);
    }

    public void set_roomid(int new_id){
        this.roomid = new_id;
    }
    public void set_nextid(int new_id){
        this.nextid = new_id;
    }
    public void setEnterstring(String enterstring) {
        this.enterstring = enterstring;
    }

    public int get_nextid(){
        return this.nextid;
    }
    public int get_roomid(){
        return this.roomid;
    }
    public String getEnterstring() {
        return enterstring;
    }


    ///loot room stuff
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

}
