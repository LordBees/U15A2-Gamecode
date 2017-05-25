package Assignment.game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

public class Clip {


    private final AudioClip cl;

    public Clip(AudioClip c){
        this.cl = c;
    }

    public void play(){
        this.cl.play();
    }

    public void loop(){
        this.cl.loop();
    }

    public void stop(){
        this.cl.stop();
    }


    public static Clip load(String pos){
        try {
            File f = new File(pos);
            AudioClip clip = Applet.newAudioClip(f.toURL());
            Clip res = new Clip(clip);
            clip.play();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

