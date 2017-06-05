package Assignment.game;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class encounter extends RoomParent {

    //attr
    protected entity [] foes;

    //
    //encounter(){
        //this.foes.
        //this.foes

    //}

    //
    protected void room_fight(player playerx){//take player data for fighting
        boolean playersurvived = false;
        fight currentfight;
        for (int i=0;i>this.foes.length;i++){
            currentfight = new fight(playerx,foes[i]);
            playersurvived = currentfight.fighterloop();
            if (playersurvived = false){
                break;
            }

        }

    }
}
