
//grade system, number of non 1 values + 1, for example if its 12 with 3 inputs, then its 3 x 4 x 1, therefore grade 3 (2 inputs + 1)
//grade 4 would be 3 inputs 24, only way to make that with 3 inputs (0 - 5) would be 3 x 4 x 2, therefore grade 4
//this could be number of points
//starts from 1 because for example a number of 1` still gives 1 point. 

public class Main
{
	static int[] numbers = new int[500];
	static int index;
	static int leds;
	
	public Main()
	{
		leds = 5;
		index = 0;
		for(int a = 1; a <= leds; a++) {
			for(int b = 1; b <= leds; b++) {
				for(int c = 1; c <= leds; c++) {
					int number = a * b * c;
					boolean duplicate = false;
				for(int i = 0; i < index; i++) {
					if(numbers[i] == number) {
						duplicate = true;	
					}
				}
				if(!duplicate) 
					numbers[index++] = number;
				}
				
				}
		}
		for(int i = 0; i < index; i++) {
			System.out.println(numbers[i]);	
		}
	}
}