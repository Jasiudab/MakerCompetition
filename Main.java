import java.util.ArrayList;

public class Main {
	static ArrayList<Pins> pinsList = new ArrayList<Pins>();

	public Main() {
		// setup problem generator
		ProblemGenerator.setUp();

		// setup pins maximum light values
		ArduinoInput main = new ArduinoInput();
		main.initialize();
		// getting maximum light values
		main.mode = "setup";
		Thread t = new Thread() {
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
				}
			}
		};
		t.start();
		try {
			t.join();
		} catch (Exception e) {
		}

		// run the thing
		main.mode = "run";
		// run
		Thread t2 = new Thread() {
			public void run() {
				while (true)
					;
			}
		};
		t2.start();
		// run game logic
		textBasedGame();

		try {
			t2.join();
		} catch (Exception e) {
		}

		// end
		System.exit(0);
	}

	public void setUpPins() {

		pinsList.add(new Pins(1, 0, 0, 1));
		pinsList.add(new Pins(2, 0, 0, 2));
		pinsList.add(new Pins(3, 0, 0, 3));
		pinsList.add(new Pins(4, 0, 0, 4));
		pinsList.add(new Pins(5, 0, 0, 5));
	}

	public void textBasedGame() {
		System.out.println("asdf");
		while (true) {

		}
	}

	public static void main(String[] args) {
		new Main();
	}
}
