package Assignment.game;

/**
 * Created by 10740071 on 23/05/2017.
 */
public class roomhandler {
    //
    private RoomParent loadedroom;

    private int currentroom;
    private int lastroom;
    private int nextroom;



    private int[] forks;


    //

    //

    public void LoadRoom(RoomParent new_room){
        this.loadedroom = new_room;
        checkloadforks();
    }
    public void checkloadforks(){
        if (this.get_Nroomid() == -1){
            if (this.get_Croomid() == 3){
                this.set_forks(new int[]{4,5});
            }
            System.out.println("roomforked! : "+this.get_Croomid());
        }
    }
    public int get_Croomid(){
        return loadedroom.get_roomid();
    }
    public int get_Nroomid(){
        return loadedroom.get_nextid();
    }
    public String get_roomBGM(){
        return loadedroom.roombgm;
    }
    public String get_type(){
        return loadedroom.rtype;
    }

    //special functions
    public void rewardroomgiver(player target){
        loadedroom.givereward(target);
    }
    public entity[] getfoescombat(){
        return loadedroom.foes;
    }

    //forks for shop
    public void clearforks(){
        this.forks = new int[]{};

    }
    public void set_forks(int[] forks) {
        this.forks = forks;
    }
    public int[] get_forks() {
        return forks;
    }
    public int get_noforks() {
        return this.forks.length;
    }



    ////??????
    /**
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

    public void loadroom(RoomParent newroom);
     */
}
