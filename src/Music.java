package src;

import javafx.scene.media.AudioClip;

import java.nio.file.Paths;
import java.util.ArrayList;

import static javafx.scene.media.MediaPlayer.INDEFINITE;

public class Music
{
    private static AudioClip introMusic = new AudioClip(Paths.get("src/introMusic.wav").toUri().toString());
    private static AudioClip transitionMusic = new AudioClip(Paths.get("src/transitionMusic.wav").toUri().toString());
    private static AudioClip intenseMusic = new AudioClip(Paths.get("src/intenseMusic.wav").toUri().toString());
    private static AudioClip pauseMusic = new AudioClip(Paths.get("src/pauseMusic.wav").toUri().toString());
    private static AudioClip laserShot = new AudioClip(Paths.get("src/laserShot.wav").toUri().toString());

    private static int pointer = 0;

    public static void shootLaser(){
        laserShot.play();
    }

    public static void playIntroMusic()
    {
        pointer = 1;
        introMusic.setCycleCount(INDEFINITE);
        introMusic.play();
    }

    public static void playTransitionMusic()
    {
        transitionMusic.play();
    }

    public static void playIntenseMusic()
    {
        pointer = 2;
        intenseMusic.setCycleCount(INDEFINITE);
        intenseMusic.play();
    }

    public static void playPauseMusic()
    {
        pointer = 3;
        pauseMusic.setCycleCount(INDEFINITE);
        pauseMusic.play();
    }

    public static void stopCurrentMusic(){
        switch (pointer){
            case 1: Music.stopIntroMusic();
            break;
            case 2: Music.stopIntenseMusic();
            break;
            case 3: Music.stopPauseMusic();
            break;
            default:
                System.out.println("Something went wrong with music...");
                break;
        }
        pointer = 0;
    }

    public static void stopIntroMusic(){
        Music.introMusic.stop();
    }

    public static void stopIntenseMusic(){
        Music.intenseMusic.stop();
    }

    public static void stopPauseMusic(){
        Music.pauseMusic.stop();
    }

    public static void changeToPause(){
        Music.stopCurrentMusic();
        Music.playTransitionMusic();
        Music.playPauseMusic();
    }

    public static void changeToIntense(){
        Music.stopPauseMusic();
        Music.playTransitionMusic();
        Music.playIntenseMusic();
    }

    public static void changeToIntro(){
        Music.stopPauseMusic();
        Music.playTransitionMusic();
        Music.playIntroMusic();
    }
}