package test.LifeGame;

import LifeGame.GameGUI;
import LifeGame.World;
import org.junit.Test;

import static org.junit.Assert.*;
public class GameGUITest {

    private  static World w = new World(20,20);
    private static GameGUI gg = new GameGUI("cellWorld", w);

    @Test
    public void testInitGameGUI() {
        assertEquals(w.getNowGeneration(),0);
        gg.initGameGUI();
        String bn1 = gg.getBeginAndOver().getText();
        String bn2 = gg.getRandomInit().getText();
        assertEquals(bn1,"开始游戏");
        assertEquals(bn2,"随机生成细胞");
    }

    @Test
    public void testChange() {
        int g = w.getNowGeneration();
        gg.Change();
        assertEquals(g+1,w.getNowGeneration());
    }
}