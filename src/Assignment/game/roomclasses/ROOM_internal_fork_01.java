package Assignment.game.roomclasses;

import Assignment.game.ROOM_INTERNAL;
import Assignment.game.RoomParent;


/**
 * Created by 10740071 on 23/05/2017.
 */
public class ROOM_internal_fork_01 extends ROOM_INTERNAL {//solves problem of how to get to load room
    public ROOM_internal_fork_01(){
        roombgm = "Shop.wav";
        rtype = "FORK";

        //set_roomforks(new int[]{4,5,-1});
        set_roomforks(new int[]{3,4,-1});

        //setshopid(0);
        setshopid(3);
        //dirx = new int[]{4,5,-1};
        System.out.print("AAA@@@");
        printlnx(dirx);




    }
}
