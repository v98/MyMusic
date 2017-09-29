package Testing;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import	org.junit.runner.RunWith;	
import org.junit.runner.notification.Failure;
import	org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({	
TestAdd.class,	
TestDel.class,
TestSearch.class
})	
public class TestSuit {
}
