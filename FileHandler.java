/*package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class FileHandler {
	private RailFenceCypher cypher;
	private FileWriter fw = null;

	public FileHandler(RailFenceCypher c) throws FileNotFoundException, IOException {
		cypher = c;
		
		parse (new FileInputStream(new File("Stuff.txt")), true);
		parse (new URL("http.stuff.com").openStream(), true);

	}

	public void parse(InputStream in, boolean encrypt) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String line;

		while ((line = br.readLine()) != null) {
			String text = encrypt ? cypher.encrypt(line) : cypher.decrypt(line);
			fw.write(text);
		}

		br.close();
		fw.close();
	}
}
*/