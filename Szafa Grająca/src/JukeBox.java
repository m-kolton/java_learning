import java.util.*;
import java.io.*;

public class JukeBox {
	ArrayList<Song> songsList = new ArrayList<Song>();
	
	public static void main(String[] args) {
		new JukeBox().start();
	}

	public void start() {
		getSongs();
		System.out.println(songsList);
		Collections.sort(songsList); // sortuje kolekcj� po tytule
		System.out.println("");
		System.out.println(songsList);
	}

	public void getSongs() {
		try {
			File file = new File("ListaPiosenek.txt"); // nowy obiekt plik
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) { // je�li co� si� znajduje w wierszu to wywo�ujemy metod� dodaj piosenk�
				addSong(line);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void addSong(String lineToParse) {
		
		String[] tokens = lineToParse.split("/"); // tworzy tablic� gdzie w ka�dej z kom�rek znajduje si� to co jest oddzielone "\"
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songsList.add(nextSong);
	}
}
