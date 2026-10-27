package cell;

import org.junit.Test;
import static org.junit.Assert.*;

/**
* This class contains a unit test for the Manhole class.
*/
public class ManholeTest{
	/**
	 *Tests the creation of a Manhole instance, including its initial coordinates.
  	*/
	@Test
	public void testManholeCreation(){
		Manhole manhole=new Manhole(1,2);

		assertEquals(1,manhole.getx());
		assertEquals(2,manhole.gety());
	}
}
