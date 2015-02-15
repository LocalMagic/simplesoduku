import java.util.ArrayList;

public class Rules {

	public boolean isValidBoard(final byte[][] boardState) {

		boolean isValid = true;

		byte[] tempRow = new byte[9];
		byte[] tempCol = new byte[9];

		for (int a = 0; a < boardState.length; a++) {
			for (int b = 0; b < boardState.length; b++) {
				tempRow[b] = boardState[a][b];
				tempCol[b] = boardState[b][a];
			}
			if (isValidArray(tempRow) == false
					|| isValidArray(tempCol) == false) {
				isValid = false;
			}
		}

		/*
		 * using the methods in this class you need to work out whether the
		 * parsed boardState byte[][] is a valid sudoku game and parse true or
		 * false
		 */

		boolean sectionValid = isValidArray(getSection(boardState));

		return isValid;
	}

	// always 9 places, range valid, number once
	private boolean isValidArray(final byte[] array) {
		if (array.length == 9 && isRangeValid(array) && isNumberOnce(array)) {
			return true;
		} else {
			return false;
		}
	}

	// get first Section
	public byte[] getSection(final byte[][] boardState) {

		byte[] section = new byte[9];
		int count = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				section[count] = boardState[i][j];
				count++;
			}

		}

		return section;
	}

	// need to convert section 2D array => 1D array, so can call same method
	private byte[] convertTo1D(final byte[][] section) {
		byte[] oneDSection = new byte[section.length * section.length];
		for (int i = 0; i < section.length; i++) {
			for (byte j = 0; j < section.length; j++) {
				oneDSection[(i * section.length) + j] = section[i][j];
			}
		}

		return oneDSection;
	}

	// numbers 1-9
	private boolean isRangeValid(final byte[] array) {
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
	private boolean isNumberOnce(final byte[] array) {
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
