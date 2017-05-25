package Assignment.game;
//old


import java.io.File;
import java.applet.Applet;
import java.applet.AudioClip;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

/**
 * Created by 10740071 on 25/05/2017.
 */
public class SND_handler {
    //soundcode
    //path
    private String sndpath = "\\res\\snd\\";
    private boolean isplaying = false;
    private boolean isbgm = false;
    private String filen = "";
    private Clip clip;
    //
    SND_handler(String xfilen,boolean xisbgm) {
        //    String cwd = new java.io.File( "." ).getCanonicalPath();
        //    File f = new File(cwd+sndpath+xfile);

        this.isbgm = xisbgm;
        this.filen = xfilen;
        this.doloader();

    }
    private void doloader(){

        URL url = this.getClass().getClassLoader().getResource(this.filen);
        System.out.println(url);
        AudioInputStream audioIn;// = null;
        try {
            audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            ////this.clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            ////this.clip.open(audioIn);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void play_sound(){

        if (this.isbgm){
           // this.clip.loop(-1);
        }

    }
    //public void playbgm(){

    //}

    public void pausebgm(){

    }
    public void resumebgm(){

    }
    public void loadbgm(String bgmnam){

    }
    public boolean isplayingbgm(){
        return this.isplaying;
    }
}

//package com.atest2;

/**
 * Created by 10740071 on 16/05/2017.
 */
/**
        import java.io.*;
        import java.net.URL;
        import javax.sound.sampled.*;
        import javax.swing.*;

// To play sound using Clip, the process need to be alive.
// Hence, we use a Swing application.
public class SoundClipTest extends JFrame {

    // Constructor
    public SoundClipTest() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test Sound Clip");
        this.setSize(300, 200);
        this.setVisible(true);

        try {
            // Open an audio input stream.
            URL url = this.getClass().getClassLoader().getResource("test.wav");
            System.out.println(url);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            // Get a sound clip resource.
            Clip clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            clip.start();
            clip.loop(-1);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SoundClipTest();
    }
}
*/