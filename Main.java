import java.util.ArrayList;

//the main arduino input, states are 
	/*
	 * main.setState("setup"); - just used for setting up the light values
	 * main.setState("running"); - used for when waiting on player like to shoot the lights
	 * main.setState("silent"); - used for when in menus etc.
	 */

public class Main {
	public static ArrayList<Pins> pinsList = new ArrayList<Pins>(); //list of the pins, ie light sensors
	public static ArduinoInput main; 
	public Main() {
		// setup problem generator
		setUpPins(); //setup pins
		ProblemGenerator.setUp();

		// setup pins maximum light values
		main = new ArduinoInput();
		main.initialize();
		// getting maximum light values
		main.setState("setup");
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
		main.setState("run");
		// run
		Thread t2 = new Thread() {
			public void run() {
				while (true)
					;
			}
		};
		t2.start();
		// run game logic
		textBasedSetup();

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
	static int[] userInput = new int[2];
	static int inputEntered = 0;
	public static void textBasedSetup() {
		main.setState("silent");
		int player1Score = 0;
		int player2Score = 0;
		System.out.println("Ready player 1 ?....");
		main.setState("run");

	}
	public static void accept() {
		System.out.println("Finished");
		main.setState("silent");
		//textBasedSetup();
	}
	public static void recieveInput(int input) {
		//test = true;
		System.out.println(main.getState());
		if(inputEntered < 1) {
			userInput[inputEntered] = input;
			inputEntered++;
		
		}
		else {
			accept();
		}
		/*if(inputEntered ==2){
			int tmp = 1;
			for (int i = 0; i<2;i++){
				tmp = tmp*userInput[i];
			}
			System.out.println(tmp);
		}*/
	}

	public static void main(String[] args) {
		new Main();
	}
}
