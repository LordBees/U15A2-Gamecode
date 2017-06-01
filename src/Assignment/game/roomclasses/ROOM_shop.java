package Assignment.game.roomclasses;

import Assignment.game.RoomParent;

/**
 * Created by 10740071 on 23/05/2017.
 */
public class ROOM_shop extends RoomParent {
    private int[]  dirx =  {};//directionids

    public ROOM_shop(){
        roombgm = "Shop.wav";
        rtype = "SHOP";

    }
    public void setforks(int[] nextdirx){
        this.dirx = nextdirx;
    }
    public int[] getforks(){
        return this.dirx;
    }

    public int forksize(){
        return dirx.length;
    }
}
