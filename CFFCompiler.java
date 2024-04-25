import java.util.Scanner;

public class CFFCompiler {
	//Putting these variables here makes them accessible within the class
	static int choice;
	private static String EnemyGridZone;
	private static String targetLocation;
	private static String distanceToTarget;
	private static String directionToTarget;
	private static String knownPoint;
	private static String directionNewTarget;
	private static String leftRight;
	private static String addDrop;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your Grid Zone Designator: ");
		String YourGridZone = input.nextLine();
		System.out.print("Enter your position in MGRS Format: ");
		String MGRS = input.nextLine();
		System.out.print("Enter your Call Sign: ");
		String callSign = input.nextLine();
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
		//When conductMission calls nextInt it does not read the entire line so we need to add an extra input.nextLine() to clear out the extra invisible characters
		input.nextLine();
		System.out.print("Enter target description: ");
		String targetDescription = input.nextLine();
		System.out.println("Target description is" + " " + targetDescription);
		System.out.print("How would you like to engage the target? (Optional)");
		System.out.println("\n1. NA\n2. Type of Adjustment\n3. Danger Close\n4. Mark\n5. Trajectory\n6. Ammunition\n7. Distribution");
		System.out.print("Choose A Number: ");
		int engagement = getMethodEngagement(input);
		methodEngagement(engagement);
		//When conductMission calls nextInt it does not read the entire line so we need to add an extra input.nextLine() to clear out the extra invisible characters
		input.nextLine();
		System.out.print("Method of Fire and Control? (Optional)");
		System.out.println("\n1. When Ready\n2. At My Command\n3. Cannot Observe\n4. Time on Target\n5. Time To Target\n6. Coordinated Illumination\n7. Continuous Illumination\n8. Cease Load\n9. Check Fire\n10. Continuous Fire\n11. Repeat\n12. Request Splash\n13. Do Not Load\n14. Duration");
		System.out.print("Choose A Number: ");
		int fire = getFireControl(input);
		methodFireControl(fire);
		//When methodFireControl calls nextInt it does not read the entire line so we need to add an extra input.nextLine() to clear out the extra invisible characters
		input.nextLine();
		String missionType = getTypeOfMission(missionNumber);
		System.out.println("Warlord this is " + callSign + " " + missionType + " Over");
		String targetlocationString = conductMission(choice);
		System.out.println(targetlocationString + " Over");
		String engagementMethod = methodEngagement(engagement);
		String fireMethod = methodFireControl(fire);
		System.out.println(targetDescription + " " + engagementMethod + " " + fireMethod + " Over");

		
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
			missionNumber = input.nextInt();
		} catch(Exception ex) {
			System.out.println("This is not a valid selection");
		}
		return missionNumber;
	}

	//Takes the value of choice and returns a string with the associated mission
	public static String getTypeOfMission(int missionNumber) {
		String missionType = "";
		if (missionNumber == 1) {
			missionType = "Adjust Fire";
		} else if(missionNumber == 2) {
			missionType = "Fire For Effect";
		} else if(missionNumber == 3) {
			missionType = "Suppression";
		}  else if(missionNumber == 4) {
			missionType = "Immediate Suppression";
		} else if(missionNumber == 5) {
			missionType = "Suppression of Enemy Air Defense";
		} else {
			missionType = "Unknown Mission Type";
		}
		return missionType;
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
	public static String conductMission(int choice) {
		String targetlocationString = "";
		Scanner input = new Scanner(System.in);
		//This makes it to where values are only input if null, so at the end we do not need to input them again when we compile the user inputs.
		if (choice == 1) {
			if (EnemyGridZone == null) {
				System.out.print("Enter Enemy Grid Zone Designator: ");
	            EnemyGridZone = input.nextLine();
			}
			if (targetLocation == null) {
				System.out.print("Enter enemy grid: ");
	            targetLocation = input.nextLine();
			}
	        targetlocationString = "Grid" + " " + EnemyGridZone + " " + getTargetLocation(targetLocation);
		} else if(choice == 2) {
			if (distanceToTarget == null) {
				System.out.print("Distance to Target in Meters: ");
	            distanceToTarget = input.nextLine();
			}
			if (directionToTarget == null) {
				System.out.print("Direction to Target in Mils: ");
	            directionToTarget = input.nextLine();
			}
	        targetlocationString = "Distance" + " " + distanceToTarget + " " + "meters" + " " + "Direction" + " " + directionToTarget + " " + "mils";
		} else if(choice == 3) {
			if (knownPoint == null) {
				System.out.print("Identify know point: Example AB1000: ");
	            knownPoint = input.nextLine();
			}
			if (directionNewTarget == null) {
				System.out.print("Direction to New Target in Mils: ");
	            directionNewTarget = input.nextLine();
			}
			if (leftRight == null) {
				System.out.print("Lateral Shift in Meters: Example Left 30: ");
	            leftRight = input.nextLine();
			} 
			if (addDrop == null) {
				System.out.print("Range Shift in Meters: Example Add 100: ");
	            addDrop = input.nextLine();
			}
	        System.out.println("Shift" + " " + knownPoint + " " + "Direction" + " " + directionNewTarget + " " + "mils" + " " + leftRight + " " + "meters" + " " + addDrop + " " + "meters");
		}
		return targetlocationString;
	}

	//Format Target Location
	public static String getTargetLocation(String targetLocation) {
		int index = targetLocation.length() / 2;
		String targetFront = targetLocation.substring(0, index);
		String targetBack = targetLocation.substring(index);
		String Space = " ";
		return targetFront.toString() + Space + targetBack.toString();
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
	public static String methodEngagement(int engagement) {
		String engagementMethod = " ";
		if (engagement == 1) {
			engagementMethod = "";
		} else if(engagement == 2) {
			engagementMethod = "Type of Adjustment";
		} else if(engagement == 3) {
			engagementMethod = "Danger Close";
		} else if(engagement == 4) {
			engagementMethod = "Mark";
		} else if(engagement == 5) {
			engagementMethod = "Trajectory";
		} else if(engagement == 6) {
			engagementMethod = "Ammunition";
		} else if(engagement == 7) {
			engagementMethod = "Distribution";
		} 
		return engagementMethod;
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
	public static String methodFireControl(int fire) {
		String fireMethod = " ";
		if (fire == 1) {
			fireMethod = "";
		} else if(fire == 2) {
			fireMethod = "At my Command";
		} else if(fire == 3) {
			fireMethod = "Cannot Observe";
		} else if(fire == 4) {
			fireMethod = "Time on Target";
		} else if(fire == 5) {
			fireMethod = "Time to Target";
		} else if(fire == 6) {
			fireMethod = "Coordinated Illumination";
		} else if(fire == 6) {
			fireMethod = "Continuous Illumination";
		} else if(fire == 8) {
			fireMethod = "Cease Load";
		} else if(fire == 9) {
			fireMethod = "Check Fire";
		} else if(fire == 10) {
			fireMethod = "Continuous Fire";
		} else if(fire == 11) {
			fireMethod = "Repeat";
		} else if(fire == 12) {
			fireMethod = "Request Splash";
		} else if(fire == 13) {
			fireMethod = "Do Not Load";
		} else if(fire == 14) {
			fireMethod = "Duration";
	  }
	  return fireMethod;
    }


}

