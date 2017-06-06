package Assignment.game.roomclasses;

import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.Ents.ENT_enemy_med;
import Assignment.game.entity;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class ROOM_encounter_hard extends ROOM_encounter {
    //

    //
    public ROOM_encounter_hard(){
        this.foes = new entity[]{new ENT_enemy_easy(),new ENT_enemy_med()};

    }

    //
}
