package Assignment.game.roomclasses;

import Assignment.game.RoomParent;
import Assignment.game.item;
import Assignment.game.items.*;
import Assignment.game.player;

import java.util.Random;

/**
 * Created by 10740071 on 23/05/2017.
 */
public class ROOM_loot extends RoomParent {
    //
    //setup attributes

    //

    public ROOM_loot() {
        roombgm = "GotLoot.wav";
        rtype = "LOOT";
        this.lootin[0] = new gold_bag();
        this.lootin[1] = new gold_bag();
        rngroom();

    }



    //
}
