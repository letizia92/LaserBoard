/**
 * 
 */

/**
 * @author Adam Letizia
 * Create a Room object to represent one area of the board with X and Y coordinates.
 * The room may have a mirror that the laser reflects off of.
 */
public class Room {
	private int xCoor;
	private int yCoor;
	private boolean hasMirror;
	private String mirrorDirection;
	
	/**
	 * Constructor of the Room object.
	 * @param xCoor x-coordinate for the room
	 * @param yCoor y-coordinate for the room
	 */
	public Room(int xCoor, int yCoor){
		this.xCoor = xCoor;
		this.yCoor = yCoor;
		hasMirror = false;
	}
	/**
	 * Add a mirror facing a certain direction to the room
	 * @param mirrorDirection 
	 */
	public void addMirror(String mirrorDirection){
		hasMirror = true;
		this.mirrorDirection = mirrorDirection;
	}
	/**
	 * Check to see if the room has a mirror.
	 * @return boolean if the room has a mirror
	 */
	public boolean hasMirror(){
		return hasMirror;
	}
	/**
	 * Get the room's coordinates
	 * @return coordinates in form X,Y
	 */
	public String getCoordinates(){
		return xCoor + "," + yCoor; 
	}
	/**
	 * Get the direction of the mirror
	 * @return String with Direction of the mirror
	 */
	public String getMirrorDirection(){
		return mirrorDirection;
	}
	/**
	 * Override the toString method for the class
	 */
	public String toString(){
		if(hasMirror){
			return "This room is at " + xCoor + "," + yCoor + " and has a mirror";
		}
		else return "This room is at " + xCoor + "," + yCoor;
	}

}
