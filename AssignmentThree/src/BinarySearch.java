import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
	
	// holds the value of arrays so it is easier to change if needed
	static final int NUMBER_OF_VALUES = 250;	
	static final int MAX_NUMBER_GENERATED = 1000;	
	
	public static int[] OrderNumbers(int[] unsortedArray){
		
		int[] sortedArray = new int[NUMBER_OF_VALUES];
		int locationPlaceHolder = 0; 
		int maxValue = MAX_NUMBER_GENERATED;
		int minValue = 0;

				 
		 for(int counter = 0; counter < (unsortedArray.length); counter++)
		 {
			 for(int counter2 = 0; counter2 < (unsortedArray.length); counter2++)
	          {
	        	  		 
	        	 if (unsortedArray[counter2] < maxValue && unsortedArray[counter2] >= minValue)
			     {
					 maxValue = unsortedArray[counter2];
					 locationPlaceHolder = counter2;
				 }
			  }
			 
			  minValue = maxValue;
			  unsortedArray[locationPlaceHolder] = MAX_NUMBER_GENERATED + 1; // fills up the space of the array in order to look for duplicates of the same number
			  sortedArray[counter] = maxValue; 
			  maxValue = MAX_NUMBER_GENERATED;			  		       	  
		}
				
		return sortedArray;		
	}
	
	// procedure to find the position of a certain number inside the list
	public static void SearchNumber(int[] sortedArray, int numberToFind){
		
		int position; // for duplicates and worse case scenario, all numbers are the same
		Boolean positionFound = false;
					
		 for(int counter = 0; counter < (sortedArray.length); counter++)
		 {
			 if (sortedArray[counter] == numberToFind)
			 {
				 position = counter + 1;
				 System.out.println("Your number is at position: " + position);
				 positionFound = true;
			 }				  		       	  
		 }		
		 
		 if (positionFound.equals(false))
		 {
			 System.out.println("Your number is not on the list!");
		 }
		
	}
	
	
	public static void main(String args[])
	{
	
        Random randomNumber = new Random();	
        ArrayList<Integer> positionOfValues = new ArrayList<Integer>();
	    int[] randomNumberArray = new int[NUMBER_OF_VALUES];
	    int[] orderedNumberArray = new int[NUMBER_OF_VALUES];
	    
	    Scanner scan = new Scanner(System.in);
	    int numberToBeFound = 0;
	    
	    // randomize values
	    for(int counter = 0; counter < (randomNumberArray.length); counter++)
		{		 
			randomNumberArray[counter] =  randomNumber.nextInt(MAX_NUMBER_GENERATED) + 1;		
		}

		System.out.println(Arrays.toString(randomNumberArray)); // prints values in one line
		 	 
		orderedNumberArray = OrderNumbers(randomNumberArray);
		System.out.println(Arrays.toString(orderedNumberArray));
		 System.out.println("");
		
		while (true)
	 	{
		 System.out.println("Enter number from 1-1000 to find its position");
			if (scan.hasNextInt()){
				numberToBeFound = scan.nextInt();
				
				if ((numberToBeFound > 0) && (numberToBeFound < MAX_NUMBER_GENERATED))
				{
					SearchNumber(orderedNumberArray, numberToBeFound);
				}
				else
				{
					System.err.println("INVALID INPUT");

				}
			}
			else 
			{
				System.err.println("INVALID INPUT");
				break;
			}	    	 

					
		 }

	}
}