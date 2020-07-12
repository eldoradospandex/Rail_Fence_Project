package ie.gmit.dip;

public class Runner {
	private static String ciphered = "";
	
	public static void main(String[] args) {
		RailFenceCypher rf = new RailFenceCypher();
		String plain = "123456789";
		int key = 5;
		int offset = 3;
		String encrypted = rf.encrypt(plain, key, offset);
		System.out.println(encrypted);
		String unencrypted = rf.decrypt(encrypted, key, offset);
		System.out.println(unencrypted);
		char[][] matrix = rf.initialiseMatrix(plain, key);
		rf.print2dCharMatrix(matrix);
		//Menu m = new Menu();
		//m.go();
		
//		int key = 5;
//		String unencryptedText = "123456789";
//		System.out.println(unencryptedText);
//		
//		int offset = 3;
//
////		RailFenceCypher rfc = new RailFenceCypher();
////		String hell = rfc.encrypt(unencryptedText, key, offset);
////		String output = rfc.decrypt(hell, key, offset);
////		System.out.println("************************");
////		System.out.println("Orig: "+ unencryptedText);
////		System.out.println("Cyph: "+hell);
////		System.out.println("Out:  "+output);
////		System.out.println("************************");

	}
}