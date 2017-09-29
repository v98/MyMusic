package music;
import java.util.*;
import java.io.*;

class Song implements Serializable {
	private String name;
	private String singer;
	private int dur;

	public Song(String name, String singer, int dur) {
		this.name = name;
		this.singer = singer;
		this.dur = dur;
	}

	public String getSong() {
		return name;
	}

	public String getSinger() {
		return singer;
	}

	public int getDuration() {
		return dur;
	}

	// @Override
	public String toString() {
		return "Song: " + name + " Singer: " + singer + " Duration: " + dur;
	}

}

public class MyMusic {

	public static String show(String fname) throws Exception {
		String output = "";
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname));
		int count = 0;
		while (true) {
			try {
				Song s = (Song) in.readObject();
				count += 1;
				output = output + s.toString() + "\n";
			} catch (EOFException e) {
				if (count == 0) {
					output = "Songs do not Exist";
				}
				break;
			}

		}
		in.close();
		return output;

	}

	public static void add(String fname, String name, String singer, int dur)
			throws FileNotFoundException, IOException, ClassNotFoundException {
		// ObjectOutputStream out=new ObjectOutputStream(new
		// FileOutputStream(fname),true);
		Song temp = new Song(name, singer, dur);
		// out.writeObject(temp);
		// out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname));
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"./src/temp.txt"));
		int count = 0;
		while (true) {
			try {
				Song s = (Song) in.readObject();
				count += 1;
				out.writeObject(s);
			} catch (EOFException e) {
				out.writeObject(temp);
				count += 1;
				System.out.println("Total number of songs in the playlist :"
						+ count);
				break;
			}
		}
		in.close();
		ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(
				"./src/temp.txt"));
		ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(
				fname));

		while (true) {
			try {
				Song s = (Song) in2.readObject();
				// count+=1;
				out2.writeObject(s);
			} catch (EOFException e) {

				break;
			}
		}

		in2.close();
	}

	public static void delete(String fname, String name)
			throws SongNotFoundException, FileNotFoundException, IOException,
			ClassNotFoundException {
		// ObjectOutputStream out=new ObjectOutputStream(new
		// FileOutputStream(fname),true);
		// out.writeObject(temp);
		// out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname));
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"./src/temp.txt"));
		int count = 0;
		int check = 0;
		while (true) {
			try {
				Song s = (Song) in.readObject();
				if (name.equals(s.getSong())) {
					check += 1;

				} else {
					out.writeObject(s);
				}

			} catch (EOFException e) {
				if (check == 0) {
					System.out.println("Song not found");
				}
				break;
			}

		}
		in.close();

		ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(
				"./src/temp.txt"));
		ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(
				fname));

		while (true) {
			try {
				Song s = (Song) in2.readObject();
				count += 1;
				out2.writeObject(s);
			} catch (EOFException e) {
				if (check == 1) {
					System.out.println("Total no. of songs in the playlist :"
							+ count);
				}
				break;
			}
		}

		in2.close();
	}

	public static String search(String fname, String name)
			throws SongNotFoundException, FileNotFoundException, IOException,
			ClassNotFoundException {
		// ObjectOutputStream out=new ObjectOutputStream(new
		// FileOutputStream(fname),true);
		// out.writeObject(temp);
		// out.close();

		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname));
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"./src/temp.txt"));

		while (true) {
			try {
				Song s = (Song) in.readObject();

				out.writeObject(s);
			} catch (EOFException e) {
				break;
			}
		}

		in.close();

		int check = 0;
		ObjectInputStream in2 = new ObjectInputStream(new FileInputStream(
				"./src/temp.txt"));
		// ObjectOutputStream out2=new ObjectOutputStream(new
		// FileOutputStream(fname));
		while (true) {
			try {
				Song s = (Song) in2.readObject();
				if (name.equals(s.getSong())) {
					check = 1;
					return s.toString();

				}
				// out.writeObject(s);

			} catch (EOFException e) {
				if (check == 0) {
					return "Song not found";
				}
			}

		}
		// in2.close();

	}

	public static void menu1() throws IOException, Exception {
		System.out.println("Enter the name of the playlist :");
		BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
		String fname = "./src/"+rd.readLine()+".txt";
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(fname));
		int count = 0;
		while (true) {
			try {
				Song s = (Song) in.readObject();
				count += 1;
			} catch (EOFException e) {
				System.out.println("Total number of songs in the playlist :"
						+ count);
				break;
			}

		}
		in.close();
		menu2(fname);

	}

	public static void menu2(String fname) throws IOException, Exception {

		int check = 0;
		while (check == 0) {
			System.out.println("Choose from options below :");
			System.out.println("\t1.add");
			System.out.println("\t2.Delete");
			System.out.println("\t3.Search");
			System.out.println("\t4.Show");
			System.out.println("\t5.BackToMenu");
			System.out.println("\t6.Exit");

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					System.in));
			String[] data = rd.readLine().split(" ");
			int n = Integer.parseInt(data[0]);

			switch (n) {
			case 1:
				add(fname, data[1], data[2], Integer.parseInt(data[3]));
				break;
			case 2:
				delete(fname, data[1]);
				break;
			case 3:
				System.out.println(search(fname, data[1]));
				break;
			case 4:
				System.out.println(show(fname));
				break;
			case 5:
				menu1();
				break;
			case 6:
				check = 1;
				break;

			}

		}

	}

	public static void main(String[] args) throws IOException, Exception {

		// ------------------------creating a
		// playlist--------------------------------
// 		FileOutputStream p1 = new FileOutputStream("./src/playlist1.txt");
// 		ObjectOutputStream out = new ObjectOutputStream(p1);
// 		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
// 		out.writeObject(new Song("Thunder", "ImagineDragons", 370));
// 		out.writeObject(new Song("AllTimeLow", "JohnBellion", 400));
// 		out.writeObject(new Song("Yellow", "Coldplay", 473));
// 		out.flush();
		// ---------------------------------------------------------------------------
		menu1();

	}

}

// ------------------------------Custom Exceptions
// --------------------------------
class SongNotFoundException extends Exception {
	public SongNotFoundException(String s) {
		super(s);
	}

}
