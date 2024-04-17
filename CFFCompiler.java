import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CFFCompiler {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your position in MGRS Grid with your Grid Zone Designator: ");
		String MGRS = input.nextLine();
		System.out.print("Your position in MGRS Grid is" + " " + getMGRSFormat(MGRS));
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

