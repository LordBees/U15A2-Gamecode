package Assignment.game;

import java.util.Random;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class entity {
    //setup attributes
    protected Random RNG = new Random();//rng

    //actual attributes
    protected int health = 100;//health
    protected int healthmax = 100;//maxhelath
    protected int atk = 1;//attack roller
    protected int atk_m =1;//attack modifier
    protected int def = 1;//defence modifier
    protected int num_heals = 0;//heals
    protected String stance = "None";//set stance //None,Attacking,Defending,Healing;
    protected String E_name = "Nullmonster";// = "MissingName";
    protected int preward = 0;//gold for the player

    //snd
    protected String snd_DAM = "test.wav";
    protected String snd_HEAL = "test.wav";
    protected String snd_ATK = "test.wav";

/**
    entity(){
        //

        //
        this.health=100;
        this.atk = 5;
        this.atk_m=1;
        this.def = 1;
        this.E_name = "Nullmonster";

    }
 */
    //methods for direct interaction
    protected void damage(int damagedone){//damage the entity
        this.health = this.health-damagedone;
    }
    protected void heal (int healamt){//heal the creature
        if ( (healamt+this.health) >this.healthmax) {
        this.health = this.healthmax;
        }

        else {
        this.health = this.health+healamt;
        }
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
            System.out.println(this.getE_name()+" did damage:"+Math.round(raw_dmg-defdam));//dbg
            target.damage(Math.round(raw_dmg-defdam));
        }
        else{
            System.out.println(this.getE_name()+" did damage:"+this.get_attack());
            target.damage(this.get_attack());//damage target for attack value of this entities attack value
        }
    }
    public boolean do_isdead(){//check if monster is dead
        if (this.health>=0){
            return false;
        }
        else {
            return true;
        }
    }
    //public void do_heal()//allow for healing of ent
    public void do_heal(item itemx){//heal from an item
        this.heal(itemx.I_value);
    }
    public String getE_name() {
        return E_name;
    }
    public int getatk(){
        return this.atk;
    }
    public int getAtk_m(){
        return this.atk_m;
    }
    public int getDef(){
        return this.def;
    }
    public int getHealth(){
        return this.health;
    }
    public int getNum_heals(){
        return this.num_heals;
    }
    //set stance
    public String getStance() {
        return stance;
    }
    public void setStance(String stance) {
        this.stance = stance;
    }
    public void ResetStance(){
        this.stance = "None";
    }
    public void try_E_heal(){
        if (this.getNum_heals() >0){
            this.heal(10);
            this.num_heals--;
            System.out.println("the"+this.getE_name()+"healed 10HP!");
        }
    }
    public void chkhealth(){
        if (this.health>this.healthmax){
            this.health= this.healthmax;
        }
    }
    public void setPreward(int prx){
        this.preward = prx;
    }
    public int getPreward(){
        return this.preward;
    }
}
