/**
 * @author Adam Letizia
 * The laser object starts at a given coordinates and progresses through the maze
 * one room at a time. It rotates 90 degrees if it reflects off a mirror.
 */
public class Laser {
	private int xDirection;
	private int yDirection;
	private String direction;
	private int xCoor;
	private int yCoor;
	private String entryPoint;
	private String exitPoint;
	
	/**
	 * Constructor for the laser class
	 * @param command in the form X,YDirection
	 */
	public Laser(String command){
		//Parse the command into the three different components
		direction = command.replaceAll("[^A-Z]", "");
		String coordinates = command.replaceAll("[A-Z]", "");
		String[] coords = coordinates.split(",");
		
		xCoor = Integer.parseInt(coords[0]);
		yCoor = Integer.parseInt(coords[1]);
		entryPoint = xCoor + "," + yCoor;
		
		//Set Direction for the laser to travel
		if(direction.contains("V")){
			if(yCoor > 0) yDirection = -1;
			else yDirection = 1;
			xDirection = 0;
		}
		else{//Direction = "H"
			if(xCoor > 0) xDirection = -1;
			else xDirection = 1;
			yDirection = 0;
		}
	}
	/**
	 * Increment the laser's coordinates according to it's current direction
	 */
	public void move(){
		exitPoint = xCoor + "," + yCoor;
		xCoor += xDirection;
		yCoor += yDirection;
	}
	/**
	 * Change the direction of the laser
	 * @param mirrorDirection from the mirror of the current square
	 */
	public void changeDirection(String mirrorDirection){
		boolean reflects = false;
		if(mirrorDirection.length() > 1){//1-way mirror
			//Test if the laser passes through with a 1-way mirror
			if(mirrorDirection.equals("RR") && (xDirection == -1 || yDirection == 1)) reflects = true;
			else if(mirrorDirection.equals("RL") && (xDirection == 1 || yDirection == -1)) reflects = true;
			else if(mirrorDirection.equals("LR") && (xDirection == -1 || yDirection == -1)) reflects = true;
			else if(mirrorDirection.equals("LL") && (xDirection == 1 || yDirection == 1)) reflects = true;
		}
		else reflects = true;//2-way mirror
		if (mirrorDirection.startsWith("R") && reflects){//right leaning mirror
			//Swap x and y direction values
			int temp = yDirection;
			yDirection = xDirection;
			xDirection = temp;
		}
		else if(mirrorDirection.startsWith("L") && reflects){//Left leaning mirror
			//Swap x and y direction values and negate
			int temp = yDirection;
			yDirection = xDirection * -1;
			xDirection = temp * -1;
		}
		//Change Orientation String
		if(reflects){
			if(yDirection != 0) direction = "V";
			else direction = "H";
			System.out.println("The laser bounced off a mirror and changed direction.");
		}
	}
	/**
	 * 
	 * @return xCoordinate of the laser
	 */
	public int getXCoor(){
		return xCoor;
	}
	/**
	 * 
	 * @return yCoordinate of the laser
	 */
	public int getYCoor(){
		return yCoor;
	}
	/**
	 * Get the starting point of the laser
	 * @return coordinates in the form X,YDirection
	 */
	public String getEntryPoint(){
		return entryPoint + direction;
	}
	/**
	 * Get the exit point of the laser
	 * @return coordinates in the form X,YDirection
	 */
	public String getExitPoint(){
		return exitPoint + direction;
	}
	/**
	 * 
	 * @return the current direction of the laser
	 */
	public String getDirection(){
		return xDirection + "," + yDirection + direction;
	}

}
