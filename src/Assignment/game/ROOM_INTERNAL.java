package Assignment.game;

/**
 * Created by Spartan 2 on 2017-06-02.
 */
public class ROOM_INTERNAL extends RoomParent {
    protected int[]  dirx =  {};//directionids

    public void setforks(int[] nextdirx){
        this.dirx = nextdirx;
    }
    //public int[] getforks(){
    //    return this.dirx;
    //}

    public int forksize(){
        return dirx.length;
    }

    public void printlnx(int[] xdatin){
        for (int i =0;i>xdatin.length;i++){
            System.out.println(xdatin[i]);
        }
    }
}
