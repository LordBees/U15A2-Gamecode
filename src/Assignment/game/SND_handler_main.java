package Assignment.game;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Created by Spartan 2 on 2017-05-25.
 */
public class SND_handler_main {
    //public class Sound {
    //clip
    private Clip clipsnd;

    private String sndpath = "\\res\\snd\\";
    private boolean isplaying = false;
    private boolean isbgm = false;
    private String filen = "";
    private String lfilen = "";//last filename

    //SND_handler_main(String Xfile,boolean xisbgm) {
    public void load(String Xfile,boolean xisbgm){

        if (this.lfilen.equals(Xfile)&&(this.isbgm = xisbgm)){//no point in reloading if state same
            System.out.println("skipped loading as args same");
        }
        else {
            //if(clipsnd.isRunning()) {
            //    this.clipsnd.stop();
            //    this.clipsnd.flush();
            //}

            this.isbgm = xisbgm;
            this.lfilen = this.filen;
            this.filen = Xfile;


            try {
                String current = new java.io.File(".").getCanonicalPath();
                System.out.println(current + "\\res\\" + Xfile);
                File file = new File(current + "\\res\\" + Xfile);
                if (file.exists()) {
                    Clip clipsnd = AudioSystem.getClip();
                    AudioInputStream ais = AudioSystem.getAudioInputStream(file.toURI().toURL());
                    clipsnd.open(ais);
                    this.clipsnd = clipsnd;
                } else {
                    throw new RuntimeException("Sound: file not found: " + Xfile);
                }
            } catch (MalformedURLException e) {
                throw new RuntimeException("Sound: Malformed URL: " + e);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException("Sound: Unsupported Audio File: " + e);
            } catch (IOException e) {
                throw new RuntimeException("Sound: Input/Output Error: " + e);
            } catch (LineUnavailableException e) {
                throw new RuntimeException("Sound: Line Unavailable: " + e);
            }
        }
    }
    public String resolvename(){
        return this.sndpath+this.filen;//test
    }

    public void play(){
        //this.isplaying = true
        clipsnd.setFramePosition(0);  // Must always rewind!
        if (this.isbgm) {
            clipsnd.loop(-1);
        }
        clipsnd.start();
    }
    public void looptimes(int xtimes){
        clipsnd.loop(xtimes);
    }
    public void stop(){
        clipsnd.stop();
    }
    public boolean issameas(String newtrk){
        if (filen.equals(newtrk)){
            return true;
        }
        else {
            return false;
        }
    }
}

