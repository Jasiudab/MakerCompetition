package Controllers;

public class Player implements Comparable<Player>  {

	private int score;
	private String name;
	private int position;

	public Player(int score, String name) {
		this.score = score;
		this.name = name;
		this.position = 0;
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

	public void setScore(int score) {
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public int compareTo(Player player) {
		return Integer.compare(this.score, player.score);
	}

	@Override
	public String toString() {
		return "Player{" +
				"score=" + score +
				", name='" + name + '\'' +
				", position=" + position +
				'}';
	}
}
