import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class that creates CallForFire
public class CallForFire {
	private String MGRS;
	private String grid;
	private int index;
    
	//Constructor that sets the CallForFire parameters
	public CallForFire(String MGRS, String grid) {
		this.MGRS = MGRS;
		this.grid = grid;
	}

	public String getMGRS() {
		int index = MGRS.length() / 2;
        String MGRSFront = MGRS.substring(0, index);
		String MGRSBack = MGRS.substring(index);
		String Space = " ";
		return MGRSFront.toString() + Space + MGRSBack.toString();
	}

	public String getGrid() {
		return grid;
	}

	public int getIndex() {
		return index;
	}
}