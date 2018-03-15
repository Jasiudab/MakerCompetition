package src;

import javafx.scene.media.AudioClip;

import java.nio.file.Paths;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Music
{
    public static AudioClip introMusic;
    public static AudioClip transitionMusic;
    public static AudioClip intenseMusic;

    public static void playIntroMusic()
    {
        introMusic = new AudioClip(Paths.get("src/introMusic.mp3").toUri().toString());
        introMusic.setCycleCount(INDEFINITE);
        introMusic.play();
    }

    public static void playTransitionMusic()
    {
        introMusic = new AudioClip(Paths.get("src/music.mp3").toUri().toString());
        introMusic.setCycleCount(INDEFINITE);
        introMusic.play();
    }

    public static void playIntenseMusic()
    {
        introMusic = new AudioClip(Paths.get("src/music.mp3").toUri().toString());
        introMusic.setCycleCount(INDEFINITE);
        introMusic.play();
    }
}