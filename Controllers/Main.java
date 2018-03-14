package Controllers;

import java.util.ArrayList;

import javafx.application.Application;
import src.GameConfig;

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

	public static void setUpPins() {

		pinsList.add(new Pins(1, 0, 0, pinsValues[0]));
		pinsList.add(new Pins(2, 0, 0,  pinsValues[1]));
		pinsList.add(new Pins(3, 0, 0,  pinsValues[2]));
		pinsList.add(new Pins(4, 0, 0,  pinsValues[3]));
		pinsList.add(new Pins(5, 0, 0,  pinsValues[4]));
	}
	public static void reset() {
		pinsList.clear();
		main = null;
		solution = 0;
		noInputs = 0;
		userInput = null;
		inputEntered = 0;
		numberShot = 1;
		isNewInput = false;
		pinsValues = new int[5];
	}
	

	public static void setup(GameConfig config) {
		inputEntered = 0;
		
		ProblemGenerator.setUp();
		noInputs = config.getNoOfInputs();
		numberShot = 1;
		main = new ArduinoInput();
		main.initialize();
		// getting maximum light values
		main.setState("setup");
		// setup problem generator
		switch(config.getType()) {
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
			main.close();
			reset();
		}

		

	}
	//get new input, most recent input
	public static int getNewInput() {
		isNewInput = false;
		return numberShot;
	}
	
	public static boolean newInput() {
		return isNewInput;
	}
	public static int getSolution(){
		return solution;
	}


	
	public static int[] getPinValues(){
		return pinsValues;
	}
}
