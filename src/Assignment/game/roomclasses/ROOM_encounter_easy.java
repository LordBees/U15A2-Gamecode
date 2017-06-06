package Assignment.game.roomclasses;

import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.entity;
import Assignment.game.items.gold_bag;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class ROOM_encounter_easy extends ROOM_encounter {
    //

    //
    public ROOM_encounter_easy(){

        this.foes = new entity[]{new ENT_enemy_easy()};
        //this.lootin[0].setI_value(RNG.nextInt(10));
        //this.lootin[1].setI_value(RNG.nextInt(10));
        this.lootin[0] = new gold_bag();
        this.lootin[1] = new gold_bag();
        rngroom();
        //this.lootin[0].setI_value(10);//testing
        //this.lootin[1].setI_value(20);

    }


    //

}
