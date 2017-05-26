package Assignment.game.roomclasses;

import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.entity;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class ROOM_encounter_easy extends ROOM_encounter {
    //

    //
    ROOM_encounter_easy(){

        this.foes = new entity[]{new ENT_enemy_easy()};
    }


    //

}
