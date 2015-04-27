import java.util.ArrayList;
import java.util.List;


public class Solving {
	
	
	//look for field byte==0  => list possibles 1-9
	
	
	
	
	private static void listPossibles (){
	List<Byte> possible= new ArrayList<Byte>();
	possible.add((byte) 1);
	possible.add((byte) 2);
	possible.add((byte) 3);
	possible.add((byte) 4);
	possible.add((byte) 5);
	possible.add((byte) 6);
	possible.add((byte) 7);
	possible.add((byte) 8);
	possible.add((byte) 9);
	}
	
	
	
	
	
	
	/**
	*look in row, column, section => exclude numbers from list of possibles, 
	*if list of possibles.length==1 => fill field, permanently
	*else assign random number out of the list, temporarily
	**/
	
	//move to next field
	
	//board valid==true => congratulations
	//board valid==false => start from beginning
	
}

