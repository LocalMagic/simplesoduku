
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

		//there has to be a more elegant way of doing the sections, but nothing i#ve tried works
		boolean sectionValid = isValidArray(getSection(boardState));
		boolean section2Valid = isValidArray(get2Section(boardState));
		boolean section3Valid = isValidArray(get2Section(boardState));
		boolean section4Valid = isValidArray(get2Section(boardState));
		boolean section5Valid = isValidArray(get2Section(boardState));
		boolean section6Valid = isValidArray(get2Section(boardState));
		boolean section7Valid = isValidArray(get2Section(boardState));
		boolean section8Valid = isValidArray(get2Section(boardState));
		boolean section9Valid = isValidArray(get2Section(boardState));
		

		if (sectionValid == false) {
			isValid = false;
		}

		if (section2Valid == false) {
			isValid = false;
		}

		if (section3Valid == false) {
			isValid = false;
		}
		if (section4Valid == false) {
			isValid = false;
		}
		if (section5Valid == false) {
			isValid = false;
		}
		if (section6Valid == false) {
			isValid = false;
		}
		if (section7Valid == false) {
			isValid = false;
		}
		if (section8Valid == false) {
			isValid = false;
		}
		if (section9Valid == false) {
			isValid = false;
		}

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

	// 2nd section
	public byte[] get2Section(final byte[][] boardState) {

		byte[] section2 = new byte[9];
		int count = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 3; j < 6; j++) {
				section2[count] = boardState[i][j];
				count++;
			}
		}
		return section2;
	}
	
	// 3rd section
	public byte[] get3Section(final byte[][] boardState) {

		byte[] section3 = new byte[9];
		int count = 0;

		for (int i = 0; i < 3; i++) {
			for (int j = 6; j < 9; j++) {
				section3[count] = boardState[i][j];
				count++;
				}
			}
			return section3;
		}

	// section 4
	public byte[] get4Section(final byte[][] boardState) {

		byte[] section4 = new byte[9];

		int count = 0;

		for (int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				section4[count] = boardState[i][j];
				count++;
			}
		}
		return section4;
	}
	
	// section 5
	public byte[] get5Section(final byte[][] boardState) {

			byte[] section5 = new byte[9];

			int count = 0;

			for (int i = 3; i < 6; i++) {
				for (int j = 3; j < 6; j++) {
					section5[count] = boardState[i][j];
					count++;
				}
			}
			return section5;
		}
	
	// section 6
	public byte[] get6Section(final byte[][] boardState) {

			byte[] section6 = new byte[9];

			int count = 0;

			for (int i = 3; i < 6; i++) {
				for (int j = 6; j < 9; j++) {
					section6[count] = boardState[i][j];
					count++;
				}
			}
			return section6;
		}
		
		// section 7
		public byte[] get7Section(final byte[][] boardState) {

			byte[] section7 = new byte[9];

			int count = 0;

			for (int i = 6; i < 9; i++) {
				for (int j = 0; j < 3; j++) {
					section7[count] = boardState[i][j];
					count++;
				}
			}
			return section7;
		}
		
		// section 8
		public byte[] get8Section(final byte[][] boardState) {

			byte[] section8 = new byte[9];

			int count = 0;

			for (int i = 6; i < 9; i++) {
				for (int j = 3; j < 6; j++) {
					section8[count] = boardState[i][j];
					count++;
						}
					}
					return section8;
				}
				
	// section 9
			
	public byte[] get9Section(final byte[][] boardState) {

			byte[] section9 = new byte[9];

			int count = 0;

			for (int i = 6; i < 9; i++) {
				for (int j = 6; j < 9; j++) {
					section9[count] = boardState[i][j];
					count++;
				}
			}
			return section9;
			}
	
	
	


	// // need to convert section 2D array => 1D array, so can call same method
	// private byte[] convertTo1D(final byte[][] section) {
	// byte[] oneDSection = new byte[section.length * section.length];
	// for (int i = 0; i < section.length; i++) {
	// for (byte j = 0; j < section.length; j++) {
	// oneDSection[(i * section.length) + j] = section[i][j];
	// }
	// }
	//
	// return oneDSection;
	// }

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
