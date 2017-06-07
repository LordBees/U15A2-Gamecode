package Assignment.game;

import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.Ents.ENT_enemy_hard;
import Assignment.game.Ents.ENT_enemy_med;
import Assignment.game.roomclasses.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class Gameloop {
    //attribute definitions//

    //bgm music
    //private Clip bgmclip;
    private SND_handler_main bgmclip = new SND_handler_main();

    //sfx clip
    //private Clip sfxclip;
    private SND_handler_main sfxclip = new SND_handler_main();

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
    //private  RoomParent []  xrooms ;//class containing all room types instanced as required
    private RoomParent[] xrooms = new RoomParent[20];
    private RoomParent[] xrooms_int = new ROOM_INTERNAL[3];// new RoomParent[3];
    private String winstate = "fail";//good,bad

    private boolean iswindowed = false;

    String gstat = "PROL";//prologue
    boolean ignore_room_gstat = false;//for ignoring room loading of state

    Gameloop(){
        //setup
        //xrooms = new RoomParent[] {new ROOM_empty()};
        //this is the roomtable
        /**
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


        */
        xrooms[0] = new ROOM_loot();
        xrooms[1] = new ROOM_encounter_easy();
        xrooms[2] = new ROOM_shop();
        xrooms[3] = new ROOM_encounter_med();
        xrooms[4] = new ROOM_empty();
        xrooms[5] = new ROOM_encounter_med();
        xrooms[6] = new ROOM_encounter_hard();
        xrooms[7] = new ROOM_loot();
        xrooms[8] = new ROOM_loot();
        xrooms[9] = new ROOM_empty();
        xrooms[10] = new ROOM_loot();
        xrooms[11] = new ROOM_shop();
        xrooms[12] = new ROOM_encounter_easy();
        xrooms[13] = new ROOM_encounter_med();
        xrooms[14] = new ROOM_encounter_hard();
        xrooms[15] = new ROOM_empty();
        xrooms[16] = new ROOM_loot();
        xrooms[17] = new ROOM_loot();
        xrooms[18] = new ROOM_shop();
        xrooms[19] = new ROOM_encounter_boss();


        ///room id and data setup

        xrooms[0].setup(1,2);
        xrooms[1].setup(2,2);

        xrooms[2].setup(3,-1);//if -1 then do something else(choice
        //xrooms[2].setforks(new int[]{4,5});

        xrooms[3].setup(4,5);
        xrooms[4].setup(5,6);
        xrooms[5].setup(6,7);
        xrooms[6].setup(7,8);
        xrooms[7].setup(8,9);
        xrooms[8].setup(9,10);
        xrooms[9].setup(10,11);
        xrooms[10].setup(11,11);

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


        //internal setup of rooms
        xrooms_int[0] = new ROOM_internal_fork_01();
        xrooms_int[1] = new ROOM_internal_fork_02();
        xrooms_int[2] = new ROOM_internal_fork_03();

        xrooms_int[0].setup(3,-1);
        xrooms_int[1].setup(12,-1);
        xrooms_int[2].setup(19,-1);
        ///window setup



    }
    public void run(){
        System.out.println("-<starting game");

        // is windowed or just console
        boolean runningvar=true;
        chs="";
        while(runningvar)
        {
            System.out.println("do you wish to enable windowed mode\n" +
                               "Type(Y)/(N)");
            chs = this.get_user_input();
            if(chs.toUpperCase().equals("Y")){
                iswindowed = true;
                runningvar = false;
            }
            else if (chs.toUpperCase().equals("N")){
                runningvar = false;

            }

        }
        System.out.println("game initialising...");


        System.out.println("menusound loaded");
        this.bgmclip.load("Menu.wav",true);
        this.bgmclip.play();
        //this.printlnx(this.readdata("test.txt"));
        //gamemain();
        ///**
        if (!iswindowed) {
            gamemain();
        }
        else{
            gamemain_windowed();
        }
         //*/


        System.out.println("-<Quitting game");
        bgmclip.stop();
    }

    public void gamemain(){
        //String gstat = "PROL";//prologue  //moved up to class
        if (iswindowed){
            JFrame windowFrame_mm = new JFrame("main");
            windowFrame_mm.setVisible(true);
            MENU_MainMenu form_mm = new MENU_MainMenu();
            windowFrame_mm.setContentPane(form_mm.gameScreenPanel);
            windowFrame_mm.pack();
            windowFrame_mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }
        else {
            System.out.println("welcome to the game" +
                    "select a new game (N) or how to play(H)");
            chs = this.get_user_input();
            if (chs.toUpperCase().equals("H")) {
                System.out.println("help:");
            } else {
                System.out.println("starting game");
            }
            //System.out.println("press any key to start>:");
            //chs = this.get_user_input();

            //this is outside loop as it needs to be there for moment as bgm snd crashes as no music is loaded rather it worked now than not at all
            System.out.println("you are in a small corridor you can go left or right (L/R)");
            while (this.isrunning) {
                chs = this.get_user_input();
                if (chs.toUpperCase().equals("L")) {
                    System.out.println("you chose left");
                    this.isrunning = false;
                    rtracker.LoadRoom(xrooms[0]);

                } else if (chs.toUpperCase().equals("R")) {
                    System.out.println("you chose right");
                    this.isrunning = false;
                    rtracker.LoadRoom(xrooms[1]);
                } else {
                    System.out.println("please type a correct choice(L/R)");
                }
            }
            this.isrunning = true;//hack
        }
        System.out.println("Gameloop entered...");
       while (this.isrunning){
           //game loop
           //chs = this.get_user_input();
           /**
            * this is how the room data is managed if any changes are needed
            */
           //rdatx//gamestate
           //if(gstat.equals("SHOP")){//if loop on shop ignore getting gstate--need2fix
           if(!ignore_room_gstat){
               gstat = rtracker.get_type();//if room changes then change state unless flag is set
           }
           else {
               ignore_room_gstat = false;//reset
           }
           System.out.println("GS-->:"+gstat+":room id="+rtracker.get_Croomid()+":next="+rtracker.get_Nroomid());




           /**
            * this is how the bgm is changed
            */
           if (!bgmclip.issameas(rtracker.get_roomBGM())) {//check if the same track if yes skip the loading procedure
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
                    //int paths = rtracker.get_noforks();
                    int[] pforks = rtracker.get_forks();
                    System.out.println("d:"+pforks.length);
                    System.out.println(pforks[0]+":"+pforks[1]+":"+pforks[2]+":");

                    if (pforks[0] != -1){
                        System.out.println("path 1 is  left (L)");

                    }
                   if (pforks[1] != -1){
                       System.out.println("path 2 is right(R)");

                   }
                   if (pforks[2] != -1){
                       System.out.println("path 3 is straight on (S)");

                   }

                   System.out.println("choose a direction");
                   chs = this.get_user_input();
                   if((chs.toUpperCase().equals("L"))&& (pforks[0] !=-1)){
                       rtracker.LoadRoom(xrooms[pforks[0]]);
                   }
                   else if (chs.toUpperCase().equals("R")&& pforks[1] !=-1) {
                       rtracker.LoadRoom(xrooms[pforks[1]]);
                   }
                   else if (chs.toUpperCase().equals("S")&& pforks[2] !=-1){
                       rtracker.LoadRoom(xrooms[pforks[2]]);
                   }
                   else{
                       System.out.println("incorrect path please try again");
                   }
                   break;


                    /**
                     * old code kept for refactoring manually...
                    System.out.println("path 1 is  left (L)");
                    //if(paths == 2){
                   if (pforks[0]!=-1){
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
                     */

               case"SHOP":
                   /**
                   this.bgmclip.stop();
                   this.bgmclip.load("Shop.wav",true);
                   this.bgmclip.play();
                    */

                   System.out.println("________________\n" +
                                      "you are in a shop, you have ("+phero.getmoney()+") gold to spend}+\n" +
                                      "the items for sale are:\n");
                   System.out.println("-----------------\n" +
                                      "attack increase  (A):cost-14 [current:"+phero.getatk()+"]\n" +
                                      "defence increase (D):cost-12 [current:"+phero.getDef()+"]\n" +
                                      "health increase  (H):cost-15 [current:"+phero.getHealth()+"]\n" +
                                      "health potion    (P):cost-7  [current:"+phero.getNum_heals()+"]\n" +
                                      "super sword      (S):cost-40 [current:"+phero.hassword()+"]\n" +
                                      "-----------------");
                   System.out.println("what would you like to buy?\n" +
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
                               System.out.println("you cannot afford this item(health+10)");
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
                               System.out.println("you cannot afford this item(health potion+1)");
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
                           //
                           //gstat = "FORK";
                           //this.gstat = "FORK";
                           System.out.println("You leave the shop...");
                           //if (rtracker.get_Croomid() == xrooms_int[0])
                           //for (int i =0;i<xrooms_int.length;i++){
                           //    System.out.println(rtracker.get_Croomid()+"::"+xrooms_int[i].getshopid());
                           //    if (rtracker.get_Croomid() == xrooms_int[i].getshopid()){
                           //        rtracker.LoadRoom(xrooms_int[i]);
                           //    }
                           System.out.println(rtracker.get_Croomid());
                           System.out.println(  xrooms_int[0].getshopid()+":"
                                                +xrooms_int[1].getshopid()+":"+
                                                xrooms_int[2].getshopid()+":");

                           if (rtracker.get_Croomid()== xrooms_int[0].getshopid())
                           {
                               System.out.println("@@@@''''@@@@''''");
                               rtracker.LoadRoom(xrooms_int[0]);
                           }
                           else if (rtracker.get_Croomid()== xrooms_int[1].getshopid())
                           {
                               System.out.println("####~~~~####~~~~");
                               rtracker.LoadRoom(xrooms_int[1]);
                           }
                           else if (rtracker.get_Croomid()== xrooms_int[2].getshopid())
                           {
                               System.out.println("BossSsobBossSsob");
                               rtracker.LoadRoom(xrooms_int[2]);
                           }
                           /**
                            * can now put back into for loop
                            */
                           //rtracker.LoadRoom(xrooms_int[0]);//load next room(fork internal)
                           break;
                   }
                   break;


               case "LOOT":
                   System.out.println("YOU FOUND A LOOT ROOM!");
                   //System.out.println("you found ");
                   rtracker.rewardroomgiver(phero);
                   while(!chs.toUpperCase().equals("C"))
                   {
                       System.out.println("Type(C) to go to the next room");
                       chs = this.get_user_input();
                   }

                   System.out.println("you go to the next room...");
                   rtracker.LoadRoom(xrooms[rtracker.get_Nroomid()]);//load next room
                   break;


               case "FIGHT":
                   //System.out.println("you are in a room with some monsters");
                   //System.out.println("you are in a room with "+thisfoes.length+" monsters");
                   //printlnx(rtracker.);
                   //chs = this.get_user_input();
                   entity[] thisfoes;// = new entity[5];//this should be 4
                   fight currentfight;

                   //System.out.println("DEBUG fightingmx:"+thisfoes.length+"rtrackerrrom:"+rtracker.get_Croomid());

                   thisfoes = rtracker.getfoescombat();
                   /**
                    * //debug by putting raw into redo code to make pull out entity names out of class
                    * then instance them in gameloop append to thisfoes instead of putting classes into the array
                    */


                   switch (rtracker.getCombattype()){//decide what difficulty the room is
                       case "EASY":
                           thisfoes = new entity[] {new ENT_enemy_easy()};
                           break;
                       case "MEDIUM":
                           thisfoes = new entity[] {new ENT_enemy_easy(),new ENT_enemy_med()};
                           break;
                       case "HARD":
                           thisfoes = new entity[] {new ENT_enemy_med(),new ENT_enemy_hard()};
                           break;


                       default://if undefined
                           thisfoes = new entity[]{new ENT_enemy_easy()};
                           break;
                   }
                   //end fight setup

                   //user feedback
                   if (thisfoes.length == 1)
                   {
                       System.out.println("you are in a room with a "+thisfoes[0].getE_name()+" monster");
                   }
                   else
                   {
                       System.out.println("you are in a room with " + thisfoes.length + " monsters");
                   }
                   System.out.println    ("_______________\n");
                   //begin fight
                   //System.out.println("DEBUG fightingm:"+thisfoes.length);
                   for(int i =0;i<thisfoes.length;i++)
                   {
                       System.out.println("---------\nyou are fighting a " + thisfoes[i].getE_name());
                       currentfight = new fight(phero, thisfoes[i]);

                       if (!currentfight.fighterloop())
                       {
                           gstat = "DIED";//check
                       }
                       else if (!currentfight.get_wonfight()) {
                           System.out.println("you got nothing for the fight as you ran away");

                       }
                       else {
                           System.out.println("you won the fight!");

                       }
                   }
                   //when win
                   this.bgmclip.stop();
                   this.bgmclip.load("WinFight.wav",true);
                   this.bgmclip.play();
                   //rtracker.rewardroomgiver(phero);//this is causing nullptr
                   System.out.println("your reward for the room is:" +
                           "coins:");
                   chs="";
                   while(!chs.toUpperCase().equals("C"))
                   {
                       System.out.println("YOU WON!\n" +
                               "Type(C) to go to the next room");
                       chs = this.get_user_input();
                   }
                   System.out.println("You leave the battle room...");
                   rtracker.LoadRoom(xrooms[rtracker.get_Nroomid()]);//load next room
                   //currentfight = new fight(phero,m)
                   break;


               case "BOSS":
                   System.out.println("this is the BOSS!!!");

                   break;


               case "BLANK":
                   chs="";
                   while(!chs.toUpperCase().equals("C"))
                   {
                       System.out.println("you are in an empty room!\n" +
                               "Type(C) to go to the next room");
                       chs = this.get_user_input();
                   }
                   System.out.println("You leave the empty room...");
                   rtracker.LoadRoom(xrooms[rtracker.get_Nroomid()]);//load next room
                   break;


               case "DIED":
                   System.out.println("You died!! game over");
                   gstat = "RSET";
                   ignore_room_gstat = true;
                   break;


               case "BWIN":
                   break;


               case "BLOSE":
                   break;


               case "RSET":
                   System.out.println("do you want to retry(y/n)");
                   chs = this.get_user_input();
                   if (chs.toUpperCase().equals("Y")){
                       System.out.println("restarting game >UNIMP");
                    }
                    else if (chs.toUpperCase().equals("N")){
                       this.isrunning = false;
                   }
                   else{
                        System.out.println("incorrect input, please try again");
                   }
                   break;


               default:
                   System.out.println("GSERROR!!!");
                   //TimeUnit
                   int x=1;
                   while (1==x){
                   }
                   break;


           }
       }
    }


    public void gamemain_windowed(){
        gstat = "FIGHT";
        boolean isnew = true;
        while (isrunning){
            //gstat_H = gstat;
            switch (gstat){

                case"MAIN":
                    if (isnew){
                        do_win_fight();
                        isnew = false;
                    }


                    break;
                case"FIGHT":
                    if (isnew){
                        do_win_fight();
                        isnew = false;
                    }

                    break;
                case"d":
                    break;
                case"f":
                    break;
                case"g":
                    break;
            }
        }


    }



    /////////

    ////////
    ////window methods////
    ////////

    ////////
    public void do_win_fight(){
        JFrame windowFrame_FI = new JFrame("FIGHT");
        windowFrame_FI.setVisible(true);
        MENU_Fight form_fi = new MENU_Fight(new fight(phero,new ENT_enemy_easy()));///here for easy
        windowFrame_FI.setContentPane(form_fi.gameScreenPanel);
        windowFrame_FI.pack();
        windowFrame_FI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowFrame_FI.setLocationRelativeTo(null);
    }
    public void do_win_main(){
        JFrame windowFrame_mm = new JFrame("main");
        windowFrame_mm.setVisible(true);
        MENU_MainMenu form_mm = new MENU_MainMenu();
        windowFrame_mm.setContentPane(form_mm.gameScreenPanel);
        windowFrame_mm.pack();
        windowFrame_mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }




    ///////
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
    public void changegstat(String gstatx){
        this.gstat = gstatx;
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
