package Assignment.game;

/**
 * Created by 10740071 on 23/05/2017.
 */

//roomhandler class for holding information about the current room
public class roomhandler {
    //attributes
    private RoomParent loadedroom;

    private int currentroom;
    private int lastroom;
    private int nextroom;
    //private String combattype = "";//may turn ito array later



    private int[] forks = {};


    //constructor(if used)

    //methods
    public void LoadRoom(RoomParent new_room){
        System.out.println("loading room:"+new_room.roomid);
        //System.out.println("branchdata-:"+new_room.get_roomforks()[0]);
        this.loadedroom = new_room;
        //checkloadforks();
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
        //return forks;
        return loadedroom.get_roomforks();
    }
    public int get_noforks() {
        //return this.forks.length;
        return loadedroom.get_roomforks().length;
    }

    //determines what to load into room
    public String getCombattype() {
        //return combattype;
        return loadedroom.getroomdificulty();
    }

    public void setCombattype(String combattype) {
        //this.combattype = combattype;
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
