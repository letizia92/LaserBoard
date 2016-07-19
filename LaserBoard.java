import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LaserBoard {

	public static void main(String[] args) {
		Scanner in;
		try {
			in = new Scanner(new File(args[0]));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File could not be opened. Enter text through console.");
			in = new Scanner(System.in);
		}
		boolean done = false;
		Board board = null;
		Laser laser = null;
		int key = 0;
		while (!done){
			String line = in.next();
			if (line.contains("-1")) key +=1;
			else{
				switch (key){//Switch through the commands
				case 0://Create the board object with the given dimensions
					board = new Board(line);
					break;
				case 1://Add a mirror to the board with given coordinates and direction
					board.addMirror(line);
					break;
				case 2://Create the laser object at the starting point with the given direction
					laser = new Laser(line);
					break;
				case 3:
					done = true;
					break;
				}//end switch
			}//end else statement
			if(key == 3){
				done = true;
				System.out.println("Exit");
			}
		}
		in.close();//Close the scanner object
		
		Room[][] rooms = board.getBoard();

		//Start moving the laser through the board and check for collisions with mirrors
		//Exit when the laser position exceeds the board dimensions
		boolean laserExited = false;
		while(!laserExited){
			System.out.println("Laser Position: " + laser.getXCoor() + "," + laser.getYCoor());
			
			laser.move();
			int laserXCoor = laser.getXCoor();
			int laserYCoor = laser.getYCoor();
			
			//Test to see if the laser has left the board
			if(laserXCoor >= board.getXDimension() || laserYCoor >= board.getYDimension()
					|| laserXCoor < 0 || laserYCoor < 0){
				laserExited = true;
			}
			else{//Laser has not exited
				Room currentRoom = rooms[laserXCoor][laserYCoor];
				
				if(currentRoom.hasMirror()){
					laser.changeDirection(currentRoom.getMirrorDirection());
				}
			}
		}
		System.out.println("The size of the board was " + board.getDimensions());
		System.out.println("The laser started at position " + laser.getEntryPoint());
		System.out.println("The laser exited at position " + laser.getExitPoint());
		//System.out.println("direction: " + laser.getDirection());
	}
	

}
