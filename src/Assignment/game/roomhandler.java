package Assignment.game;

/**
 * Created by 10740071 on 23/05/2017.
 */
public class roomhandler {
    //
    private int currentroom;
    private int lastroom;
    private int nextroom;


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


}
