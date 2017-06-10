package Assignment.game;

import Assignment.game.Ents.ENT_enemy_boss;
import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.Ents.ENT_enemy_hard;
import Assignment.game.Ents.ENT_enemy_med;

import javax.swing.*;

/**
 * Created by Spartan 2 on 2017-06-10.
 */
public class window_guih {//testing
    public JFrame windowFrame_mm = new JFrame("main");
    public JFrame windowFrame_sh = new JFrame("shop");
    public JFrame windowFrame_lb = new JFrame("loot or blank room");
    public JFrame windowFrame_fi = new JFrame("main");
    player phero;
    boolean nextwin = false;//; if true break loop outside;;



    public window_guih(player phero){
        this.phero=phero;
    }

    public void do_win_fight(int scale){
        JFrame windowFrame_FI = new JFrame("FIGHT");
        windowFrame_FI.setVisible(true);
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
        windowFrame_FI.setContentPane(form_fi.gameScreenPanel);
        windowFrame_FI.pack();
        windowFrame_FI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        windowFrame_FI.setLocationRelativeTo(null);
    }

    public void do_win_main(String gstat){
        JFrame windowFrame_mm = new JFrame("main");
        windowFrame_mm.setVisible(true);
        MENU_MainMenu form_mm = new MENU_MainMenu(gstat,phero);
        windowFrame_mm.setContentPane(form_mm.gameScreenPanel);
        windowFrame_mm.pack();
        windowFrame_mm.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    public player do_win_shop(String gstat){
        JFrame windowFrame_sh = new JFrame("shop");
        windowFrame_sh.setVisible(true);
        MENU_Shop form_sh = new MENU_Shop(this.phero,false);
        windowFrame_sh.setContentPane(form_sh.gameScreenPanel);
        windowFrame_sh.pack();
        windowFrame_sh.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        return form_sh.updateplayerfromshop();

    }

    public void do_win_lorb(String gstat,int gpickup){
        JFrame windowFrame_lb = new JFrame("lorb");
        windowFrame_lb.setVisible(true);
        MENU_LootOrBlank form_lb = new MENU_LootOrBlank(gpickup);
        windowFrame_lb.setContentPane(form_lb.gameScreenPanel);
        windowFrame_lb.pack();
        windowFrame_lb.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
    public boolean iscomplete(){
        return this.nextwin;
    }
}
