package Assignment.game;

/**
 * Created by Spartan 2 on 2017-06-02.
 */
//internal class
public class ROOM_INTERNAL extends RoomParent {
    protected int[]  dirx =  {};//directionids
    protected int shopid = -1;
    //

    //
    public ROOM_INTERNAL(){
        this.rtype = "FORK";

    }
    //
    public int getshopid(){
        return this.shopid;
    }
    public void setshopid(int ix){
        this.shopid = ix;
    }
    public void setforks(int[] nextdirx){
        this.dirx = nextdirx;
    }
    //public int[] getforks(){
    //    return this.dirx;
    //}

    public int forksize(){
        return dirx.length;
    }


    //print array of ints to console
    public void printlnx(int[] xdatin){
        for (int i =0;i>xdatin.length;i++){
            System.out.println(xdatin[i]);
        }
    }
}
