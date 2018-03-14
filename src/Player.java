package src;

public class Player {
    private String name;
    private int score;
    private int position;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.position = -1;
    }

    public void calculateAndSetScore(int time){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
