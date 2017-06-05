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

    public MENU_MainMenu() {
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
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        howToPlayButton.addActionListener(listener);
        startButton.addActionListener(listener);
    }
}
