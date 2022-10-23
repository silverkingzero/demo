package test.LifeGame;

import LifeGame.World;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


/** 
* World Tester. 
* 
* @author <Authors name> 
* @since <pre>9ÔÂ 6, 2022</pre> 
* @version 1.0 
*/ 
public class WorldTest { 
private static World world= new World(20,20);
@Before
public void before() throws Exception {
world.deleteAllCell();
} 

@After
public void after() throws Exception {

} 

/** 
* 
* Method: getLx() 
* 
*/ 
@Test
public void testGetLx() throws Exception { 
//TODO: Test goes here...
    int a=world.getLx();
    assertEquals(world.getLx(),a);
} 

/** 
* 
* Method: getLy() 
* 
*/ 
@Test
public void testGetLy() throws Exception { 
//TODO: Test goes here...
    int a=world.getLy();
    assertEquals(world.getLy(),a);
} 

/** 
* 
* Method: getCellXY(int x, int y) 
* 
*/ 
@Test
public void testGetCellXY() throws Exception { 
//TODO: Test goes here...
    boolean a=world.getCellXY(3,4);
    assertEquals(world.getCellXY(3,4),a);
} 

/** 
* 
* Method: getNowGeneration() 
* 
*/ 
@Test
public void testGetNowGeneration() throws Exception { 
//TODO: Test goes here...
    int gene= world.getNowGeneration();
  assertEquals(gene,world.getNowGeneration());
} 

/** 
* 
* Method: randonInitCell() 
* 
*/ 
@Test
public void testRandonInitCell() throws Exception { 
//TODO: Test goes here...c
    world.randonInitCell();
} 

/** 
* 
* Method: deleteAllCell() 
* 
*/ 
@Test
public void testDeleteAllCell() throws Exception { 
//TODO: Test goes here...
    world.deleteAllCell();
    for(int i=0;i< world.getLx();i++){
        for(int j=0;j< world.getLy();j++){
            assertEquals(world.getCellXY(i,j),false);

        }
    }
} 

/** 
* 
* Method: updateOfCell() 
* 
*/ 
@Test
public void testUpdateOfCell() throws Exception { 
//TODO: Test goes here...
    world.deleteAllCell();
world.change(2,2);
world.change(2,1);
world.change(2,3);
world.updateOfCell();
assertEquals(world.getCellXY(2,2),true);
assertEquals(world.getCellXY(1,2),true);
assertEquals(world.getCellXY(3,2),true);
assertEquals(world.getCellXY(2,1),false);
assertEquals(world.getCellXY(2,3),false);
}

/** 
* 
* Method: change(int x, int y) 
* 
*/ 
@Test
public void testSetCellXY() throws Exception {
//TODO: Test goes here...
    boolean x=world.getCellXY(1,1);
    world.change(1,1);
    world.change(1,1);
    boolean y=world.getCellXY(1,1);
 for(int i=0;i<1000;i++){
     assertEquals(x,y);
 }


} 


} 
