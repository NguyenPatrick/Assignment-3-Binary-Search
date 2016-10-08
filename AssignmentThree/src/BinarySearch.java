/****************************************************************************
*
* Created by: Patrick Nguyen
* Created on: October 2016
* This Program Sorts An Unsorted List of Integers Within an Array And Asks 
* The User Which Number They Want to Find The Position of. Then It Finds
* The Position(s) (If The Number Exists Within The Array).
*
****************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BinarySearch {
	
	// global constants to make it easier to change values when needed
	static final int NUMBER_OF_VALUES = 250; // number of array elements	
	static final int MAX_NUMBER_GENERATED = 1000; // max random number generated
	
	
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
	
	// procedure to find the position of a certain number inside the sorted list of numbers
	public static void SearchNumber(int[] sortedArray, int numberToFind){
		
		Boolean positionFound = false; // in case the numberToFind is not in the list
		int positionOfNumber = 0;
					
		 for(int counter = 0; counter < (sortedArray.length); counter++)
		 {
			 if (sortedArray[counter] == numberToFind)
			 {
				 positionOfNumber = counter + 1;
				 System.out.println("Your Number Was Found At Position: " + positionOfNumber);
				 positionFound = true;
			 }				  		       	  
		 }		
		 
		 if (positionFound.equals(false))
		 {
			 System.out.println("Your Number Could Not Be Found!");	
		 }				 
		 System.out.println("");	
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

		System.out.println(Arrays.toString(randomNumberArray)); // prints unsorted array values in one line
		 	 
		orderedNumberArray = OrderNumbers(randomNumberArray); // goes to function to sort values
		System.out.println(Arrays.toString(orderedNumberArray)); // prints sorted array values in one line
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
					SearchNumber(orderedNumberArray, numberToBeFound); // procedure to find value
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