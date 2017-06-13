package Assignment.game;

import Assignment.game.Ents.ENT_enemy_boss;
import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.Ents.ENT_enemy_hard;
import Assignment.game.Ents.ENT_enemy_med;
import Assignment.game.roomclasses.*;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
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

    //rng
    //rng
    protected Random RNG = new Random();//rng

    //attribute vars//
    private boolean isrunning = true;//if running
    private boolean quittime = false;
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
        xrooms[18] = new ROOM_shop_preboss();//new ROOM_shop();
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

        xrooms[12].setup(13,15);
        xrooms[13].setup(14,16);
        xrooms[14].setup(15,17);
        xrooms[15].setup(16,18);
        xrooms[16].setup(17,18);
        xrooms[17].setup(18,18);

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
        this.isrunning = true;
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

        if (!iswindowed) {

            System.out.println("menusound loaded");
            this.bgmclip.load("Menu.wav", true);
            this.bgmclip.play();
        }
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
            MENU_MainMenu form_mm = new MENU_MainMenu(this.gstat,phero);
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
           chs="";
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
           //else{
           //    this.bgmclip.stop();
           //    this.bgmclip.play();
//
//           }


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
                   if (rtracker.get_Croomid() == 19){
                       System.out.println("________________\n"+
                                           "this is the final shop!!"+
                                           "________________\n");
                   }
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
                               phero.set_addtohmax(10);
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
                               if (false){// hack //(phero.get_invbyslot(1).equals("SuperSword")){
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
                               rtracker.LoadRoom(xrooms[19]);
                           }
                           /**
                            * can now put back into for loop
                            */
                           //rtracker.LoadRoom(xrooms_int[0]);//load next room(fork internal)
                           break;
                   }
                   break;

               case"SHOPX":
                   /**
                    this.bgmclip.stop();
                    this.bgmclip.load("Shop.wav",true);
                    this.bgmclip.play();
                    */
                   if (rtracker.get_Croomid() == 19){
                       System.out.println(  "________________\n"+
                                            "this is the final shop!!\n" +
                                            "!!!!discounted stock!!!!\n"+
                                            "________________\n");
                   }

                   System.out.println("________________\n" +
                           "you are in a shop, you have ("+phero.getmoney()+") gold to spend}+\n" +
                           "the items for sale are:\n");
                   System.out.println("-----------------\n" +
                           "attack increase  (A):cost-6 [current:"+phero.getatk()+"]\n" +
                           "defence increase (D):cost-10 [current:"+phero.getDef()+"]\n" +
                           "health increase  (H):cost-13 [current:"+phero.getHealth()+"]\n" +
                           "health potion    (P):cost-4  [current:"+phero.getNum_heals()+"]\n" +
                           "super sword      (S):cost-30 [current:"+phero.hassword()+"]\n" +
                           "-----------------");
                   System.out.println("what would you like to buy?\n" +
                           "to leave to the next area type (L)");
                   chs = this.get_user_input();
                   switch (chs.toUpperCase()){

                       case "A":
                           if(phero.canafford(6)){
                               //buy
                               phero.addto_atk(1);
                               phero.spend_gold(6);
                               System.out.println("you bought:attack increase!");
                           }
                           else{
                               System.out.println("you cannot afford this item(atk++)");

                           }
                           break;

                       case "D":
                           if(phero.canafford(10)){
                               //buy
                               phero.addto_def(1);
                               phero.spend_gold(10);
                               System.out.println("you bought:defence increase!");
                           }
                           else{
                               System.out.println("you cannot afford this item(Def++)");

                           }
                           break;

                       case "H":
                           if(phero.canafford(13)){
                               //buy
                               phero.set_addtohmax(10);
                               phero.addto_health(10);
                               phero.spend_gold(13);
                               System.out.println("you bought:health +10 increase!");
                           }
                           else{
                               System.out.println("you cannot afford this item(health+10)");
                           }
                           break;

                       case "P":
                           if(phero.canafford(4)){
                               //buy
                               phero.addheal(1);
                               phero.spend_gold(4);
                               System.out.println("you bought:a health potion!");
                           }
                           else{
                               System.out.println("you cannot afford this item(health potion+1)");
                           }
                           break;

                       case "S":
                           if(phero.canafford(30)){
                               //buy
                               if (false){// hack //(phero.get_invbyslot(1).equals("SuperSword")){
                                   System.out.println("you already have the sword!!");
                               }
                               else {
                                   phero.addsword();//quick add
                                   phero.spend_gold(30);
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

                           rtracker.LoadRoom(xrooms[19]);//load next room
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
                   System.out.println(">>>>>>>"+rtracker.getCombattype());
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
                       this.bgmclip.stop();
                       this.bgmclip.load("Battle.wav", true);
                       this.bgmclip.play();

                       System.out.println("---------\nyou are fighting a " + thisfoes[i].getE_name());
                       currentfight = new fight(phero, thisfoes[i]);

                       if (!currentfight.fighterloop())
                       {
                           gstat = "DIED";//check
                           ignore_room_gstat = true;
                       }
                       else if (!currentfight.get_wonfight()) {
                           System.out.println("you got nothing for the fight as you ran away");

                       }
                       else {
                           System.out.println("you won the fight!");
                           System.out.println("reward +Gold: "+thisfoes[i].getPreward());
                           phero.pickup_gold(thisfoes[i].getPreward());
                           ////when win
                           //this.bgmclip.stop();
                           //this.bgmclip.load("WinFight.wav",true);
                           //this.bgmclip.play();

                       }

                   }

                   //rtracker.rewardroomgiver(phero);//this is causing nullptr
                   //System.out.println("your reward for the room is:" +
                   //        "coins:");

                   chs="";
                   if (!this.gstat.equals("DIED")) {
                       //if (currentfight.get_wonfight()) {
                           //when win
                           this.bgmclip.stop();
                           this.bgmclip.load("WinFight.wav", true);
                           this.bgmclip.play();
                       //}
                       while (!chs.toUpperCase().equals("C")) {
                           System.out.println("YOU survived the fight!\n" +
                                   "Type(C) to go to the next room");
                           chs = this.get_user_input();
                       }
                       System.out.println("You leave the battle room...");
                       rtracker.LoadRoom(xrooms[rtracker.get_Nroomid()]);//load next room
                       //currentfight = new fight(phero,m)
                   }
                   break;


               case "BOSS":
                   System.out.println("this is the BOSS!!!");

                   //entity[] thisfoes;// = new entity[5];//this should be 4
                   //fight currentfight;

                   //System.out.println("DEBUG fightingmx:"+thisfoes.length+"rtrackerrrom:"+rtracker.get_Croomid());

                   //thisfoes = rtracker.getfoescombat();
                   /**
                    * //debug by putting raw into redo code to make pull out entity names out of class
                    * then instance them in gameloop append to thisfoes instead of putting classes into the array
                    */


                   thisfoes = new entity[] {new ENT_enemy_easy(),new ENT_enemy_med(),new ENT_enemy_hard(),new ENT_enemy_boss()};

                   //System.out.println(">>>>>>>"+rtracker.getCombattype());
                   //end fight setup

                   //user feedback

                   System.out.println("you are in a room with the BOSS and its " + thisfoes.length + " minions");

                   System.out.println    ("_______________\n");
                   //begin fight
                   //System.out.println("DEBUG fightingm:"+thisfoes.length);
                   for(int i =0;i<thisfoes.length;i++)
                   {
                       System.out.println("---------\nyou are fighting a " + thisfoes[i].getE_name());
                       currentfight = new fight(phero, thisfoes[i]);

                       if (!currentfight.fighterloop())
                       {
                           gstat = "BLOSE";//check
                           ignore_room_gstat = true;
                       }
                       else if (!currentfight.get_wonfight()) {
                           System.out.println("you got nothing for the fight as you ran away");
                           gstat = "BLOSE";//check
                           ignore_room_gstat = true;

                       }
                       else {
                           System.out.println("you won the fight!");
                           gstat = "BWIN";//check
                           ignore_room_gstat = true;


                       }
                       if (currentfight.get_wonfight()) {
                           //when win
                           this.bgmclip.stop();
                           this.bgmclip.load("WinFight.wav", true);
                           this.bgmclip.play();
                       }
                   }


                   chs="";
                   if (!this.gstat.equals("BLOSE")) {
                       while (!chs.toUpperCase().equals("C")) {
                           System.out.println("YOU fought the monster!\n" +
                                   "Type(C) to continue to the epilogue.");
                           chs = this.get_user_input();
                       }
                       System.out.println("You leave the dragons lair...");
                       rtracker.LoadRoom(xrooms[rtracker.get_Nroomid()]);//load next room
                       //currentfight = new fight(phero,m)
                   }


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
                   ignore_room_gstat = true;
                   System.out.println("you won the game by slaying the dragon!!");
                   gstat = "RSET";
                   break;


               case "BLOSE":
                   ignore_room_gstat = true;

                   ///

                   System.out.println("BAD ending!");
                   System.out.println("you lost the game and were eaten by the dragon");

                   ///
                   gstat = "RSET";
                   break;


               case "RSET":
                   ignore_room_gstat = true;
                   //if (currentfight.get_wonfight()) {
                       //when win
                       this.bgmclip.stop();
                       this.bgmclip.load("Menu.wav", true);
                       this.bgmclip.play();
                   //}
                   System.out.println("do you want to retry?" +
                           "\nhow to play(H)\n" +
                           "(Y/N/H)");
                   chs = this.get_user_input();
                   chs = chs.toUpperCase();
                   if (chs.equals("Y")){
                       System.out.println("restarting game >UNIMP");
                       this.isrunning = false;
                    }
                    else if (chs.equals("N")){
                       this.isrunning = false;
                       //this.quittime = false;
                       setquittime(false);
                   }
                   else  if (chs.equals("H")){
                        System.out.println("how2play");

                   }
                   else{
                        System.out.println("incorrect input, please try again");
                   }
                   break;


               default:
                   System.out.println("GSERROR!!!");
                   //TimeUnit
                   int x=1;//hang on invalid so data
                   while (1==x){
                   }
                   break;


           }
       }
    }


    public void gamemain_windowed(){
        //
        gstat = "SHOP";
        String ftype = "EASY";

        //
        boolean isnew = true;
        int roomsbeaten = 0;

        while (isrunning){
            //gstat_H = gstat;
            gstat = "MAIN";
            if (roomsbeaten==20){
                gstat = "BOSS";
            }
            else{
                switch (this.RNG.nextInt(3)) {
                    case 1:
                    break;
                    case 2:
                    break;
                    case 3:
                    break;

                    //case 4:
                    //break;

                }
            }

            switch (gstat){
                case"MAIN":
                    if (isnew){
                        do_win_main(gstat);
                        isnew = false;
                    }


                    break;
                case"FIGHT":
                    if (isnew){
                        //sfxclip.stop();
                        sfxclip.load("Battle.wav", true);
                        sfxclip.play();
                        //break;//no damag
                        do_win_fight(1);
                        System.out.println(2);
                        isnew = false;//Random RNGstat = new Random();
                    }

                    break;


                case"SHOP":
                    if (isnew){
                        this.phero = do_win_shop(gstat);
                        isnew = false;
                    }
                    break;

                case"LORB":
                    if (isnew){
                        do_win_lorb(gstat,0);
                        isnew = false;
                    }


                    break;

                case"g":
                    break;

            }
        }


    }

public void gameloop_win2(){
        int leftorright = 0;
        switch (leftorright){
            case 1://left

            break;

            case 0:
            break;
            case -1://
            break;
        }
}

    /////////

    ////////
    ////window methods////
    ////////

    ////////
    public void do_win_fight(int scale){
        JFrame windowFrame_FI = new JFrame("FIGHT");
        windowFrame_FI.setVisible(true);
        windowFrame_FI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fight fscale = new fight(phero,new ENT_enemy_easy());

        switch (scale){
            case 1:
                fscale = new fight(phero,new ENT_enemy_easy());
                break;
            case 2:
                fscale = new fight(phero,new ENT_enemy_med());
                break;
            case 3:
                fscale = new fight(phero,new ENT_enemy_hard());
                break;
            case 4:
                fscale = new fight(phero,new ENT_enemy_boss());
                break;
        }

        MENU_Fight form_fi = new MENU_Fight(fscale);///here for easy
        //MENU_Fight form_fi = new MENU_Fight(new fight(phero,new ENT_enemy_easy()));///here for easy
        windowFrame_FI.setContentPane(form_fi.gameScreenPanel);
        windowFrame_FI.pack();
        windowFrame_FI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        windowFrame_FI.setLocationRelativeTo(null);
    }

    public void do_win_main(String gstat){
        JFrame windowFrame_mm = new JFrame("main");
        windowFrame_mm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//(JFrame.EXIT_ON_CLOSE);
        windowFrame_mm.setVisible(true);
        MENU_MainMenu form_mm = new MENU_MainMenu(gstat,phero);
        windowFrame_mm.setContentPane(form_mm.gameScreenPanel);
        windowFrame_mm.pack();
        //windowFrame_mm.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public player do_win_shop(String gstat){
        JFrame windowFrame_sh = new JFrame("shop");
        windowFrame_sh.setVisible(true);
        MENU_Shop form_sh = new MENU_Shop(this.phero,false);
        windowFrame_sh.setContentPane(form_sh.gameScreenPanel);
        windowFrame_sh.pack();
        windowFrame_sh.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        return form_sh.updateplayerfromshop();

    }

    public void do_win_lorb(String gstat,int gpickup){
        JFrame windowFrame_lb = new JFrame("lorb");
        windowFrame_lb.setVisible(true);
        MENU_LootOrBlank form_lb = new MENU_LootOrBlank(gpickup);
        windowFrame_lb.setContentPane(form_lb.gameScreenPanel);
        windowFrame_lb.pack();
        windowFrame_lb.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
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
    public boolean getquittime(){
        return this.quittime;
    }
    public void setquittime(boolean xquit){
        this.quittime = xquit;
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
