package ie.gmit.dip;


public class RailFenceCypher {

	public String encrypt(String cipherText, int railAmount) {
        String encryptedText = cipherText;
       
        char[][] matrix = new char[railAmount][cipherText.length()];
       
       
        for (int rail = 0 ; rail < railAmount; rail ++) {
            System.out.println("rail");
            for (int railChar = 0; railChar < matrix[rail].length; railChar ++) {
                System.out.println("char");
            }
        }
       
        return encryptedText;
    }
}

