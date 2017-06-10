package Assignment.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Created by Spartan 2 on 2017-05-19.
 */
public class MENU_MainMenu {
    public JPanel gameScreenPanel;

    private JButton howToPlayButton;
    private JButton startButton;
    private JTextArea welcomeToTheAdventureTextArea;
    private JLabel TPIC;


    private String gstat;

    public MENU_MainMenu(String gstat) {
        this.gstat = gstat;
        doimageprep();

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
    public void doimageprep(){
        //ImageIcon icon = createImageIcon("images/middle.gif");
        String Xfile = "ASCII_titlepic.png";
    try {
        String current = new java.io.File(".").getCanonicalPath();
        System.out.println(current + "\\res\\" + Xfile);
        //File file = new File(current + "\\res\\" + Xfile);


        System.out.println(getClass() + "/res/ASCII_titlepic.png");

        ImageIcon icon = new ImageIcon(current + "\\res\\" + Xfile);
        TPIC.setIcon(icon);

    }
    catch (Exception e){
        System.out.println("file not found:"+"\\res\\" + Xfile);
    }

    }
    public String getGstat(){
        return this.gstat;
    }
    public void setGstat(String gstat){
        this.gstat = gstat;
    }

    /**
    private void createUIComponents() {
        // TODO: place custom component creation code here
        JimageC
        JImageComponent ic = new JImageComponent(myImageGoesHere);
        imagePanel.add(ic);
    }
     */

}
