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
    private String storyx = "";
    //private String[] stancedata;
    //private int noheals;
    private SND_handler_main bgmx = new SND_handler_main();


    public  MENU_Fight(fight battlex) {
        this.battlex = battlex;
        bgmx.load("Battle.wav",true);
        bgmx.play();

        attackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (battlex.get_isfighting_win()) {
                    battlex.resolveturn_win("ATK");
                    //System.out.println("DATADstancedataC{:"+stancedata[0]+"::"+stancedata[1]+":}");

                    battlex.fighterloop_win();
                    update_fight(battlex.get_data2r());

                }
                else{
                    System.out.println("currently not fighting!");
                    update_battlelog("currently not fighting!");
                    if (battlex.get_wonfight()){
                        System.out.println("You Won!");
                        update_battlelog("You Won!!");
                    }
                }
            }
        });

        defendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (battlex.get_isfighting_win()) {
                    battlex.resolveturn_win("DEF");
                    battlex.fighterloop_win();
                    update_fight(battlex.get_data2r());
                }
                else{
                    System.out.println("currently not fighting!");
                    update_battlelog("currently not fighting!");
                    if (battlex.get_wonfight()){
                        System.out.println("You Won!");
                        update_battlelog("You Won!!");
                    }
                }

            }
        });

        healButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (battlex.get_isfighting_win()) {
                    battlex.resolveturn_win("HEAL");
                    battlex.fighterloop_win();
                    update_fight(battlex.get_data2r());
                }
                else{
                    System.out.println("currently not fighting!");
                    update_battlelog("currently not fighting!");
                    if (battlex.get_wonfight()){
                        System.out.println("You Won!");
                        update_battlelog("You Won!!");
                    }
                }

            }
        });

        runAwayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (battlex.get_isfighting_win()) {
                    battlex.resolveturn_win("RUN");
                    battlex.fighterloop_win();
                    update_fight(battlex.get_data2r());
                }
                else{
                System.out.println("currently not fighting!");
                    update_battlelog("currently not fighting!");

                }
            }
        });

        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!battlex.get_isfighting_win()) {
                    update_battlelog("you leave the room");
                    gameScreenPanel.setVisible(false);
                    bgmx.stop();
                    //datstat = "c";
                    //gameScreenPanel.setVisible(false);
                    //gameScreenPanel.setVisible(false);


                    //This is where our code runs when the button
                    // is clicked
                    //String story = theFight.TakeTurn("a");
                    //storyText.setText(story);
                    //Gameloop
                    //this.gstat
                    //setGstat("");

                    ///hack to get working
                    int scale;
                    player phero = new player();


                    Random RNGstat = new Random();
                    scale = RNGstat.nextInt(3);

                    JFrame windowFrame_FI = new JFrame("FIGHT");
                    windowFrame_FI.setVisible(true);
                    phero.addheal(3);//add 3 heals
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
                else{
                System.out.println("currently fighting, to leave the room please run away!");
                }

            }
        });

        /**
         ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        ///action case code
        //resolveturn_win()

        }
        };
         attackButton.addActionListener(listener);
         runAwayButton.addActionListener(listener);
         defendButton.addActionListener(listener);
         healButton.addActionListener(listener);
         continueButton.addActionListener(listener);



         attackButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        //This is where our code runs when the button
        // is clicked
        //String story = theFight.TakeTurn("a");
        //storyText.setText(story);
        //Gameloop
        battlex.resolveturn_win("ATK");



        }
        });

         }*/
    }
    public void update_battlelog(String nextx){
        System.out.println("DATA{:"+nextx+":}");
        this.storyx = this.storyx +nextx+ "\n";
        battletext_area.setText(this.storyx);
        //battletext_area.setText("TEST123");
    }
    public void update_fight(String[] dstat){
        System.out.println("DATADSTAT{:"+dstat[0]+"::"+dstat[1]+":}");
        update_battlelog("player HP:"+battlex.get_hpvalues_win()[0]);
        update_battlelog(battlex.get_fname_win()+" HP:"+battlex.get_hpvalues_win()[1]);
        switch (dstat[0]) {
            case "RUN":
                if (dstat[1].equals("ATK")) {
                    //System.out.println("you ran away and took some damage in the process...");
                    update_battlelog("you ran away and took some damage in the process...");
                } else {
                    update_battlelog("you ran away...");
                }
                //wonfight = false;
                //this.fighting = false;
                //break;

            case "ATK":
                //sfxclip.load("SFX_atk.wav", false);
                //sfxclip.play();
                switch (dstat[1]) {

                    case "ATK":
                        update_battlelog("you attacked the monster, it attacks you!");
                        //foe.do_attack(playerx);
                        //playerx.do_attack(foe);
                        //sfxclip.play();
                        break;

                    case "DEF":
                        update_battlelog("you attacked the monster!- it defended your attack!");
                        //playerx.do_attack(foe);
                        break;

                    case "HEAL":
                        update_battlelog("you attacked the monster,it tried to heal");
                        //playerx.do_attack(foe);
                        //foe.try_E_heal();
                        break;
                }


                break;
            case "DEF"://player defending
                switch (dstat[1]) {//monster options
                    case "ATK":
                        //foe.do_attack(playerx);
                        update_battlelog("you defended against the monsters attack!");
                        break;

                    case "DEF":
                        update_battlelog("you defended against the monster, it does the same!");
                        break;

                    case "HEAL":
                        update_battlelog("you healed while the monster helaed!");
                        //if (foe.getNum_heals() > +1) {//if can heal
                        //    foe.try_E_heal();
                        //} else {
                        //    update_battlelog("the monster failed to heal...");
                        //}
                        break;

                }
                break;
            case "HEAL":
                switch (dstat[1]) {//monster options
                    case "ATK":
                        update_battlelog("healed while the monster attacked!");
                        //playerx.try_heal();
                        //foe.do_attack(playerx);
                        break;

                    case "DEF":
                        update_battlelog("you try to heal, the monster tried to defend!");
                        //playerx.try_heal();
                        break;//no damage dealt

                    case "HEAL":
                        update_battlelog("You try to heal, the monster does the same");
                        //playerx.try_heal();
                        //if (foe.getNum_heals() > +1) {//if can heal
                        //    foe.try_E_heal();
                        //} else {
                        //    update_battlelog("the monster failed to heal...");
                        //}
                        break;
                }
                break;

        }
    }
}
