package Assignment.game;

import Assignment.game.Ents.ENT_enemy_boss;
import Assignment.game.Ents.ENT_enemy_easy;
import Assignment.game.Ents.ENT_enemy_hard;
import Assignment.game.Ents.ENT_enemy_med;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class MENU_MainMenu {
    public JPanel gameScreenPanel;

    private JButton howToPlayButton;
    private JButton startButton;
    private JTextArea welcomeToTheAdventureTextArea;
    private JLabel TPIC;


    private String gstat;

    public MENU_MainMenu(String gstat,player phero) {
        this.gstat = gstat;

        doimageprep();

        /**
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        howToPlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
         */

        /**
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        howToPlayButton.addActionListener(listener);
        startButton.addActionListener(listener);
         */

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //This is where our code runs when the button
                // is clicked
                //String story = theFight.TakeTurn("a");
                //storyText.setText(story);
                //Gameloop
                //this.gstat
                setGstat("");

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
                    windowFrame_FI.setContentPane(form_fi.gameScreenPanel);
                    windowFrame_FI.pack();
                    windowFrame_FI.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                    windowFrame_FI.setLocationRelativeTo(null);
                }


        });

    }
    public void doimageprep(){
        //ImageIcon icon = createImageIcon("images/middle.gif");
        String Xfile = "ASCII_titlepic.png";
    try {
        String current = new java.io.File(".").getCanonicalPath();
        System.out.println(current + "\\res\\" + Xfile);
        //File file = new File(current + "\\res\\" + Xfile);


        System.out.println(getClass() + "/res/ASCII_titlepic.png");

        ImageIcon icon = new ImageIcon(current + "\\res\\" + Xfile);
        TPIC.setIcon(icon);

    }
    catch (Exception e){
        System.out.println("file not found:"+"\\res\\" + Xfile);
    }

    }
    public String getGstat(){
        return this.gstat;
    }
    public void setGstat(String gstat){
        this.gstat = gstat;
    }

    /**
    private void createUIComponents() {
        // TODO: place custom component creation code here
        JimageC
        JImageComponent ic = new JImageComponent(myImageGoesHere);
        imagePanel.add(ic);
    }
     */

}
