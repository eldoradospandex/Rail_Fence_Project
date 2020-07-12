package ie.gmit.dip;

import java.util.*;

public class Menu {
	private RailFenceCypher rf = new RailFenceCypher();
	//private FileHandler fh = new FileHandler();
	private Scanner s;
	private boolean keepRunning = true;
	
	private int key = -1;
	private int offset = 0;
	private String plainText = "";
	

	public Menu() {
	s = new Scanner(System.in);
	}

	

	public void go() {

		while (keepRunning) {
			printMenu();
			
			//Blocking method
			int choice = Integer.parseInt(s.next());

			if (choice == 1) {
				this.selectFile();
				go();
				
			} else if (choice == 2) {
				this.getTextForEncrypt();
				go();

			} else if (choice == 3) {
				this.getEnteredKey();
				go();
				
			} else if (choice == 4) {
				this.getOffset();
				go();

			} else if (choice == 5) {
				this.encryption();
				go();

			} else if (choice == 6) {
				this.decryption();
				go();

			} else if (choice == 7) {
				this.displayRailFence();
				go();
				
			} else if (choice == 8) {
				System.out.println("Shutting down...");
				keepRunning = false;

			} else {
				System.err.println("[ERROR] Invalid input.");
				go();
			}

		}

	}

	private void selectFile() {
		System.out.println("Enter file or URL>");

	}
	
	private void getTextForEncrypt() {
		System.out.println("Enter text to be encrypted");
		plainText = s.next();		
	}


	private void getEnteredKey() {
		System.out.println("Enter the encryption key>");
		key = s.nextInt();
	}
	
	private void getOffset() {
		System.out.println("Enter the desired offset>");
		offset = s.nextInt();
	}

	private void encryption() {
		String encrypted = rf.encrypt(plainText, key);
		if (encrypted != null)
			System.out.println(encrypted);
		
		System.err.println("[ERROR] Invalid input.");
		
	}

	private void decryption() {
		String unencrypted = rf.encrypt(plainText, key, offset);
		if(unencrypted != null)
			System.out.println(rf.decrypt(unencrypted, key, offset));
		
		System.err.println("[ERROR] Invalid input.");
	}

	private void displayRailFence() {
		char[][] matrix = rf.initialiseMatrix(plainText, key);
		rf.print2dCharMatrix(matrix);
	}

	private void printMenu() {
		
		System.out.println("1. Select File or URL");
		System.out.println("2. Enter Text to be Encrypted");
		System.out.println("3. Enter Rail Fence Key");
		System.out.println("4. Enter Offset");
		System.out.println("5. Encrypt");
		System.out.println("6. Decrypt");
		System.out.println("7. Display Rail Fence");
		System.out.println("8. Quit");
		System.out.println("");
		System.out.println("Type option [1-7]>");
	
	}
}
