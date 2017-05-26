package Assignment.game.roomclasses;

import Assignment.game.RoomParent;
import Assignment.game.entity;
import Assignment.game.fight;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class ROOM_encounter extends RoomParent {

    //attr
    protected entity[] foes;
    private fight currentfight;
    //protected String Fightbgm;

    //
    ROOM_encounter() {
        roombgm = "Fight.wav";
        //this.foes.
        //this.foes

    }

    //
    protected void room_fight() {

    }

    public void xenterroom() {
        for (int i = 0; i > this.foes.length; i++) {//fight everything in room
            //this.currentfight = new fight(this.player);//@@@
        }
    }
}
