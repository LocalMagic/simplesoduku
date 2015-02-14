// Rules for SOLVING: numbers 1-9 EXACTLY once in every row, column, section => do later

public class Main {
    public static void main(final String[] args) {

        GameFrame gameFrame = new GameFrame();
        gameFrame.setVisible(true);

        byte[] badRow = new byte[] {1, 0, 0, 0, 2, 3, 4, 7, 7};
        byte[] goodRow = new byte[] {1, 0, 0, 0, 2, 3, 4, 6, 7};
        byte[] column = new byte[] {1, 0, 0, 0, 2, 3, 4, 9, 5, 7, 8};
        byte[] array = new byte[] {1, 0, 6, 0, 2, 3, 4, 5, 7};

        byte[][] section = new byte[3][3];
        section[0][0] = 5;
        section[0][1] = 6;
        section[0][2] = 4;
        section[1][0] = 0;
        section[1][1] = 2;
        section[1][2] = 3;
        section[2][0] = 7;
        section[2][1] = 8;
        section[2][2] = 9;

// Rules rules = new Rules();
//
// rules.convertTo1D(section);
//
// byte[] section1D = rules.convertTo1D(section);
//
// System.out.println("array is: " + rules.isValidArray(array));
//
// System.out.println(rules.isValidArray(column));
// System.out.println(rules.isValidArray(section1D));

    }

    // Rules for Validation: only numbers 1-9 and empty, every number only once,
    // arrays valid??

}
