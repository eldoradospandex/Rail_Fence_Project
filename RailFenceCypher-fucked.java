package ie.gmit.dip;


public class RailFenceCypher {

	public String encrypt(String plainText, int key) {
		//code adopted from geeksforgeeks.org/rail-fence-cipher-encryption-decryption for c++
		String cipherText = null;

		// The 2d array to store the encrypted/decrypted text
		char[][] matrix = new char[key][plainText.length()];

		// Filling in the blank spaces in the array
		int row = key;
		int col = plainText.length();
		
		for (int n = 0; n < row; n++) {
			for (int j = 0; j < col; j++) {
				int position = position++;
				matrix[n][j] = ' ';
			

			// Checking whether going up or down in the array, reversing if at top or bottom
			
			boolean check = false;
			
			for (int k = 0; k < plainText.length(); k++) {
				if (row == 0 || row == key - 1) {
					check = !check;
				}

				// entering the char into the row nCOME BACK HERE


				// finding the next row using check for direction
				if (check) {
					row++;
				} else
					row--;
			}
			matrix[row][col] = plainText.charAt(position);
			
			}
			for (int i = 0; i < matrix.length; i++) {
				for (int m = 0; m < matrix[i].length; m++) {
					//cipherText += matrix[i][m];
					//cipherText = matrix.toString();
					System.out.print(matrix[i][m]);
					}
				}
			}
		return cipherText;
	}
}
