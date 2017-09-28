import java.util.*;
import java.io.*;


class Song implements Serializable {
	String name;
	String singer;
	int dur;
	public Song(String name,String singer,int dur){
		this.name=name;
		this.singer=singer;
		this.dur=dur;
	}

	@Override
	public String toString(){
		return "Song: "+name+" Singer: "+singer+" Duration: "+dur;
	}
	
}




public class MyMusic{

	public static void display(String fname)throws Exception{
		ObjectInputStream in=new ObjectInputStream(new FileInputStream(fname));
		while(true){
			try{
			Song s=(Song)in.readObject();
			System.out.println(s);
			}
			catch(EOFException e){
				break;
			}

		}
		in.close();
	}
	public static void main(String[] args) throws IOException ,Exception{

		//------------------------creating a playlist--------------------------------
		FileOutputStream p1=new FileOutputStream("playlist1.txt");
		ObjectOutputStream out=new ObjectOutputStream(p1);
		BufferedReader sc=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(sc.readLine());
		for(int i=0;i<n;i++){
			String[] data=sc.readLine().split(" ");
			String name =data[0];
			String singer=data[1];
			int dur=Integer.parseInt(data[2]);
			out.writeObject(new Song(name,singer,dur));

		}
		out.flush();
		//---------------------------------------------------------------------------
		display("playlist1.txt");
		
		
		
		
	}
	
}