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
    private JTextField txt_atkstat;
    private JTextField txt_defstat;
    private JTextField txt_hpstat;
    private JTextField txt_atkcost;
    private JTextField txt_defcost;
    private JTextField txt_healthcost;
    private JButton upgradeSword40Button;
    private JTextArea swordarea;
    private JButton continueButton;
    private JTextArea WELCOMETOTHESHOPTextArea;
    private JTextField currentStatsTextField;
    private JTextField noPotionsCarriedTextField;
    private JButton BUY_POTION_HEAL;
    private JTextField costTextField;
    private JTextField costTextField1;

    public MENU_Shop(player playerx) {

        /**
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
         */
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //if (!battlex.get_isfighting_win()) {
                //    update_battlelog("you leave the room");
                //    //datstat = "c";
                //}
                //else{
                //    System.out.println("currently fighting to leave the room please run away!");
                //}

            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //if (!battlex.get_isfighting_win()) {
                //    update_battlelog("you leave the room");
                //    //datstat = "c";
                //}
                //else{
                //    System.out.println("currently fighting to leave the room please run away!");
                //}

            }
        });
    }

}
/**
 * continueButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
if (!battlex.get_isfighting_win()) {
update_battlelog("you leave the room");
//datstat = "c";
}
else{
System.out.println("currently fighting to leave the room please run away!");
}

}
});
 */
