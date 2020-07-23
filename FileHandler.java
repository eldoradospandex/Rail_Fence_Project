package ie.gmit.dip;

//open stream is used in the IO tutorial
import java.io.*;
import java.net.URL;

public class FileHandler {

	String fileText = null;

	public String inputReader() {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("in.txt"))));
			String line = null;

			while ((line = br.readLine()) != null) {
				sb.append(line);
				fileText = sb.toString();
				//System.out.println(fileText);
			}
			br.close();

		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}

		return fileText;
	}
}
	
	/*FileInputStream fis = new FileInputStream(fileName);
	byte[] buffer = new byte[10];
	StringBuilder sb = new StringBuilder();while(fis.read(buffer)!=-1)
	{
		sb.append(new String(buffer));
		buffer = new byte[10];
	}fis.close();

	String inputText = sb.toString();
}
}


	/*public FileHandler(RailFenceCypher c) throws FileNotFoundException, IOException {
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