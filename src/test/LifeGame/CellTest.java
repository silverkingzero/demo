package test.LifeGame;
import LifeGame.Cell; import org.junit.Test; import org.junit.Before; import org.junit.After;


import static org.junit.Assert.assertEquals;

/** 
* Cell Tester. 
* 
* @author <Authors name> 
* @since <pre>9ÔÂ 6, 2022</pre> 
* @version 1.0 
*/ 
public class CellTest {
    private static Cell cell = new Cell(15,15);
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: getX() 
* 
*/ 
@Test
public void testGetX() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: setX(int x) 
* 
*/ 
@Test
public void testSetX() throws Exception { 
//TODO: Test goes here...
    int setx=-1;
    boolean judge = cell.setX(setx);
    if(!judge)
        assertEquals(cell.getX(),cell.getX());
    else
        assertEquals(cell.getX(),setx);
} 

/** 
* 
* Method: getY() 
* 
*/ 
@Test
public void testGetY() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setY(int y) 
* 
*/ 
@Test
public void testSetY() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getIsLive() 
* 
*/ 
@Test
public void testGetIsLive() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: setIsLive(boolean live) 
* 
*/ 
@Test
public void testSetIsLive() throws Exception { 
//TODO: Test goes here...
    boolean alive = true;
    cell.setIsLive(alive);
    assertEquals(cell.getIsLive(),alive);
} 


} 
