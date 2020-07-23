package ie.gmit.dip;

public class Runner {
	
	public static void main(String[] args) {
		FileHandler fh = new FileHandler();
		fh.inputReader();
		RailFenceCypher rf = new RailFenceCypher();
		String plain = fh.inputReader();
		int key = 5;
		int offset = 3;
		String encrypted = rf.encrypt(plain, key, offset);
		//System.out.println(encrypted);
		//System.out.println("");
		String unencrypted = rf.decrypt(encrypted, key, offset);
		System.out.println(unencrypted);
		//char[][] matrix = rf.initialiseMatrix(plain, key);
		//rf.print2dCharMatrix(matrix);
		//Menu m = new Menu();
		//m.go();
		

	}
}