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
    private JTextField txt_potionstat;
    private JTextField txt_potioncost;
    private JTextField PC_GOLD;


    //
    protected player playerxtemp;
    protected boolean isboss;

    protected int price_atk = 0;
    protected int price_def = 0;
    protected int price_health = 0;
    protected int price_potion = 0;
    
    public MENU_Shop(player playerx,boolean isboss) {
        this.playerxtemp = playerx;
        this.isboss = isboss;
        setprices(isboss);
        updateboxes();


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
        //init


        ///

        BUY_ATK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerxtemp.canafford(price_atk)){
                    //buy
                    playerxtemp.addto_atk(1);
                    playerxtemp.spend_gold(price_atk);
                    System.out.println("you bought:attack increase!");
                }
                else{
                    System.out.println("you cannot afford this item(atk++)");

                }
                updateboxes();

            }
        });

        BUY_DEF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerxtemp.canafford(price_def)){
                    //buy
                    playerxtemp.addto_def(1);
                    playerxtemp.spend_gold(price_def);
                    System.out.println("you bought:defence increase!");
                }
                else{
                    System.out.println("you cannot afford this item(Def++)");

                }
                updateboxes();
            }
        });
        BUY_HEALTH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerxtemp.canafford(price_health)){
                    //buy
                    playerxtemp.set_addtohmax(10);
                    playerxtemp.addto_health(10);
                    playerxtemp.spend_gold(price_health);
                    System.out.println("you bought:health +10 increase!");
                }
                else{
                    System.out.println("you cannot afford this item(health+10)");
                }
                updateboxes();
            }
        });
        BUY_POTION_HEAL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerxtemp.canafford(price_potion)){
                    //buy
                    playerxtemp.addheal(1);
                    playerxtemp.spend_gold(price_potion);
                    System.out.println("you bought:a health potion!");
                }
                else{
                    System.out.println("you cannot afford this item(health potion+1)");
                }
                updateboxes();
            }
        });

        upgradeSword40Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(playerxtemp.canafford(40)){
                    //buy
                    if (false){// hack //(playerxtemp.get_invbyslot(1).equals("SuperSword")){
                        System.out.println("you already have the sword!!");
                    }
                    else {
                        playerxtemp.addsword();//quick add
                        playerxtemp.spend_gold(40);
                        System.out.println("you bought:the super sword!");
                    }
                }
                else{
                    System.out.println("you cannot afford this item(Sword)");
                }
                updateboxes();
            }
        });
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public void updateboxes(){
        this.txt_atkstat.setText(""+this.playerxtemp.getatk());
        this.txt_defstat.setText(""+this.playerxtemp.getDef());
        this.txt_hpstat.setText(""+this.playerxtemp.getHealth());
        this.txt_potionstat.setText(""+this.playerxtemp.getNum_heals());

        this.txt_atkcost.setText(""+this.price_atk);
        this.txt_defcost.setText(""+this.price_def);
        this.txt_healthcost.setText(""+this.price_health);
        this.txt_potioncost.setText(""+this.price_potion);

        this.PC_GOLD.setText(""+this.playerxtemp.getmoney());

    }
    public void setprices(boolean bshop){
        if (bshop){
            this.price_atk = 6;
            this.price_def = 10;
            this.price_health = 13;
            this.price_potion = 4;
        }
        else {
            this.price_atk = 14;
            this.price_def = 12;
            this.price_health = 15;
            this.price_potion = 7;
            //this.txt_swordcost.setText("40");

        }
    }
    public player updateplayerfromshop(){
        return this.playerxtemp;
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
