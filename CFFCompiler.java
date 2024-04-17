import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CFFCompiler {
	public static void main(String[] args) {
		CallForFire test = new CallForFire("12345678", "Kill Myself");
		System.out.println(test.getMGRS());
		System.out.println(test.getGrid());
	}	
}
