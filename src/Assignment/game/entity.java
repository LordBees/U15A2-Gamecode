package Assignment.game;

import java.util.Random;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class entity {
    //setup attributes
    protected Random RNG = new Random();//rng

    //actual attributes
    protected int health;//health
    protected int atk;//attack roller
    protected int atk_m;//attack modifier
    protected int def;//defence modifier
    protected String stance = "None";//set stance //None,Attacking,Defending,Healing;
    protected String E_name;// = "MissingName";


    entity(){
        //

        //
        this.health=100;
        this.atk = 5;
        this.atk_m=1;
        this.def = 1;
        this.E_name = "Nullmonster";

    }
    //methods for direct interaction
    protected void damage(int damagedone){//damage the entity
        this.health = this.health-damagedone;
    }
    protected void heal (int healamt){//heal the creature
        this.health = this.health+healamt;
    }
    protected int get_attack(){//entity's attack
        return this.RNG.nextInt(atk)*this.atk_m;//randoms a number within attack range then * by modifier
    }

    //methods for interaction with entity
    public void do_attack(entity target){//method for attacking other creature
        if (target.stance.equals("Defending")){
            //target.damage(0);//if defending take no damage
            int raw_dmg = this.get_attack();
            float defdam = ((raw_dmg/100)*this.def);// takes

            if (raw_dmg<=defdam){//if defence greater than monsters attack,always do 1 point of damage
                defdam = raw_dmg - 1.0f;//may cause error
            }

            target.damage(Math.round(raw_dmg-defdam));
        }
        else{
            target.damage(this.get_attack());//damage target for attack value of this entities attack value
        }
    }
    public boolean do_isdead(){//check if monster is dead
        if (this.health<=0){
            return false;
        }
        else {
            return true;
        }
    }
    //public void do_heal()
}
