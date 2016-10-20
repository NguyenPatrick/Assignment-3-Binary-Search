/****************************************************************************
*
* Created by: Patrick Nguyen
* Created on: October 2016
* This Program Sorts An Unsorted List of Integers Within an Array And Asks 
* The User Which Number They Want to Find The Position of. Then It Finds
* The Position(s) (If The Number Exists Within The Array).
* Bonus: Add New Value To List & Sort It
*
****************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
	
	// global constants to make it easier to change values when needed
	static int NUMBER_OF_VALUES = 250; // number of array elements	
	static int MAX_NUMBER_GENERATED = 1000; // max random number generated
	
	
	// function sorts the values of an int array from lowest to highest then returns to sorted array
	public static int[] OrderNumbers(int[] unsortedArray){
		
		int[] sortedArray = new int[NUMBER_OF_VALUES];
		int maxValue = MAX_NUMBER_GENERATED; // highest possible random number
		int minValue = 0; // lowest possible random number
		int locationPlaceHolder = 0; // to account for duplicate numbers
			 
		 for(int counter = 0; counter < (unsortedArray.length); counter++)
		 {
			 // loops through entire array to find the lowest value
			 for(int counter2 = 0; counter2 < (unsortedArray.length); counter2++)
	         {
				 if (unsortedArray[counter2] < maxValue && unsortedArray[counter2] >= minValue)
			     {
					 maxValue = unsortedArray[counter2];
					 locationPlaceHolder = counter2;
				 }	        	  		 	        	
			  }
			 			 
			  minValue = maxValue; // changes the lowest value
			  // fills up an element in the array in order look for duplicates of the same number
			  unsortedArray[locationPlaceHolder] = MAX_NUMBER_GENERATED + 1; 
			  sortedArray[counter] = maxValue; 
			  maxValue = MAX_NUMBER_GENERATED; // resets maxValue       	  
		}
				
		return sortedArray;		
	}

	// function to execute the binary search algorithm and find the position of an entered number
	public static int binarySearch(int[] sortedArray, int numberToFind) 
	{
		int lowValue = 0;
		int highValue = sortedArray.length;
		int midValue;
		    
		 while (lowValue <= highValue) 
		 {
			 midValue = (lowValue + highValue) / 2;
			 
			 if (sortedArray[midValue] > numberToFind) 
			 {
				 highValue = midValue - 1;
			 } 
			 else if (sortedArray[midValue] < numberToFind) 
			 {
				 lowValue = midValue + 1;
		     } 
			 else 
			 {
		         return midValue + 1; // Add 1 b/c first element in an array is at element 0;
		     }
	      }
		   return -1; // indicates value is not found      		       
	}

	public static void main(String args[])
	{
		// imported components
        Random randomNumber = new Random();		    
	    Scanner scan = new Scanner(System.in);
	    
        // arrays & variables
	    int[] randomNumberArray = new int[NUMBER_OF_VALUES];
	    int[] orderedNumberArray = new int[NUMBER_OF_VALUES];
	    int numberToBeFound = 0;
	    
	    // randomize values in array
	    for(int counter = 0; counter < (randomNumberArray.length); counter++)
		{		 
			randomNumberArray[counter] =  randomNumber.nextInt(MAX_NUMBER_GENERATED) + 1;		
		}

		System.out.println("Random List of Numbers: " + Arrays.toString(randomNumberArray)); // prints unsorted array values in one line		 	 
		orderedNumberArray = OrderNumbers(randomNumberArray); // goes to function to sort values
		System.out.println("Sorted List of Numbers: " + Arrays.toString(orderedNumberArray)); // prints sorted array values in one line
		System.out.println("");	
		
		while (true)
	 	{
	        System.out.println("Enter Any Number From 1-1000 To Find Its Position!");	        

			// restricts input to only integers
			if (scan.hasNextInt())
			{
				numberToBeFound = scan.nextInt();
				 
				// restricts values to only within range of random numbers
				if ((numberToBeFound > 0) && (numberToBeFound <= MAX_NUMBER_GENERATED))
				{
					System.out.println("Your Value: " + numberToBeFound + " Was Found At Position: " + 
							binarySearch(orderedNumberArray, numberToBeFound)); // gets position
					System.out.println("");	
	
					
					// lets user add another number to list & finds position (bonus 4+)
					System.out.println("Enter Any Number From 1-1000 To Add To The List!");					
					
					// asks for input again and restricts it to an int
					if (scan.hasNextInt())
					{
						numberToBeFound = scan.nextInt();
						
						// shows user list of numbers before adding number
					    System.out.println("Sorted List of Numbers: " + Arrays.toString(orderedNumberArray)); 
					    
					    // increasing size of the array
						orderedNumberArray = Arrays.copyOf(orderedNumberArray, orderedNumberArray.length + 1);						
						NUMBER_OF_VALUES = NUMBER_OF_VALUES + 1;							
						orderedNumberArray[NUMBER_OF_VALUES - 1] = numberToBeFound; // adds number to end of array
						
						orderedNumberArray = OrderNumbers(orderedNumberArray); // orders array
						// shows user list of numbers after adding number						
						System.out.println("Sorted List of Numbers + Added Number: " + Arrays.toString(orderedNumberArray)); 
						System.out.println("Your Value: " + numberToBeFound + " Was Found At Position: " + 
								binarySearch(orderedNumberArray, numberToBeFound));	// gets position	
						System.out.println("");	
					}
					else 
					{
						System.err.println("INVALID INPUT! NOT AN INT!");
					    break; // or else the program runs in an infinite loop
					}		
				}
				else
				{
			        System.out.println("INVALID INPUT! NOT AN INT FROM 1-1000!");	
				}
		    }		 
			else 
			{
				System.err.println("INVALID INPUT! NOT AN INT!");
			    break; // or else the program runs in an infinite loop
			}		
		}							
	}
}
