package Assignment.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class MENU_Shop {

    public JPanel gameScreenPanel;
    private JButton BUY_HEALTH;
    private JButton BUY_DEF;
    private JButton BUY_ATK;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton upgradeSword40Button;
    private JTextArea textArea1;
    private JButton continueButton;
    private JTextArea WELCOMETOTHESHOPTextArea;
    private JTextField currentStatsTextField;
    private JTextField noPotionsCarriedTextField;
    private JButton BUY_POTION_HEAL;

    public MENU_Shop() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //shop code


            }
        };
        BUY_DEF.addActionListener(listener);
        BUY_ATK.addActionListener(listener);
        BUY_HEALTH.addActionListener(listener);
        upgradeSword40Button.addActionListener(listener);
        BUY_POTION_HEAL.addActionListener(listener);
        continueButton.addActionListener(listener);
    }

}
