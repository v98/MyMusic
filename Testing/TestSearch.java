package Testing;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import music.*;
public class TestSearch{
	@Test
	public void test1()throws Exception{
		assertEquals("proper search result expected",MyMusic.search("playlist1.txt","Thunder"),"Song: Thunder Singer: ImagineDragons Duration: 370");
		assertEquals("proper search result expected",MyMusic.search("playlist1.txt","Yellow"),"Song not found");
	}
}
