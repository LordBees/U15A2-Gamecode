package Assignment.game;

import java.util.Random;

/**
 * Created by 10740071 on 23/05/2017.
 */
public class fight {
    protected Random RNG = new Random();//rng
    private boolean fighting = true;
    private String chs;
    private entity foe;
    private player playerx;

    fight(player playerx,entity foe) {
        this.playerx = playerx;
        this.foe = foe;
    }

    public boolean fighterloop(){
        boolean playersurvived = false;
        while (fighting){
            if (playerx.do_isdead() == true) {//if player dies
                System.out.println("you died!");
                this.fighting = false;
                playersurvived = false;
            }
            else if (foe.do_isdead() == true){//if foe dies
                this.fighting = false;
                System.out.println("you defeated a "+foe.getE_name());
                playersurvived = true;
            }
            else{
                //fight
                this.chs = this.getinp();
                switch (chs){
                    case"attack":
                        this.playerattack();
                        break;
                    case"defend":
                        this.playerdefend();
                        break;
                    case "heal":
                        this.playerheal();
                        break;
                }
                //enemy turn
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
        }
        return playersurvived;
    }
    public void playerattack(){
        this.playerx.do_attack(this.foe);

    }
    public void playerdefend(){

    }
    public void playerheal(){

    }

    public void foeattack(){

    }
    public void foedefend(){

    }
    public void foeheal(){

    }
    //input methd
    public String getinp(){
        String inx = "";
        return inx;
    }

}
