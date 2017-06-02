package Assignment.game;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by 10740071 on 23/05/2017.
 */
public class fight {
    //user input
    private Scanner cons_input = new Scanner(System.in);

    protected Random RNG = new Random();//rng
    private boolean fighting = true;
    private String chs;

    //combatants
    private entity foe;
    private player playerx;
    //
    private Boolean wonfight = false;

    //some fight information moved here to allow for making it work, will move into classes of monsters when applicable
    //rather it worked badly than not at all
    private String[] stance = {"NONE","NONE"};//valid none,atk,def,heal,die?,run

    fight(player playerx,entity foe) {
        this.playerx = playerx;
        this.foe = foe;
    }

    public boolean fighterloop(){
        boolean playersurvived = false;
        wonfight = false;
        while (fighting){
            System.out.println(playerx.do_isdead());
            System.out.println("health="+playerx.health);
            if (playerx.do_isdead() == true) {//if player dies
                System.out.println("you died in battle!" +
                        "\nslain by a"+foe.getE_name());
                this.fighting = false;
                playersurvived = false;
                wonfight = false;
            }
            else if (foe.do_isdead() == true){//if foe dies
                this.fighting = false;
                System.out.println("you defeated a "+foe.getE_name());
                playersurvived = true;
                wonfight = true;
            }
            else{
                //fight
                System.out.println( "\n------------------" +
                                    "\nthe default action is defend" +
                                    "\nchoose an action:" +
                                    "\n(A) attack the monster" +
                                    "\n(D) defend against the monsters attack" +
                                    "\n(H) use a healing potion("+playerx.getNum_heals()+") remaining" +
                                    "\n(R) run from the fight -no gold will be awarded" +
                                    "\n------------------");
                this.chs = this.getinp();
                switch (chs.toUpperCase()){
                    case"ATTACK":
                        this.playerattack();
                        break;
                    case"A":
                        this.playerattack();
                        break;

                    case"DEFEND":
                        this.playerdefend();
                        break;
                    case"D":
                        this.playerdefend();
                        break;

                    case "HEAL":
                        this.playerheal();
                        break;
                    case "H":
                        this.playerheal();
                        break;

                    case "RUN":
                        //this.playerheal();
                         stance[0] = "RUN";
                        break;
                    case "R":
                        //this.playerheal();
                        stance[0] = "RUN";
                        break;

                    default:
                        System.out.println( "didnt understand what you said["+chs+"]" +
                                            "\n defending...");
                        this.playerdefend();
                        break;

                }
                //enemy turn
                System.out.println("the monster ("+foe.getE_name()+") is doing something!");
                switch (RNG.nextInt(2)){//randomize action
                    case 0://atk
                        this.foeattack();
                        break;
                    case 1://def
                        this.foedefend();
                        break;
                    case 2://heal if possible
                        this.foeheal();
                        break;
                }

            resolveturn();
            }
        }
        return playersurvived;
    }


    public void playerattack(){
        //this.playerx.do_attack(this.foe);
        stance[0] = "ATK";

    }
    public void playerdefend(){
        stance[0] = "DEF";

    }
    public void playerheal(){
        stance[0] = "HEAL";

    }

    public void foeattack(){
        stance[1] = "ATK";

    }
    public void foedefend(){
        stance[1] = "DEF";

    }
    public void foeheal(){
        stance[1] = "HEAL";

    }
    public void resolveturn(){
        //resolves fight based on turn state


        //
        //if (stance[0].equals("RUN")){}

        //make uppercase so it doesn't have to be done on every case
        stance[0] = stance[0].toUpperCase();
        stance[0] = stance[0].toUpperCase();

        switch (stance[0]){
            case "RUN":
                if (stance[1].equals("ATK")){
                    foe.do_attack(playerx);
                    System.out.println("you ran away and took some damage in the process...");
                }
                else{
                    System.out.println("you ran away...");
                }
                wonfight = false;
                this.fighting = false;

        }
        //
        stance[0] = "NONE";
        stance[1] = "NONE";
    }
    public Boolean get_wonfight(){
        return wonfight;
    }
    //input methd
    //public String getinp(){
    //    String inx = "";
    //    return inx;
    //}
    //public String get_user_input(){//get user input from either menu or data
    public String getinp(){
        String txtcaptured = "N";
        System.out.print(">");
        txtcaptured = this.cons_input.next();

        return txtcaptured;
    }

}
