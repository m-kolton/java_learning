
public class Song implements Comparable<Song> {
	String title;
	String artist;
	String rate;
	String bmp;

	@Override
	public int compareTo(Song song) {
		return title.compareTo(song.getTitle());
	}
	
	public Song(String title, String artist, String rate, String bmp) {
		this.title = title;
		this.artist = artist;
		this.rate = rate;
		this.bmp = bmp;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getRate() {
		return rate;
	}
	
	public String getBmp() {
		return bmp;
	}
	
	public String toString() {
		return title;
	}
}
