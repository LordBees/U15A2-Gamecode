package Assignment.game;

import Assignment.game.Ents.ENT_enemy_easy;

import javax.swing.*;

public class FORMTEST_MAIN {

    public static void main(String[] args) {
	// write your code here
        //Gameloop gamex = new Gameloop();
        //gamex.run();
        /**
        JFrame frame = new JFrame("Test");
        frame.setContentPane(new MENU_HOW2().Menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

         JFrame frame =new JFrame("MENU_SHOP");
         frame.setContentPane(new MENU_Shop());
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
         */

        //JFrame windowFrame = new JFrame("SHOP");
        //windowFrame.setVisible(true);
        //MENU_Shop form = new MENU_Shop();
        //windowFrame.setContentPane(form.gameScreenPanel);
        //windowFrame.pack();
        //windowFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JFrame windowFrame_FI = new JFrame("FIGHT");
        windowFrame_FI.setVisible(true);
        MENU_Fight form_fi = new MENU_Fight(new fight(new player(),new ENT_enemy_easy()));
        windowFrame_FI.setContentPane(form_fi.gameScreenPanel);
        windowFrame_FI.pack();
        windowFrame_FI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        windowFrame_FI.setLocationRelativeTo(null);

        JFrame windowFrame_GO = new JFrame("gameover");
        windowFrame_GO.setVisible(true);
        MENU_GameOver form_go = new MENU_GameOver();
        windowFrame_GO.setContentPane(form_go.gameScreenPanel);
        windowFrame_GO.pack();
        windowFrame_GO.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JFrame windowFrame_h2 = new JFrame("how2");
        windowFrame_h2.setVisible(true);
        MENU_HOW2 form_h2 = new MENU_HOW2();
        windowFrame_h2.setContentPane(form_h2.gameScreenPanel);
        windowFrame_h2.pack();
        windowFrame_h2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JFrame windowFrame_lb = new JFrame("lorb");
        windowFrame_lb.setVisible(true);
        MENU_LootOrBlank form_lb = new MENU_LootOrBlank(0);
        windowFrame_lb.setContentPane(form_lb.gameScreenPanel);
        windowFrame_lb.pack();
        windowFrame_lb.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JFrame windowFrame_mm = new JFrame("main");
        windowFrame_mm.setVisible(true);
        MENU_MainMenu form_mm = new MENU_MainMenu("a",new player());
        windowFrame_mm.setContentPane(form_mm.gameScreenPanel);
        windowFrame_mm.pack();
        windowFrame_mm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JFrame windowFrame_sh = new JFrame("shop");
        windowFrame_sh.setVisible(true);
        MENU_Shop form_sh = new MENU_Shop(new player(),false);
        windowFrame_sh.setContentPane(form_sh.gameScreenPanel);
        windowFrame_sh.pack();
        windowFrame_sh.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        /**
         * public static void main(String[] args) {
         JFrame frame = new JFrame("<class name>");
         frame.setContentPane(new MENU_Shop().);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.pack();
         frame.setVisible(true);
         }
        */

    }
    /**
    public void createwin(String wname,Object win){
        JFrame windowFrame = new JFrame(wname);
        windowFrame.setVisible(true);
        MENU_Shop form;
        windowFrame.setContentPane(form.gameScreenPanel);
        windowFrame.pack();
        windowFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
     */
}
