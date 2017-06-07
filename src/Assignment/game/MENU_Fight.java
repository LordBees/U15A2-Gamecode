package Assignment.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class MENU_Fight {
    public JPanel gameScreenPanel;

    private JButton attackButton;
    private JButton runAwayButton;
    private JButton defendButton;
    private JButton healButton;
    private JButton continueButton;
    private JTextArea ASCII_monster;
    private JTextArea battletext_area;

    private fight battlex;


    public MENU_Fight(fight battlex) {
        this.battlex = battlex;


        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ///action case code

            }
        };
        attackButton.addActionListener(listener);
        runAwayButton.addActionListener(listener);
        defendButton.addActionListener(listener);
        healButton.addActionListener(listener);
        continueButton.addActionListener(listener);
    }
}
