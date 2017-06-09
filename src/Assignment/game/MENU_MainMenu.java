package Assignment.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class MENU_MainMenu {
    public JPanel gameScreenPanel;

    private JButton howToPlayButton;
    private JButton startButton;
    private JTextArea welcomeToTheAdventureTextArea;


    private String gstat;

    public MENU_MainMenu(String gstat) {
        this.gstat = gstat;

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

            }
        });

    }
    public String getGstat(){
        return this.gstat;
    }
    public void setGstat(String gstat){
        this.gstat = gstat;
    }
}
