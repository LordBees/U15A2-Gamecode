package Assignment.game;

import Assignment.game.encounters.encounter_boss;
import Assignment.game.roomclasses.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class Gameloop {
    //attribute definitions//

    //bgm music
    //private Clip bgmclip;
    private SND_handler_main bgmclip = new SND_handler_main();

    //room handler
    private roomhandler rtracker = new roomhandler();//tracks roomdata

    //user input
    private Scanner cons_input = new Scanner(System.in);

    //player
    private player phero = new player();

    //attribute vars//
    private boolean isrunning = true;//if running
    String gamestate = "D";//gamestate (what is happening in game/)
    String last_gamestate = "D";//last gamestate

    private String chs;// user input
    //private window [] window array conatining windows
    private  RoomParent []  xrooms ;//class containing all room types instanced as required
    private String winstate = "fail";//good,bad

    Gameloop(){
        //setup
        //xrooms = new RoomParent[] {new ROOM_empty()};
        //this is the roomtable
        xrooms  = new RoomParent[] {new ROOM_loot(),                                        new ROOM_encounter_easy(),
                                                                new ROOM_shop(),
                                    new ROOM_encounter_med(),                               new ROOM_empty(),
                                    new ROOM_encounter_med(),                               new ROOM_encounter_hard(),
                                    new ROOM_loot(),                                        new ROOM_loot(),
                                    new ROOM_empty(),                                       new ROOM_loot(),

                                                                new ROOM_shop(),

                                    new ROOM_encounter_easy(),  new ROOM_encounter_med(),   new ROOM_encounter_hard(),
                                    new ROOM_empty(),           new ROOM_loot(),            new ROOM_loot(),

                                                                new ROOM_shop(),

                                                                new ROOM_encounter_boss()};
                                    ///                     goodending or badending



        ///room id and data setup
        xrooms[0].setup(1,3);
        xrooms[1].setup(2,3);

        xrooms[2].setup(3,-1);//if -1 then do something else(choice
        //xrooms[2].setforks(new int[]{4,5});

        xrooms[3].setup(4,3);
        xrooms[4].setup(5,3);
        xrooms[5].setup(6,3);
        xrooms[6].setup(7,3);
        xrooms[7].setup(8,3);
        xrooms[8].setup(9,3);
        xrooms[9].setup(10,3);
        xrooms[10].setup(11,3);

        xrooms[11].setup(12,-1);

        xrooms[12].setup(13,3);
        xrooms[13].setup(14,3);
        xrooms[14].setup(15,3);
        xrooms[15].setup(16,3);
        xrooms[16].setup(17,3);
        xrooms[17].setup(18,3);

        xrooms[18].setup(19,-1);

        xrooms[19].setup(20,3);

        //xrooms[0].setup(1,3);



        //this.bgmclip.load("src/Assignment/game/Song.wav");



        ///window setup



    }
    public void run(){
        System.out.println("-<starting game");

        System.out.println("menusound loaded");
        this.bgmclip.load("Menu.wav",true);
        this.bgmclip.play();
        this.printlnx(this.readdata("test.txt"));

        gamemain();

        System.out.println("-<Quitting game");
    }

    public void gamemain(){
        String gstat = "PROL";//prologue
        System.out.println("welcome to the game" +
                "select a new game (N) or how to play(H)");
        chs = this.get_user_input();
        if (chs.toUpperCase().equals("H")){
            System.out.println("help:");
        }
        else{
            System.out.println("starting game");
        }
        //System.out.println("press any key to start>:");
        //chs = this.get_user_input();

        //this is outside loop as it needs to be there for moment as bgm snd crashes as no music is loaded rather it worked now than not at all
        System.out.println("you are in a small corridor you can go left or right (L/R)");
        while (this.isrunning) {
            chs = this.get_user_input();
            if (chs.toUpperCase().equals("L")){
                System.out.println("you chose left");
                this.isrunning = false;
                rtracker.LoadRoom(xrooms[0]);

            }
            else if (chs.toUpperCase().equals("R")){
                System.out.println("you chose right");
                this.isrunning = false;
                rtracker.LoadRoom(xrooms[1]);
            }
            else {
                System.out.println("please type a correct choice(L/R)");
            }
        }
        this.isrunning = true;//hack
       while (this.isrunning){
           //game loop
           //chs = this.get_user_input();
           /**
            * this is how the room data is managed if any changes are needed
            */
           //rdatx
           gamestate = rtracker.get_type();//if room changes then change state




           /**
            * this is how the bgm is changed
            */
           if (!bgmclip.issameas(rtracker.get_roomBGM())) {
               this.bgmclip.stop();
               this.bgmclip.load(rtracker.get_roomBGM(), true);
               this.bgmclip.play();
           }


           /**
            * this is how the game loops
            */
           switch (gstat){
               case "PROL"://xps at beginning
                   //gstat = "SHOP";

                   break;

               case "FORK"://a fork in the road only really shops can do this
                    int paths = rtracker.get_noforks();
                    int[] pforks = rtracker.get_forks();
                    System.out.println("path 1 is  left (L)");
                    if(paths == 2){
                        System.out.println("path 2 is right(R)");

                    }
                    if (paths > 2){
                        System.out.println("path 3 is straight on (S)");

                    }
                    else{


                    }
                   System.out.println("choose a direction");
                   chs = this.get_user_input();
                   if(chs.toUpperCase().equals("L")){
                       rtracker.LoadRoom(xrooms[pforks[0]]);
                   }
                   else if (chs.toUpperCase().equals("R")) {
                       rtracker.LoadRoom(xrooms[pforks[1]]);
                   }
                   else if (chs.toUpperCase().equals("S")|| paths>2){
                       rtracker.LoadRoom(xrooms[pforks[2]]);
                   }
                   else{
                       System.out.println("incorrect path please try again");
                   }
                   break;
               case"SHOP":
                   /**
                   this.bgmclip.stop();
                   this.bgmclip.load("Shop.wav",true);
                   this.bgmclip.play();
                    */

                   System.out.println("you are in a shop\n the items for sale are:");
                   System.out.println("attack increase  (A):cost-14 [current:"+phero.getatk()+"]\n" +
                                      "defence increase (D):cost-12 [current:"+phero.getDef()+"]\n" +
                                      "health increase  (H):cost-15 [current:"+phero.getHealth()+"]\n" +
                                      "health potion    (P):cost-7  [current:"+phero.getNum_heals()+"]\n" +
                                      "super sword      (S):cost-40 [current:"+phero.hassword()+"]\n");
                   System.out.println("what would you like to buy?" +
                           "to leave to the next area type (L)");
                   chs = this.get_user_input();
                   switch (chs.toUpperCase()){

                       case "A":
                           if(phero.canafford(14)){
                               //buy
                               phero.addto_atk(1);
                               phero.spend_gold(14);
                               System.out.println("you bought:attack increase!");
                           }
                           else{
                               System.out.println("you cannot afford this item(atk++)");

                           }
                           break;

                       case "D":
                           if(phero.canafford(12)){
                               //buy
                               phero.addto_def(1);
                               phero.spend_gold(12);
                               System.out.println("you bought:defence increase!");
                           }
                           else{
                               System.out.println("you cannot afford this item(Def++)");

                           }
                           break;

                       case "H":
                           if(phero.canafford(15)){
                               //buy
                               phero.addto_health(10);
                               phero.spend_gold(15);
                               System.out.println("you bought:health +10 increase!");
                           }
                           else{
                               System.out.println("you cannot afford this item(heath+10)");
                           }
                           break;

                       case "P":
                           if(phero.canafford(7)){
                               //buy
                               phero.addheal(1);
                               phero.spend_gold(7);
                               System.out.println("you bought:a health potion!");
                           }
                           else{

                           }
                           break;
                       case "S":
                           if(phero.canafford(40)){
                               //buy
                               if (phero.get_invbyslot(1).equals("SuperSword")){
                                   System.out.println("you already have the sword!!");
                               }
                               else {
                                   phero.addsword();//quick add
                                   phero.spend_gold(40);
                                   System.out.println("you bought:the super sword!");
                               }
                           }
                           else{
                               System.out.println("you cannot afford this item(Sword)");
                           }
                           break;
                       case "L"://leave shop
                           break;

                   }

                   break;
               case "LOOT":
                   System.out.println("YOU FOUND A LOOT ROOM!");
                   System.out.println("you found ");
                   break;
               case "FIGHT":
                   break;

           }




       }
    }

    public String get_user_input(){//get user input from either menu or data
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
    public void printlnx(String[] xdatin){
        for (int i =0;i>xdatin.length;i++){
            System.out.println(xdatin[i]);
        }
    }
    public String[] readdata(String fn){
        String[] xdata = {};
        String current;
        try {
            current = new java.io.File(".").getCanonicalPath();
        }
        catch(Exception e ){
            current = "";
            System.out.print("ioxtsdf");
        }
        System.out.println(current + "\\res\\" + fn);

        fn = current+"\\res\\"+fn;
        //BufferedReader br = new BufferedReader(new FileReader("file.txt"));

        try (BufferedReader br = new BufferedReader(new FileReader(fn))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return xdata;
    }


}
