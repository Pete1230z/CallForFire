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
		String YourGridZone = input.nextLine();
		System.out.print("Enter your position in MGRS Format: ");
		String MGRS = input.nextLine();
		System.out.println("Your position in MGRS Grid is" + " " + YourGridZone + " " + getMGRSFormat(MGRS));
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
		//Check to see if it is a Polar or Shift Mission
		
		//When conductMission calls nextInt it does not read the entire line so we need to add an extra input.nextLine() to clear out the extra invisible characters
		input.nextLine();
		System.out.print("Enter target description: ");
		String targetDescription = input.nextLine();
		System.out.println("Target description is" + " " + targetDescription);
		System.out.print("How would you like to engage the target? (Optional)");
		System.out.println("\n1. NA\n2. Type of Adjustment\n3. Danger Close\n34 Mark\n5. Trajectory\n6. Ammunition\n7. Distribution");
		System.out.print("Choose A Number: ");
		int engagement = getMethodEngagement(input);
		methodEngagement(engagement);
		//When conductMission calls nextInt it does not read the entire line so we need to add an extra input.nextLine() to clear out the extra invisible characters
		input.nextLine();
		System.out.println("1. When Ready\n2. At My Command\n3. Cannot Observe\n4. Time on Target\n5. Time To Target\n6. Coordinated Illumination\n7. Continuous Illumination\n8. Cease Load\n9. Check Fire\n10. Continuous Fire\n11. Repeat\n12. Request Splash\n13. Do Not Load\n14. Duration");
		System.out.print("Choose A Number: ");
		int fire = getFireControl(input);
		methodFireControl(fire);
		//When conductMission calls nextInt it does not read the entire line so we need to add an extra input.nextLine() to clear out the extra invisible characters
		input.nextLine();
		
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
			Scanner input = new Scanner(System.in);
			System.out.print("Enter Enemy Grid Zone Designator: ");
	        String EnemyGridZone = input.nextLine();
	        System.out.print("Enter enemy grid: ");
	        String targetLocation = input.nextLine();
	        System.out.println("Enemy position is" + " " + EnemyGridZone + " " + getTargetLocation(targetLocation));
		} else if(choice == 2) {
			System.out.println("Polar is your method of target location");
		} else if(choice == 3) {
			System.out.println("Shift is your method of target location");
		}
	}

	//Format Target Location
	public static String getTargetLocation(String targetLocation) {
		int index = targetLocation.length() / 2;
		String targetFront = targetLocation.substring(0, index);
		String targetBack = targetLocation.substring(index);
		String Space = " ";
		return targetFront.toString() + Space + targetBack.toString();
   }

   public static String ifgridMission(Scanner input, String gridMission) {
		System.out.print("Enter Enemy Grid Zone Designator: ");
	    String EnemyGridZone = input.nextLine();
	    System.out.print("Enter enemy grid: ");
	    String targetLocation = input.nextLine();
	    System.out.print(targetLocation);
	    gridMission = "Enemy position is" + " " + EnemyGridZone + " " + getTargetLocation(targetLocation);
		return gridMission;
   }

   //Returns the value of the user input
	public static int getMethodEngagement(Scanner input) {
		int engagement = 0;
		try {
			engagement = input.nextInt();
		} catch(Exception ex) {
			System.out.println("This is not a valid selection");
		}
		return engagement;
	}

	//Takes the value of engagement and returns a string with the associated mission
	public static void methodEngagement(int engagement) {
		if (engagement == 1) {
			System.out.println("Grid is your method of target location");
		} else if(engagement == 2) {
			System.out.println("Polar is your method of target location");
		} else if(engagement == 3) {
			System.out.println("Shift is your method of target location");
		}
	}

	//Returns the value of the user input
	public static int getFireControl(Scanner input) {
		int fire = 0;
		try {
			fire = input.nextInt();
		} catch(Exception ex) {
			System.out.println("This is not a valid selection");
		}
		return fire;
	}

	//Takes the value of engagement and returns a string with the associated mission
	public static void methodFireControl(int fire) {
		if (fire == 1) {
			System.out.println("Grid is your method of target location");
		} else if(fire == 2) {
			System.out.println("Polar is your method of target location");
		} else if(fire == 3) {
			System.out.println("Shift is your method of target location");
		}
	}



	
}

