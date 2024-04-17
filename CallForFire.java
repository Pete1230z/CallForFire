import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class that creates CallForFire
public class CallForFire {
	private int UserGrid;
	private String MGRS;
	private String grid;
    
	//Constructor that sets the CallForFire parameters
	public CallForFire(int UserGrid, String MGRS, String grid) {
		this.UserGrid = UserGrid;
		this.MGRS = String.valueOf(UserGrid);
		this.grid = grid;
	}

	public String getMGRS() {
		return MGRS;
	}


}