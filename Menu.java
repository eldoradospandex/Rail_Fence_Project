package ie.gmit.dip;

import java.util.*;

public class Menu {
	private RailFenceCypher rf = new RailFenceCypher();
	private FileHandler fh = new FileHandler();
	private Scanner s;
	private boolean keepRunning = true;

	private int key = 0;
	private int offset = 0;
	private String inputText = "";

	public Menu() {
		s = new Scanner(System.in);
	}

	public void go() {

		while (keepRunning) {
			printMenu();
			int choice = Integer.parseInt(s.next());

			if (choice == 1) {
				this.selectFile();
				go1();

			} else if (choice == 2) {
				this.selectURL();
				go1();

			} else if (choice == 3) {
				this.getTextForEncrypt();
				go1();

			} else if (choice == 4) {
				System.out.println("Shutting down...");
				keepRunning = false;

			} else {
				System.err.println("[ERROR] Invalid input.");
				go();
			}

		}

	}

	public void go1() {

		while (keepRunning) {
			printMenu1();
			int choice = Integer.parseInt(s.next());

			if (choice == 1) {
				this.getEnteredKey();
				go1();

			} else if (choice == 2) {
				this.encryption();
				go1();

			} else if (choice == 3) {
				this.decryption();
				go1();

			} else if (choice == 4) {
				this.displayRailFence();
				go1();

			} else if (choice == 5) {
				this.outputFile();
				go1();

			} else if (choice == 6) {
				go();

			} else if (choice == 7) {
				System.out.println("Shutting down...");
				keepRunning = false;

			} else {
				System.err.println("[ERROR] Invalid input.");
				go1();
			}

		}

	}

	private void selectFile() {
		System.out.println("Enter file>");
		inputText = fh.fileReader();

	}

	private void selectURL() {
		System.out.println("Enter URL>");
		inputText = fh.urlReader();
	}

	private void getTextForEncrypt() {
		System.out.println("Enter text to be encrypted>");
		s.nextLine();
		inputText = s.nextLine();

	}

	private void getEnteredKey() {
		System.out.println("Enter the desired number of rails>");
		key = s.nextInt();
		System.out.println("Enter the desired offset>");
		System.out.println("(If no offset is desired select 0.)");
		offset = s.nextInt();
	}

	private void encryption() {
		if (key == 0) {
			System.err.println("[SYSTEM INFO] No key has been entered. Using default key of 5");
			key = 5;
		}

		String encrypted = rf.encrypt(inputText, key, offset);
		System.out.println(encrypted);

	}

	private void decryption() {
		String unencrypted = null;
		if (unencrypted == null) {
			System.err.println("[ERROR] Invalid selection. You have not encrypted any text. Please try again. ");
			go();
		}
		unencrypted = rf.encrypt(inputText, key, offset);
		System.out.println(rf.decrypt(unencrypted, key, offset));
	}

	private void displayRailFence() {
		if (key == 0) {
			System.err.println("[SYSTEM INFO] No key has been entered. Using default key of 5.");
			key = 5;
		}
		char[][] matrix = rf.initialiseMatrix(inputText, key);
		rf.print2dCharMatrix(matrix);
	}

	private void outputFile() {
		if (key == 0) {
			System.err.println("[ERROR] No text has been encrypted, please try again.");
			go1();

		}
		fh.fileOutput(rf.encrypt(inputText, key, offset));
	}

	private void printMenu() {

		System.out.println("***********************");
		System.out.println("1. Choose File");
		System.out.println("2. Choose URL");
		System.out.println("3. Enter Message");
		System.out.println("4. Quit");
		System.out.println("Type option [1-4]>");
		System.out.println("***********************");

	}

	private void printMenu1() {

		System.out.println("***********************");
		System.out.println("1. Enter Rail Fence Key");
		System.out.println("2. Encrypt");
		System.out.println("3. Decrypt");
		System.out.println("4. Display Rail Fence");
		System.out.println("5. Output to File");
		System.out.println("6. Return to Start");
		System.out.println("7. Quit");
		System.out.println("");
		System.out.println("Type option [1-7]>");
		System.out.println("***********************");

	}
}
