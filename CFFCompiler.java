import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CFFCompiler {
	static int choice;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your Grid Zone Designator: ");
		String GridZone = input.nextLine();
		System.out.print("Enter your position in MGRS Format: ");
		String MGRS = input.nextLine();
		System.out.println("Your position in MGRS Grid is" + " " + GridZone + " " + getMGRSFormat(MGRS));
		System.out.println("What is your type of mission?");
		System.out.println("1. Adjust Fire\n2. Fire For Effect\n3. Suppression\n4. Immediate Suppression\n5. Suppression of Enemy Air Defenses");
		System.out.print("Choose A Number: ");
		int missionNumber = getMissionNumber(input);
		getTypeOfMission(missionNumber);
		//When conductMission calls nextInt it does not read the entire line so we need to add an extra input.nextLine() to clear out the extra invisible characters
		input.nextLine();
		System.out.println("What is your method of target location?");
		System.out.println("1. Grid\n2. Polar\n3. Shift");
		System.out.print("Choose A Number: ");
		int choice = getChoice(input);
		conductMission(choice);	
		//When conductMission calls nextInt it does not read the entire line so we need to add an extra input.nextLine() to clear out the extra invisible characters
		input.nextLine();
		System.out.print("Enter enemy grid: ");
		String targetLocation = input.nextLine();
		System.out.println("Enemy position is" + " " + GridZone + " " + getTargetLocation(targetLocation));
		System.out.print("Enter target description: ");
		String targetDescription = input.nextLine();
		System.out.println("Target description is" + " " + targetDescription);
		System.out.print("How would you like to engage the target?");
		System.out.println("1. Type of Adjustment\n2. Danger Close\n3. Mark\n4. Trajectory\n5. Ammunition\n6. Distribution");
		System.out.print("Choose A Number: ");

		System.out.println("1. When Ready\n2. At My Command\n3. Cannot Observe\n4. Time on Target\n5. Time To Target\n6. Coordinated Illumination\n7. Continuous Illumination\n8. Cease Load\n9. Check Fire\n 10. Continuous Fire\n 11. Repeat\n12. Request Splash\n13. Do Not Load\n14. Duration");
		System.out.print("Choose A Number: ");
	}

	 //Converts MGRS Grid into a proper format
	 public static String getMGRSFormat(String MGRS) {
		int index = MGRS.length() / 2;
		String MGRSFront = MGRS.substring(0, index);
		String MGRSBack = MGRS.substring(index);
		String Space = " ";
		return MGRSFront.toString() + Space + MGRSBack.toString();
   }

   //Returns the value of the user input
	public static int getMissionNumber(Scanner input) {
		int missionNumber = 0;
		try {
			choice = input.nextInt();
		} catch(Exception ex) {
			System.out.println("This is not a valid selection");
		}
		return missionNumber;
	}

	//Takes the value of choice and returns a string with the associated mission
	public static void getTypeOfMission(int missionNumber) {
		if (missionNumber == 1) {
			System.out.println("You are conducting an Adjust Fire Mission");
		} else if(missionNumber == 2) {
			System.out.println("You are conducting a Fire For Effect");
		} else if(missionNumber == 3) {
			System.out.println("You are conducting a Suppression Mission");
		}  else if(missionNumber == 4) {
			System.out.println("You are conducting an Immediate Suppression Mission");
		} else if(missionNumber == 5) {
			System.out.println("You are conducting a Suppression of Enemy Air Defense");
		}
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
	public static String getTargetLocation(String targetLocation) {
		int index = targetLocation.length() / 2;
		String targetFront = targetLocation.substring(0, index);
		String targetBack = targetLocation.substring(index);
		String Space = " ";
		return targetFront.toString() + Space + targetBack.toString();
   }

   //Returns the value of the user input
	public static int getMethodEngagement(Scanner input) {
		int choice = 0;
		try {
			choice = input.nextInt();
		} catch(Exception ex) {
			System.out.println("This is not a valid selection");
		}
		return choice;
	}

	//Takes the value of choice and returns a string with the associated mission
	public static void methodEngagement(int choice) {
		if (choice == 1) {
			System.out.println("You are conducting a Grid Mission");
		} else if(choice == 2) {
			System.out.println("You are conducting a Polar Mission");
		} else if(choice == 3) {
			System.out.println("You are conducting a Shift Mission");
		}
	}


	
}

