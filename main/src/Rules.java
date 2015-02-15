
public class Rules {

    public boolean isValidBoard(final byte[][] boardState) {

        boolean isValid = false;

        // todo fra :
        /* using the methods in this class you need to work out whether the parsed boardState byte[][] is a
         * valid sudoku game and parse true if it is.
         * Also work out which methods you think should only be called in this class only (and make them private), and
         * which methods need to be called outside of this class (in GameFrame) and make them public */

        return isValid;
    }

    // always 9 places, range valid, number once
    public boolean isValidArray(final byte[] array) {
        if (array.length == 9 && isRangeValid(array) && isNumberOnce(array)) {
            return true;
        } else {
            return false;
        }
    }

    // need to convert section 2D array => 1D array, so can call same method
    public byte[] convertTo1D(final byte[][] section) {
        byte[] oneDSection = new byte[section.length * section.length];
        for (int i = 0; i < section.length; i++) {
            for (byte j = 0; j < section.length; j++) {
                oneDSection[(i * section.length) + j] = section[i][j];
            }
        }

        return oneDSection;
    }

    // numbers 1-9
    public boolean isRangeValid(final byte[] array) {
        boolean isRangeValid = false;
        for (int i = 0; i < array.length; i++) {
            byte currentNumber = array[i];

            // check if element is VALID 1-9
            if (array[i] >= 0 && array[i] < 10) {
                isRangeValid = true;
            } else {
                isRangeValid = false;
                return false;
            }
        }

        return isRangeValid;
    }

    // Numbers only once
    public boolean isNumberOnce(final byte[] array) {
        for (int i = 0; i < array.length - 1; i++) {

            byte elementToCheck = array[i];

            if (elementToCheck != 0) {

                for (int j = i + 1; j < array.length; j++) {

                    if (elementToCheck == array[j]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
