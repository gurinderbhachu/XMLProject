package Parser;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class testTest {

	@Test
	public void test() {
		test t = new test();
		File f = new File("SampleImport.xml");
		t.DomParser(f);
		t.parse();
	}

}
