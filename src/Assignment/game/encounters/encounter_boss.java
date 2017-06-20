package Assignment.game.encounters;

import Assignment.game.Ents.ENT_enemy_boss;
import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.encounter;
import Assignment.game.entity;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class encounter_boss extends encounter {
    //

    // setting boss data
    public encounter_boss(){
        this.foes = new entity[]{new ENT_enemy_boss()};
    }

    //

}
