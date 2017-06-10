package Assignment.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class MENU_LootOrBlank {
    public JPanel gameScreenPanel;

    private JButton continueButton;
    private JTextArea textArea1;
    private int gpickup;

    public MENU_LootOrBlank(int gpickup) {
        this.gpickup = gpickup;
        do_printing();

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void do_printing(){
        if(this.gpickup == 0){
            textArea1.setText("this is an empty room, please press continue to go to the next room");
        }
        else{
            textArea1.setText("you picked up +Gold:"+this.gpickup+"\n, please press continue to go to the next room");
        }
    }
}
