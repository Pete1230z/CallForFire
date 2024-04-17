import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Class that creates CallForFire
public class CallForFire {
	private String MGRS;
	private String grid;
    
	//Constructor that sets the CallForFire parameters
	public CallForFire(String MGRS, String grid) {
		this.MGRS = MGRS;
		this.grid = grid;
	}

	// Sets the value of attribute MGRS to value passed as parameter MGRS
	public void setMGRS(String MGRS) {
		if(MGRS.length() >= 6) {
			this.MGRS = MGRS;
		}
	}

	public String getMGRS() {
		return MGRS;
	}


}