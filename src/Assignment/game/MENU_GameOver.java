package Assignment.game;

import Assignment.game.Ents.ENT_enemy_boss;
import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.Ents.ENT_enemy_hard;
import Assignment.game.Ents.ENT_enemy_med;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class MENU_GameOver {
    public JPanel gameScreenPanel;

    private JTextArea betterLuckNextTimeTextArea;
    private JButton retryButton;
    private JButton exitButton;
    private JButton howToPlayButton;

    private player phero;

    public MENU_GameOver() {
        this.phero = new player();

        howToPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame windowFrame_h2 = new JFrame("how2");
                windowFrame_h2.setVisible(true);
                MENU_HOW2 form_h2 = new MENU_HOW2(new player());
                windowFrame_h2.setContentPane(form_h2.gameScreenPanel);
                windowFrame_h2.pack();
                windowFrame_h2.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                windowFrame_h2.setLocationRelativeTo(null);
            }
        });
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //This is where our code runs when the button
                // is clicked
                //String story = theFight.TakeTurn("a");
                //storyText.setText(story);
                //Gameloop
                //this.gstat
                //setGstat("");
                //gstat = "test";

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


        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
