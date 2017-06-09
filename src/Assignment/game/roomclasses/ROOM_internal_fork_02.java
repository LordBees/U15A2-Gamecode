package Assignment.game.roomclasses;

import Assignment.game.ROOM_INTERNAL;


/**
 * Created by 10740071 on 23/05/2017.
 */
public class ROOM_internal_fork_02 extends ROOM_INTERNAL {//solves problem of how to get to load room
    public ROOM_internal_fork_02(){
        roombgm = "Shop.wav";
        rtype = "FORK";
        //set_roomforks(new int[]{13,14,15});
        set_roomforks(new int[]{12,13,14});
        //setshopid(1);
        setshopid(12);
        //dirx = new int[]{4,5,-1};
        System.out.println("BBB@@@");
        printlnx(dirx);




    }
}
