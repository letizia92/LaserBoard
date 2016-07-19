/**
 * @author Adam Letizia
 *Create a board object with the dimensions supplied by the ASCII text
 *file. The board object will hold an array of room objects.
 */
public class Board {
	
	private String dimensions;
	private int xDimension;
	private int yDimension;
	private Room[][] rooms;
	/**
	 * Constructor for the Board object
	 * Parse the String object to create a 2-dimensional array containing Room objects
	 * @param dimensions in the form X,Y
	 */
	public Board(String dimensions){
		String[] value = dimensions.split(",");
		this.dimensions = dimensions;
		xDimension = Integer.parseInt(value[0]);
		yDimension = Integer.parseInt(value[1]);
		rooms = new Room[xDimension][yDimension];
		
		for(int x = 0; x < xDimension; x++){
			for(int y = 0; y < yDimension; y++){
				//rooms.add(new Room(x, y));
				rooms[x][y] = new Room(x,y);
			}
		}
	}
	/**
	 * 
	 * @return the X dimension only as an integer
	 */
	public int getXDimension(){
		return xDimension;
	}
	/**
	 * 
	 * @return the Y dimension only as an integer
	 */
	public int getYDimension(){
		return yDimension;
	}
	/**
	 * Return the board dimensions
	 * @return the dimensions in form X,Y
	 */
	public String getDimensions(){
		return dimensions;
	}
	/**
	 * Get the board object
	 * @return 2-dimensional array containing the board.
	 */
	public Room[][] getBoard(){
		return rooms;
	}
	/**
	 * Add a mirror at the specified coordinates.
	 * @param coordinates in the form X,YDirectionFacing
	 * Facing is optional
	 */
	public void addMirror(String coordinates){
		String direction = coordinates.replaceAll("[0-9,]", "");
		coordinates = coordinates.replaceAll("[A-Za-z]", "");
		String[] coords = coordinates.split(",");
		int xCoor = Integer.parseInt(coords[0]);
		int yCoor = Integer.parseInt(coords[1]);
		
		
		rooms[xCoor][yCoor].addMirror(direction);
		
	}
	
}
