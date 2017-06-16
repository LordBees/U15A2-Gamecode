package Assignment.game.unused;

import Assignment.game.RoomParent;
import Assignment.game.SND_handler_main;
import Assignment.game.roomclasses.ROOM_empty;
import Assignment.game.roomhandler;

import java.util.Scanner;

/**
 * Created by Spartan 2 on 2017-05-19.
 *
 */

/**
 * UNUSED CODE,PUT HERE FOR REFERENCE / SHOWING PROGRESS IN DESIGN
 */

public class Gameloop_OLD {
    //private Clip bgmclip;
    private SND_handler_main bgmclip = new SND_handler_main();

    private roomhandler rtracker = new roomhandler();//tracks roomdata
    private Scanner cons_input = new Scanner(System.in);
    private boolean isrunning = true;//if running
    String gamestate = "D";//gamestate (what is happening in game/)
    String last_gamestate = "D";//last gamestate

    private String chs;// user input
    //private window [] window array conatining windows
    private  RoomParent[]  xrooms ;//class containing all room types instanced as required
    private String winstate = "fail";//good,bad

    Gameloop_OLD(){
        //setup
        xrooms = new RoomParent[] {new ROOM_empty()};
        //this.bgmclip.load("src/Assignment/game/Song.wav");



        ///window setup



    }
    public void run(){
        System.out.println("-<starting game");

        System.out.println("menusound loaded");
        this.bgmclip.load("Menu.wav",true);
        this.bgmclip.play();

        gamemain();

        System.out.println("-<Quitting game");
    }

    public void gamemain(){
        System.out.println("-starting game loop");
        changegamestate("M");//change to starting state
        while (isrunning){
            //this.chs = get_user_input();
            switch (this.gamestate.toUpperCase()){//switch for gamestate things
                case "M"://main menu
                    System.out.println("select a new game (N) or how to play(H)");
                    this.chs = get_user_input();
                    if(chs.equals("N")){
                        changegamestate("START");//change to starting room
                    }
                    else if(chs.equals("H")){
                        changegamestate("HELP");//change to help menu
                    }
                    else{
                        System.out.println("invalid input please retry:");
                    }
                    break;

                case "HELP"://help menu
                    System.out.println("help menu");
                    changegamestate(this.last_gamestate);
                    break;

                case "OVER"://gameover screen(covers fail won+lose)
                    break;

                case "FIGHT"://fight
                    break;

                case "SHOP"://shop
                    break;

                case "TREAS"://treasure room
                    break;

                case "BLANK"://nothing room

                    break;

                case "START"://starting room (begiinning)b boss
                    System.out.println("you are in a room with nothing really@exposition");
                    System.out.println("Do You wish to go left or right?(L/R)");
                    this.chs = get_user_input();
                    if (this.chs.equals("L")){

                    }
                    break;

                case "D"://default
                    break;
            }
            this.chs = "D";//resetting game var
        }
        System.out.println("game loop finished");
    }
    public String get_user_input(){//gaet user input from either menu or data
        String txtcaptured = "N";
        System.out.print(">");
        txtcaptured = this.cons_input.next();

        return txtcaptured;
    }

    public void changegamestate(String new_gamestate){
        this.last_gamestate = this.gamestate;
        this.gamestate = new_gamestate;
    }
    public void changemusic(String newmus){
        this.bgmclip.load(newmus,true);
        this.bgmclip.play();
    }
}
