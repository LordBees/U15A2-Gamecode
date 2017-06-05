package Assignment.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class MENU_GameOver {
    public JPanel gameScreenPanel;

    private JTextArea betterLuckNextTimeTextArea;
    private JButton retryButton;
    private JButton exitButton;
    private JButton howToPlayButton;

    public MENU_GameOver() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };
        retryButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        howToPlayButton.addActionListener(listener);
    }
}
