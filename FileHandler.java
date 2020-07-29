package ie.gmit.dip;


import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class FileHandler {
	String fileText = null;
	Scanner s = new Scanner(System.in);

	public String urlReader() {

		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(s.nextLine());
			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

			String line = null;

			while ((line = br.readLine()) != null) {
				sb.append((line) + "\n");
				fileText = sb.toString();
			}
			br.close();

		} catch (IOException e) {
			System.err.println("Invalid URL. Please check and try again.");
			e.getMessage();
		}

		return fileText;
	}

	public String fileReader() {
//Need to move exception handling to the menu for this and URL
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(s.nextLine()))));
			String line = null;

			while ((line = br.readLine()) != null) {
				sb.append((line) + "\n");
				fileText = sb.toString();
			}
			br.close();

		} catch (IOException e) {
			System.err.println("Cannot locate file. Please check file name and try again.");
			e.getMessage();
		}

		return fileText;
	}

	// fix this, needs better catch
	public void fileOutput(String output) {

		try {
			FileWriter fw = new FileWriter(new File("out.txt"));
			fw.write(output);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			System.err.println("Cannot write to file.");
			e.getMessage();
			e.printStackTrace();
		}

	}
}
