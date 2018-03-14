package Controllers;

public class Player {
	private int score;
	private String name;
	public Player(int score, String name){
		this.score = score;
		this.name = name;
		}
	public void addScore(int newScore ){
		score+=newScore;
	}
	public int getScore(){
		return score;
	}
	public String getName(){
		return name;
	}
}
