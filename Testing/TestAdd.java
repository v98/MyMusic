
package Testing;
import music.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestAdd {
	@Test
	public void test3()throws Exception {
		// TODO Auto-generated method stub
		MyMusic.add("playlist1.txt","WarningSign","Coldplay",400);
		String k="Song: Thunder Singer: ImagineDragons Duration: 370\nSong: AllTimeLow Singer: JohnBellion Duration: 400\nSong: Yellow Singer: Coldplay Duration: 473\nSong: WarningSign Singer: Coldplay Duration: 400\n";
		assertEquals("Song data should match",k,MyMusic.show("playlist1.txt"));

	}

}
