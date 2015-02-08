
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
        byte[] goodRow = new byte[] {1, 0, 0, 0, 2, 3, 4, 8, 5};
        byte[] buggyRow = new byte[] {1, 0, 0, 0, 2, 3, 4, 8, 5};

// System.out.println("badRow is: " + isValidRow(badRow));
        System.out.println("goodRow is: " + isValidRow(goodRow));
        System.out.println("buggyRow is: " + isValidRow(goodRow));
    }

    public static boolean isValidRow(final byte[] row) {

        boolean isValid = false;

        if (row.length != 9) {
            return false;
        } else {

            // VALID 1-9

            // go through each element in row
            for (int i = 0; i < row.length; i++) {

                // check ii element is VALID 1-9
                if (row[i] >= 0 && row[i] < 10) {
                    isValid = true;
                } else {
                    return false;
                }
            }

            // Number appears only once
            for (int i = 0; i < row.length; i++) {

                byte elementToCheck = row[i];

                if (elementToCheck != 0) {

                    for (int j = i + 1; j < row.length - 1; j++) {

                        if (elementToCheck == row[j]) {
                            return false;
                        }
                    }
                }
            }
        }

        return isValid;
    }

}
