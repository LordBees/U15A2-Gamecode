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
 * Created by 10740071 on 05/06/2017.
 */
public class MENU_HOW2 {
    public JPanel gameScreenPanel;

    private JTextField HOWTOPLAYTextField;
    private JTextArea how2txt;
    private JButton newGameButton;

    private SND_handler_main bgmx = new SND_handler_main();

    public MENU_HOW2(player phero) {

        ///

        bgmx.load("Mystery.wav",true);
        bgmx.play();

        how2txt.setText("to play the game you must take turns attacking\n" +
                " a monster until you win oar are defeated by the monster\n" +
                "you have 3 heals, you can attack,defend,heal and run away by clicking the button\n" +
                "to restart press continue when the fight has been won/lost");

        ///
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bgmx.stop();
                //This is where our code runs when the button
                // is clicked
                //String story = theFight.TakeTurn("a");
                //storyText.setText(story);
                //Gameloop
                //this.gstat
               // setGstat("");

                ///hack to get working
                int scale;

                Random RNGstat = new Random();
                scale = RNGstat.nextInt(3);

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
                windowFrame_FI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//exit on close
                windowFrame_FI.setContentPane(form_fi.gameScreenPanel);
                windowFrame_FI.pack();
                //windowFrame_FI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                windowFrame_FI.setLocationRelativeTo(null);
            }


        });
    }


}
