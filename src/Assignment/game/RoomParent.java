package Assignment.game;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class RoomParent {
    //has array of execuatable objects that are passed to the  invoker
    //attributes
    protected entity [] room_contents;
    //protected ;
    protected int roomid;
    protected int nextid;
    //constructor
    RoomParent(){//int xroomid,int xnextid){
        //this.roomid=xroomid;
        //this.nextid=xnextid;
        this.roomid = 0;
        this.nextid = 0;

    }

    //methods
    public void enterroom(){//called when player enters room

    }
    public void winroom(){//called if victory condition met in room

    }

    public void set_roomid(int new_id){
        this.roomid = new_id;
    }
    public void set_nextid(int new_id){
        this.nextid = new_id;
    }
    public int get_nextid(){
        return this.nextid;
    }
    public int get_roomid(){
        return this.roomid;
    }
}
