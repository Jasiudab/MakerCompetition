import java.util.Random;

//this class returns the numbers necessary for the same
//and the solutions using static methods
//*******
//make sure to run setUp somewhere in main though before use


//grade system, number of non 1 values + 1, for example if its 12 with 3 inputs, then its 3 x 4 x 1, therefore grade 3 (2 inputs + 1)
//grade 4 would be 3 inputs 24, only way to make that with 3 inputs (0 - 5) would be 3 x 4 x 2, therefore grade 4
//this could be number of points
//starts from 1 because for example a number of 1` still gives 1 point. 

public class ProblemGenerator {
	static int[] multiplicationNumbers2 = new int[14];
	static int[] multiplicationNumbers3 = new int[30];
	static int[] multiplicationNumbers4 = new int[55];
	static int[] multiplicationNumbers5 = new int[91];
	static int index;
	static final int leds = 5;
	//GENERATE METHODS
	//Generate multiplication factors
	public static int generateMultiplicationProblem(int input) {
		Random rand = new Random();
		int number = 0;
		switch(input) {
		case 2:
			number = multiplicationNumbers2[rand.nextInt(multiplicationNumbers2.length)];
			break;
		case 3:
			number = multiplicationNumbers3[rand.nextInt(multiplicationNumbers3.length)];
			break;
		case 4:
			number = multiplicationNumbers4[rand.nextInt(multiplicationNumbers4.length)];
			break;
		case 5:
			number = multiplicationNumbers5[rand.nextInt(multiplicationNumbers5.length)];
			break;
		}
		
		
		return number;
	}
	
	//Generate multiplication solutions, ie factors
	public static boolean isMultiplicationSolution(int number[], int targetNumber) {
		int value = 1;
		for(int i = 0; i < number.length; i++) {
			value *= number[i]; 
		}
		if(value == targetNumber) {
			return true;
		}
		return false;
		
	}
	
	//generate addition problems
	//first element is the int[] valuesOfTheLeds, then its the target number, so first 0 - 4 is values of the leds, then target number
	//between 1 and 50
	public static int[] generateAdditionProblem(int input) {
		Random rand = new Random();
		int[] valuesOfLeds = {rand.nextInt(20) + 1, rand.nextInt(20) + 1, rand.nextInt(20) + 1, rand.nextInt(20) + 1, 
				rand.nextInt(50) + 1};

		int number = 0;
		switch(input) {
		case 2:
			number += valuesOfLeds[rand.nextInt(leds)] +  valuesOfLeds[rand.nextInt(leds)];
			break;
		case 3:
			number += valuesOfLeds[rand.nextInt(leds)] +  valuesOfLeds[rand.nextInt(leds)] +  valuesOfLeds[rand.nextInt(leds)];
			break;
		case 4:
			number +=  valuesOfLeds[rand.nextInt(leds)] +  valuesOfLeds[rand.nextInt(leds)] +  
					valuesOfLeds[rand.nextInt(leds)] +  valuesOfLeds[rand.nextInt(leds)];
			break;
		case 5:
			number +=  valuesOfLeds[rand.nextInt(leds)] +  valuesOfLeds[rand.nextInt(leds)] +  valuesOfLeds[rand.nextInt(leds)] + 
					 valuesOfLeds[rand.nextInt(leds)] +  valuesOfLeds[rand.nextInt(leds)];
			break;
		}
		
		int[] ret = {valuesOfLeds[0], valuesOfLeds[1], valuesOfLeds[2], valuesOfLeds[3], valuesOfLeds[4], number};
		return ret;
	}
	//Generate addition solutions, ie factors
		public static boolean isAdditionSolution(int number[], int targetNumber) {
			int value = 0;
			for(int i = 0; i < number.length; i++) {
				value += number[i]; 
			}
			if(value == targetNumber) {
				return true;
			}
			return false;
			
		}
	
	
	
	
	
	//SETUP METHODS
	static void setUp() {
		// setup all the arrays
		// for multiplication
		setUp2Input();
		setUp3Input();
		setUp4Input();
		setUp5Input();
	}

	static void setUp2Input() {
		index = 0;
		for (int a = 1; a <= leds; a++) {
			for (int b = 1; b <= leds; b++) {
				int number = a * b;
				boolean duplicate = false;
				for (int i = 0; i < index; i++) {
					if (multiplicationNumbers2[i] == number) {
						duplicate = true;
					}
				}
				if (!duplicate)
					multiplicationNumbers2[index++] = number;
			}

		}
	}

	static void setUp3Input() {
		index = 0;
		for (int a = 1; a <= leds; a++) {
			for (int b = 1; b <= leds; b++) {
				for (int c = 1; c <= leds; c++) {
					int number = a * b * c;
					boolean duplicate = false;
					for (int i = 0; i < index; i++) {
						if (multiplicationNumbers3[i] == number) {
							duplicate = true;
						}
					}
					if (!duplicate)
						multiplicationNumbers3[index++] = number;
				}

			}
		}
	}

	static void setUp4Input() {
		index = 0;
		for (int a = 1; a <= leds; a++) {
			for (int b = 1; b <= leds; b++) {
				for (int c = 1; c <= leds; c++) {
					for (int d = 1; d <= leds; d++) {
						int number = a * b * c * d;
						boolean duplicate = false;
						for (int i = 0; i < index; i++) {
							if (multiplicationNumbers4[i] == number) {
								duplicate = true;
							}
						}
						if (!duplicate)
							multiplicationNumbers4[index++] = number;
					}

				}
			}
		}
	}

	static void setUp5Input() {
		index = 0;
		for (int a = 1; a <= leds; a++) {
			for (int b = 1; b <= leds; b++) {
				for (int c = 1; c <= leds; c++) {
					for (int d = 1; d <= leds; d++) {
						for (int e = 1; e <= leds; e++) {
							int number = a * b * c * d * e;
							boolean duplicate = false;
							for (int i = 0; i < index; i++) {
								if (multiplicationNumbers5[i] == number) {
									duplicate = true;
								}
							}
							if (!duplicate)
								multiplicationNumbers5[index++] = number;
						}
					}
				}
			}
		}
	}
}