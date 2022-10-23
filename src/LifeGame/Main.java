package LifeGame;
public class Main {

    public static void main(String[] arg){
        World world = new World(20, 20);
        GameGUI game = new GameGUI("Game of Life", world);
    }
}

