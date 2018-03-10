package Controllers;

import java.util.ArrayList;

import javafx.application.Application;

//the main arduino input, states are 
	/*
	 * main.setState("setup"); - just used for setting up the light values
	 * main.setState("running"); - used for when waiting on player like to shoot the lights
	 * main.setState("silent"); - used for when in menus etc.
	 */

public class Main {
	public static ArrayList<Pins> pinsList = new ArrayList<Pins>(); //list of the pins, ie light sensors
	public static ArduinoInput main; 
	public static int solution;
	public static int noInputs;
	static int[] userInput;
	static int inputEntered = 0;
	static int numberShot = 1;
	static boolean isNewInput = false;
	static int[] pinsValues = new int[5];
	
	public Main(int n, String game) {
		ProblemGenerator.setUp();
		noInputs = n;
		main = new ArduinoInput();
		main.initialize();
		// getting maximum light values
		main.setState("setup");
		// setup problem generator
		setup(game); //setup the solution
		setUpPins(); //setup pins

		userInput = new int[noInputs];
		// setup pins maximum light values
		
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
		// run game logic

	}

	public void setUpPins() {

		pinsList.add(new Pins(1, 0, 0, pinsValues[0]));
		pinsList.add(new Pins(2, 0, 0,  pinsValues[1]));
		pinsList.add(new Pins(3, 0, 0,  pinsValues[2]));
		pinsList.add(new Pins(4, 0, 0,  pinsValues[3]));
		pinsList.add(new Pins(5, 0, 0,  pinsValues[4]));
	}

	public static void setup(String game) {
		switch(game) {
		case "multiplication": 

			solution = ProblemGenerator.generateMultiplicationProblem(noInputs); 
		for(int i = 0; i < pinsValues.length; i++) {
			pinsValues[i] = i + 1;
		}
			break;
		case "addition":
			int[] problem =  ProblemGenerator.generateAdditionProblem(noInputs);
			solution = problem[5];
			for(int i = 0; i < pinsValues.length; i++) {
				pinsValues[i] = problem[i];
				System.out.println(pinsValues[i]);
			}
		break;
		}

	}

	public static void recieveInput(int id) {
		int test = pinsList.get(id).getCodeValue();
		if(inputEntered < noInputs) {
			userInput[inputEntered] = test;
			inputEntered++;
			numberShot = test;
			isNewInput = true;
			
		}
		if(inputEntered == noInputs) {
			main.setState("silent");
		}

		

	}
	//get new input, most recent input
	public int getNewInput() {
		isNewInput = false;
		return numberShot;
	}
	
	public boolean newInput() {
		return isNewInput;
	}
	public int getSolution(){
		return solution;
	}


	
	public int[] getPinValues(){
		return pinsValues;
	}
}
