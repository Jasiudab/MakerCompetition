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

	public static void setUpPins() {

		pinsList.add(new Pins(1, 0, 0, pinsValues[0]));
		pinsList.add(new Pins(2, 0, 0,  pinsValues[1]));
		pinsList.add(new Pins(3, 0, 0,  pinsValues[2]));
		pinsList.add(new Pins(4, 0, 0,  pinsValues[3]));
		pinsList.add(new Pins(5, 0, 0,  pinsValues[4]));
	}
	public static void changePinsValues() {
		pinsList.get(0).setCodeValue(pinsValues[0]);
		pinsList.get(1).setCodeValue(pinsValues[1]);
		pinsList.get(2).setCodeValue(pinsValues[2]);
		pinsList.get(3).setCodeValue(pinsValues[3]);
		pinsList.get(4).setCodeValue(pinsValues[4]);
		
	}
	public static void reset() {
		solution = 0;
		noInputs = 0;
		userInput = null;
		inputEntered = 0;
		numberShot = 1;
		isNewInput = false;
		pinsValues = new int[5];
	}
	public static void setUpInput() {
		main = new ArduinoInput();
		main.initialize();
		main.setState("setup");
		setUpPins();
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
		main.setState("silent");
	}
	public static void close() {
		main.close();
	}
	
	
	public static void setup(int n, String game) {
		inputEntered = 0;
		
		ProblemGenerator.setUp();
		noInputs = n;
		numberShot = 1;

		// getting maximum light values

		// setup problem generator
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


		userInput = new int[noInputs];
		changePinsValues();
		

		// run the thing
		main.setState("run");
		// run game logic

	}

	public static void recieveInput(int id) {
		int test = pinsList.get(id).getCodeValue();
			userInput[inputEntered] = test;
			inputEntered++;
			numberShot = test;
			isNewInput = true;
			
		

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
