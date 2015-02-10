// Rules for SOLVING: numbers 1-9 EXACTLY once in every row, column, section => do later

public class Main {
	public static void main(final String[] args) {

		Board board = new Board();
		board.setVisible(true);

		byte[] badRow = new byte[] { 1, 0, 0, 0, 2, 3, 4, 7, 7 };
		byte[] goodRow = new byte[] { 1, 0, 0, 0, 2, 3, 4, 6, 7 };
		byte[] column = new byte[] { 1, 0, 0, 0, 2, 3, 4, 9, 5, 7, 8 };
		byte[] array = new byte[] { 1, 0, 6, 0, 2, 3, 4, 5, 7 };

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

		convertTo1D(section);

		byte[] section1D = convertTo1D(section);

		System.out.println("array is: " + isValidArray(array));

		System.out.println(isValidArray(column));
		System.out.println(isValidArray(section1D));

	}

	// Rules for Validation: only numbers 1-9 and empty, every number only once,
	// arrays valid??

	// always 9 places, range valid, number once
	public static boolean isValidArray(final byte[] array) {
		if (array.length == 9 && isRangeValid(array) && isNumberOnce(array)) {
			return true;
		} else {
			return false;
		}
	}

	// need to convert section 2D array => 1D array, so can call same method
	public static byte[] convertTo1D(byte[][] section) {
		byte[] oneDSection = new byte[section.length * section.length];
		for (int i = 0; i < section.length; i++) {
			for (byte j = 0; j < section.length; j++) {
				oneDSection[(i * section.length) + j] = section[i][j];
			}
		}
		return oneDSection;
	}

	// numbers 1-9
	public static boolean isRangeValid(final byte[] array) {
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
	public static boolean isNumberOnce(final byte[] array) {
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
