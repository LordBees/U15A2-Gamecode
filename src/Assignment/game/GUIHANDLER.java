package Assignment.game;

import Assignment.game.Ents.ENT_enemy_boss;
import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.Ents.ENT_enemy_hard;
import Assignment.game.Ents.ENT_enemy_med;

import javax.swing.*;
import java.util.Random;

/**
 * Created by Spartan 2 on 2017-06-14.
 *
 */


/**
 * UNUSED CODE,PUT HERE FOR REFERENCE / SHOWING PROGRESS IN DESIGN
 */
public class GUIHANDLER {
    private player phero = new player();
    //public GUIHANDLER(player phero){
    //    this.phero = phero;
//
//    }
    public player getphero(){
        return this.phero;
    }

    public void do_win_main(String gstat,player phero,GUIHANDLER xguidat){
        JFrame windowFrame_mm = new JFrame("main");
        windowFrame_mm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//(JFrame.EXIT_ON_CLOSE);
        windowFrame_mm.setVisible(true);
        MENU_MainMenu form_mm = new MENU_MainMenu(gstat,this.phero,xguidat);
        windowFrame_mm.setContentPane(form_mm.gameScreenPanel);
        windowFrame_mm.pack();
        //windowFrame_mm.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    public void do_win_fight(String gstat,player phero){
        //setGstat("");

        ///hack to get working
        int scale;

        Random RNGstat = new Random();
        scale = RNGstat.nextInt(3);

        JFrame windowFrame_FI = new JFrame("FIGHT");
        windowFrame_FI.setVisible(true);
        phero.addheal(3);//add 3 heals
        fight fscale = new fight(phero,new ENT_enemy_easy());

        switch (scale){
            case 1:
                fscale = new fight(phero,new ENT_enemy_easy());
                break;
            case 2:
                fscale = new fight(phero,new ENT_enemy_med());
                break;
            case 3:
                fscale = new fight(phero,new ENT_enemy_hard());
                break;
            case 4:
                fscale = new fight(phero,new ENT_enemy_boss());
                break;
        }

        MENU_Fight form_fi = new MENU_Fight(fscale);///here for easy
        //MENU_Fight form_fi = new MENU_Fight(new fight(phero,new ENT_enemy_easy()));///here for easy
        windowFrame_FI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//exit on close
        windowFrame_FI.setContentPane(form_fi.gameScreenPanel);
        windowFrame_FI.pack();
        //windowFrame_FI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        windowFrame_FI.setLocationRelativeTo(null);
    }
    //}
}
