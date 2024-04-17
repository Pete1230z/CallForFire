import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerException {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Please enter your age in years: "); 
    int age = 0;
    try {
      age = input.nextInt();
    }
    catch(InputMismatchException ex) {
      System.out.println("You did not enter a valid integer.");
      System.out.println("Please run again & enter a valid age.");
    }
    System.out.println("You are " + age + " years old.");
  }
}  