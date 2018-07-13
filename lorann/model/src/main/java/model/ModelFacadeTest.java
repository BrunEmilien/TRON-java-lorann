package model;

import static org.junit.Assert.*;
import model.ModelFacade;
import org.junit.Test;

public class ModelFacadeTest {

	@Test
	public void setMapTest() {
		Wall wall;
		Wall walltest = new Wall("Blue", 50, 50);
		ModelFacade.setMap("Blue", 50, 50);
		wall = (Wall) ModelFacade.getMap(50 , 50);
		assertEquals(wall, walltest);
	}

}
