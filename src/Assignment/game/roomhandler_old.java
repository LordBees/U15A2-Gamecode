package Assignment.game;

/**
 * Created by 10740071 on 23/05/2017.
 */
public class roomhandler_old {
    //
    RoomParent loadedroom;

    private int currentroom;
    private int lastroom;
    private int nextroom;



    private int[] forks;


    //

    //
    public int getCurrentroom() {
        return currentroom;
    }

    public void setCurrentroom(int currentroom) {
        this.lastroom = this.currentroom;
        this.currentroom = currentroom;
    }

    public int getLastroom() {
        return lastroom;
    }


    public int getNextroom() {
        return nextroom;
    }

    public void setNextroom(int nextroom) {
        this.nextroom = nextroom;
    }

    public int[] getForks() {
        return forks;
    }

    public void setForks(int[] forks) {
        this.forks = forks;
    }
    public int nforks() {
        return this.forks.length;
    }

    public void loadroom(RoomParent nextroom){

    }

    public void loadzroom(RoomParent newroom){}
}
