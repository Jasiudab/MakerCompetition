package src;

import javafx.scene.media.AudioClip;

import java.nio.file.Paths;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Music
{
    private static AudioClip introMusic;
    private static AudioClip transitionMusic;
    private static AudioClip intenseMusic;
    private static AudioClip upliftingMusic;

    public static void playIntroMusic()
    {
        introMusic = new AudioClip(Paths.get("src/introMusic.wav").toUri().toString());
        introMusic.setCycleCount(INDEFINITE);
        introMusic.play();
    }

    public static void playTransitionMusic()
    {
        introMusic = new AudioClip(Paths.get("src/transitionMusic.wav").toUri().toString());
        introMusic.play();
    }

    public static void playIntenseMusic()
    {
        introMusic = new AudioClip(Paths.get("src/music.mp3").toUri().toString());
        introMusic.setCycleCount(INDEFINITE);
        introMusic.play();
    }

    public static void stopIntroMusic(){
        Music.introMusic.stop();
    }
}