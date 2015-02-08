
public class Main {
    public static void main(final String[] args) {

// JFrame jFrame = new JFrame();
//
// JMenuBar jMenuBar = new JMenuBar();
//
// // FRAME setup
// // todo fra: play around and see what jframe. settings you can change
// jFrame.setSize(640, 640);
// jFrame.setTitle("Simple Sudoku");

        byte[] badRow = new byte[] {7, 0, 0, 0, 2, 3, 4, 8, 7};
        byte[] goodRow = new byte[] {1, 0, 0, 0, 2, 3, 4, 6, 7};
        byte[] buggyRow = new byte[] {1, 0, 0, 0, 2, 3, 4, 23,5};

        System.out.println("bad Row is: " + isValidRow(badRow));
        System.out.println("goodRow is: " + isValidRow(goodRow));
        System.out.println("buggyRow is: " + isValidRow(buggyRow));
    }

    public static boolean isValidRow(final byte[] row) {


        if (row.length == 9 &&
        	isRowRangeValid(row)&&
        	isNumberOnce(row)){
        	return true;
        }
        	else{ 
        		return false;
        	}
    }
    
    
    //numbers 1-9
    public static boolean isRowRangeValid(final byte[] row){
     boolean isRowRangeValid = false;
    	for (int i = 0; i < row.length; i++) {
    			byte currentNumber = row[i];
    			
                // check if element is VALID 1-9
                if (row[i] >= 0 && row[i] < 10) {
                    isRowRangeValid = true;
                } else {
                    isRowRangeValid = false;
                    return false;
                }
    	}
    	return isRowRangeValid;
    }
    
    
    //Numbers only once
    public static boolean isNumberOnce(final byte[] row){
    for (int i = 0; i < row.length -1; i++) {

        byte elementToCheck = row[i];

        if (elementToCheck != 0) {

            for (int j = i + 1; j < row.length; j++) {

                if (elementToCheck == row[j]) {
                    return false;
                }
            }
        }
    }
    return true;
    }
    
    

}


