package Assignment.game.encounters;

import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.encounter;
import Assignment.game.entity;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class encounter_easy extends encounter {
    //

    //
    public encounter_easy(){
        this.foes = new entity[]{new ENT_enemy_easy()};
    }

    //

}
