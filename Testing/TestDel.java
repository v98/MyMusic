package Testing;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import music.*;
public class TestDel {
	
	
	@Test
	public void test2()throws Exception {
		// TODO Auto-generated method stub
		MyMusic.delete("playlist1.txt", "Yellow");
		String k="Song: Thunder Singer: ImagineDragons Duration: 370\nSong: AllTimeLow Singer: JohnBellion Duration: 400\nSong: WarningSign Singer: Coldplay Duration: 400\n";
		assertEquals("Songs should match",k,MyMusic.show("playlist1.txt"));

	}

}
