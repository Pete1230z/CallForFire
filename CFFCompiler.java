import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CFFCompiler {
	static int choice;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your position in MGRS Grid with your Grid Zone Designator: ");
		String MGRS = input.nextLine();
		System.out.println("Your position in MGRS Grid is" + " " + getMGRSFormat(MGRS));
		System.out.println("What is your method of target location?");
		System.out.println("1. Grid\n2. Polar\n3. Shift");
		int choice = getChoice(input);
		conductMission(choice);	
	}
    
	//Returns the value of the user input
	public static int getChoice(Scanner input) {
		int choice = 0;
		try {
			choice = input.nextInt();
		} catch(Exception ex) {
			System.out.println("This is not a valid selection");
		}
		return choice;
	}

	//Takes the value of choice and returns a string with the associated mission
	public static void conductMission(int choice) {
		if (choice == 1) {
			System.out.println("You are conducting a Grid Mission");
		} else if(choice == 2) {
			System.out.println("You are conducting a Polar Mission");
		} else if(choice == 3) {
			System.out.println("You are conducting a Shift Mission");
		}
	}
	
    //Converts MGRS Grid into a proper format
	public static String getMGRSFormat(String MGRS) {
		 int index = MGRS.length() / 2;
         String MGRSFront = MGRS.substring(0, index);
		 String MGRSBack = MGRS.substring(index);
		 String Space = " ";
		 return MGRSFront.toString() + Space + MGRSBack.toString();
	}
}

