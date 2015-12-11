package cisc275.game.model;
import java.util.Random;
import cisc275.game.view.PlantView;
import cisc275.game.view.ViewTemplate;

/**
 * @author Team6
 *Crab will be randomly generated and then randomly move around the map
 *it's location and type will determine how plants interact with it
 *when it is found by the plants checkefficiency function
 *
 *mittencount keeps track of the total number of crabs on the board
 *mitten determines whether the crab is harmful or not
 *speed determines how fast the crab moves(changes by level)
 */
public class Crab extends RandomMover implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9084334807467140813L;
	static int mittencount; 
	public boolean mitten;
	boolean stop = false;
	int xloc = 7; //model
	int yloc = 7; //model
	int upxbound = 1275;
    int upybound = 627;
    int downxbound = 0;
    int downybound = 358;
    final int xIncr = 4;
    final int yIncr = 2;
    int randcount = 0;
    public boolean removel = false;
    boolean up = false; //model
    boolean down = true; //model
    boolean left = false; //model
    boolean right = true; //model
    boolean side;
    public PlantView planta; //will be changed to plant
//	private Image image;
//	private JButton cbutton;
	public int index;
	
	
	/**
	 * Constructor for crab. Uses rando to determine location and whether or not it's a 
	 * mitten crab
	 */
	public Crab(int num) {
		index = num;
		if(rando(5)== 1){
    		mitten = false;
    	}
    	else{
    		mitten = true;
    	}
		yloc = rando(3);
		if(side == true){
			side = false;
			xloc = ViewTemplate.scalex(1275);
		}
		else{
			side = true;
		}
	}
	
	public Crab(boolean mit){
		this.mitten = mit;
	}
	
	 /**
     * 
     * Method controlling all random actions for crabs (mitten or native, y-axis spawn
     * location, direction change) 
     * @param l
     * @return int
     */
    public int rando(int l){
    	Random rnd = new Random();
    	if(l == 1){ //1 in 8 chance of randomly changing direction
    		return(rnd.nextInt(8)+1);
    	}
    	else if(l == 2){ //determines which direction it moves
    		return(rnd.nextInt(4)+1);
    	}
    	else if(l == 5){ //1 in four chance of making a mitten crab
    		System.out.print(rnd.nextInt(1));
    		return(rnd.nextInt(4));
    	}
    	else{ //where on the y axis crab spawns
    		int j = rnd.nextInt(269)+358;
    		return(j);
    	}
    	
    }
    
    /**
     * If rando determines that the crab should change directions it determines the new
     * random direction
     */
    public void move() {
    	//System.out.println("WORKING");
    	if(!isStop()){
    		randcount= rando(1);
        	int rand = 0;       	
        	if(randcount == 1){
        		randcount = 0;
        		rand = rando(2);
        	}
        	 if (xloc >= upxbound || rand == 1)
             {
                 right = false;
                 left = true;
             }
             
             if (xloc <= downxbound || rand == 2)
             {
                 right = true;
                 left = false;
             }
             
             if (yloc >=  upybound || rand == 3)
             {
                 up = true;
                 down = false;
             }
             
             if (yloc <= downybound  || rand == 4)
             {
                 up = false;
                 down = true;
             }
             rand = 0;
             if (up) yloc-=yIncr;
             if (down) yloc+=yIncr;
             if (left) xloc-=xIncr;
             if (right) xloc+=xIncr;
    	}
    }
    
    /**
   	 * Handles direction change during collision with plant. Should be moved to model.
   	 */
    public void setNewDirection(){
		 int rand = rando(2);
		 if (rand == 1)
        {
            right = false;
            left = true;
        }
        
        if (rand == 2)
        {
            right = true;
            left = false;
        }
        
        if (rand == 3)
        {
            up = true;
            down = false;
        }
        
        if (rand == 4)
        {
            up = false;
            down = true;
        }
	 }
	
    public int getXloc() {
		return xloc;
	}

	public int getYloc() {
		return yloc;
	}

	public boolean isMitten() {
		return mitten;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	public void setrandom(){
		 int rand = rando(2);
		 if (rand == 1)
        {
            right = false;
            left = true;
        }
        
        if (rand == 2)
        {
            right = true;
            left = false;
        }
        
        if (rand == 3)
        {
            up = true;
            down = false;
        }
        
        if (rand == 4)
        {
            up = false;
            down = true;
        }
	 }
	//	public JButton getButton() {
//		return cbutton;
//	}
//	

}
