package Assignment.game.roomclasses;

import Assignment.game.ROOM_INTERNAL;


/**
 * Created by 10740071 on 23/05/2017.
 */
public class ROOM_internal_fork_03 extends ROOM_INTERNAL {//solves problem of how to get to load room
    public ROOM_internal_fork_03(){
        roombgm = "Shop.wav";
        rtype = "FORK";
        //set_roomforks(new int[]{20,-1,-1});
        set_roomforks(new int[]{19,-1,-1});
        //setshopid(2);
        setshopid(19);
        //dirx = new int[]{4,5,-1};
        System.out.print("CCC@@@");
        printlnx(dirx);




    }
}
