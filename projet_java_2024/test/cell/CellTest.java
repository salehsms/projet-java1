package cell;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

 
/**
 * This class contains unit tests for the Cell class.
*/
public class CellTest{
	/**
	 * Tests the coordinates of a cell.
	*/
	@Test	
	public void testCellCoordinates(){
			Cell cell=new Cell(1,2);

			assertEquals(1,cell.getx());
			assertEquals(2,cell.gety());
	}
}	
