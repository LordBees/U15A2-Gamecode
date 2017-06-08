package Assignment.game;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by 10740071 on 23/05/2017.
 */
public class fight {
    //sfx clip
    //private Clip sfxclip;
    private SND_handler_main sfxclip = new SND_handler_main();

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
    //private boolean iswindowed;//displays windows instead of text

    //some fight information moved here to allow for making it work, will move into classes of monsters when applicable
    //rather it worked badly than not at all
    private String[] stance = {"NONE","NONE"};//valid none,atk,def,heal,die?,run
    public String [] data2r = new String[2];

    fight(player playerx,entity foe) {
        this.playerx = playerx;
        this.foe = foe;
        //this.iswindowed = iswindowed;
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
        //foe.setStance("ATK");

    }
    public void playerdefend(){
        stance[0] = "DEF";
        playerx.setStance("Defending");

    }
    public void playerheal(){
        stance[0] = "HEAL";

    }

    public void foeattack(){
        stance[1] = "ATK";

    }
    public void foedefend(){
        stance[1] = "DEF";
        //foe.setStance("Defending");

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
        stance[1] = stance[1].toUpperCase();

        //set defending flags if needed
        if (stance[0].equals("DEF")){
            playerx.setStance("Defending");
        }
        if (stance[1].equals("DEF")){
            foe.setStance("Defending");
        }


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
                break;

            case "ATK":
                sfxclip.load("SFX_atk.wav",false);
                sfxclip.play();
                switch (stance[1]){

                    case "ATK":
                        System.out.println("you attacked the monster, it attacks you!");
                        foe.do_attack(playerx);
                        playerx.do_attack(foe);
                        //sfxclip.play();
                        break;

                    case "DEF":
                        System.out.println("you attacked the monster!- it defended your attack!");
                        playerx.do_attack(foe);
                        break;

                    case "HEAL":
                        System.out.println("you attacked the monster,it tried to heal");
                        playerx.do_attack(foe);
                        foe.try_E_heal();
                        break;
                }


                break;
            case "DEF"://player defending
                switch (stance[1]){//monster options
                    case "ATK":
                        foe.do_attack(playerx);
                        System.out.println("you defended against the monsters attack!");
                    break;

                    case "DEF":
                        System.out.println("you defended against the monster, it does the same!");
                    break;

                    case "HEAL":
                        System.out.println("you healed while the monster helaed!");
                        if(foe.getNum_heals() >+1){//if can heal
                            foe.try_E_heal();
                        }
                        else {
                            System.out.println("the monster failed to heal...");
                        }
                    break;

                }
                break;
            case "HEAL":
                switch (stance[1]) {//monster options
                    case "ATK":
                        System.out.println("healed while the monster attacked!");
                        playerx.try_heal();
                        foe.do_attack(playerx);
                        break;

                    case "DEF":
                        System.out.println("you try to heal, the monster tried to defend!");
                        playerx.try_heal();
                        break;//no damage dealt

                    case "HEAL":
                        System.out.println("You try to heal, the monster does the same");
                        playerx.try_heal();
                        if (foe.getNum_heals() > +1) {//if can heal
                            foe.try_E_heal();
                        } else {
                            System.out.println("the monster failed to heal...");
                        }
                        break;
                }
                break;


    }
        //

        //clear stances
        //stance[0] = "NONE";
        //stance[1] = "NONE";
        //foe.ResetStance();
        //playerx.ResetStance();
        this.resetstance_all();
    }


    public boolean fighterloop_win(){
        boolean playersurvived = false;
        wonfight = false;
        if (true){
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


                }
                //enemy turn
                System.out.println("the monster ("+foe.getE_name()+") is doing something!");


                //resolveturn();
            }


        return playersurvived;
    }

    public void resolveturn_win(String popt){//player option ///hack

        System.out.println("FIGHTWIN data :"+popt+"\n____!!!!____----");
        this.rngstances_enemy_win();
        switch (popt) {
            case "ATK":
                this.playerattack();
                break;
            case "DEF":
                this.playerdefend();
                break;

            case "HEAL":
                this.playerheal();
                break;

            case "RUN":
                //this.playerheal();
                stance[0] = "RUN";
                break;
        }


        System.out.println("DATADSTATx{:"+data2r[0]+"::"+data2r[1]+":}");
        System.out.println("DATAstanceX{:"+stance[0]+"::"+stance[1]+":}");
        //this.data2r = this.stance;
        this.data2r[0] = this.stance[0];
        this.data2r[1] = this.stance[1];
        System.out.println("DATADSTATx{:"+data2r[0]+"::"+data2r[1]+":}");
        System.out.println("DATAstanceX{:"+stance[0]+"::"+stance[1]+":}");

            if (stance[0].equals("DEF")) {
                playerx.setStance("Defending");
            }
            if (stance[1].equals("DEF")) {
                foe.setStance("Defending");
            }

            switch (popt) {
                case "RUN":
                    if (stance[1].equals("ATK")) {
                        foe.do_attack(playerx);
                        System.out.println("you ran away and took some damage in the process...");
                    } else {
                        System.out.println("you ran away...");
                    }
                    wonfight = false;
                    this.fighting = false;
                    break;

                case "ATK":
                    //sfxclip.load("SFX_atk.wav", false);
                    //sfxclip.play();
                    switch (stance[1]) {

                        case "ATK":
                            System.out.println("you attacked the monster, it attacks you!");
                            foe.do_attack(playerx);
                            playerx.do_attack(foe);
                            //sfxclip.play();
                            break;

                        case "DEF":
                            System.out.println("you attacked the monster!- it defended your attack!");
                            playerx.do_attack(foe);
                            break;

                        case "HEAL":
                            System.out.println("you attacked the monster,it tried to heal");
                            playerx.do_attack(foe);
                            foe.try_E_heal();
                            break;
                    }


                    break;
                case "DEF"://player defending
                    switch (stance[1]) {//monster options
                        case "ATK":
                            foe.do_attack(playerx);
                            System.out.println("you defended against the monsters attack!");
                            break;

                        case "DEF":
                            System.out.println("you defended against the monster, it does the same!");
                            break;

                        case "HEAL":
                            System.out.println("you healed while the monster helaed!");
                            if (foe.getNum_heals() > +1) {//if can heal
                                foe.try_E_heal();
                            } else {
                                System.out.println("the monster failed to heal...");
                            }
                            break;

                    }
                    break;
                case "HEAL":
                    switch (stance[1]) {//monster options
                        case "ATK":
                            System.out.println("healed while the monster attacked!");
                            playerx.try_heal();
                            foe.do_attack(playerx);
                            break;

                        case "DEF":
                            System.out.println("you try to heal, the monster tried to defend!");
                            playerx.try_heal();
                            break;//no damage dealt

                        case "HEAL":
                            System.out.println("You try to heal, the monster does the same");
                            playerx.try_heal();
                            if (foe.getNum_heals() > +1) {//if can heal
                                foe.try_E_heal();
                            } else {
                                System.out.println("the monster failed to heal...");
                            }
                            break;
                    }
                    break;

            }
        //data2r = this.stance;
        this.resetstance_all();
        //return data2r;
    }

    public void resetstance_all(){
        stance[0] = "NONE";
        stance[1] = "NONE";
        foe.ResetStance();
        playerx.ResetStance();
    }
    public int[] get_hpvalues_win(){
        int [] retdat = new int[2];
        //
        retdat[0] = playerx.getHealth();
        retdat[1] = foe.getHealth();
        //
        return retdat;
    }
    public String get_fname_win(){
        return foe.getE_name();
    }

    public void rngstances_enemy_win (){
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

    }
public boolean get_isfighting_win(){
    return this.fighting;
}
    public Boolean get_wonfight(){
        return wonfight;
    }
    public String[] get_data2r(){
        System.out.println("DATADSTATx{:"+data2r[0]+"::"+data2r[1]+":}");
        return this.data2r;
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
