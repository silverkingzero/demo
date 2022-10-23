package LifeGame;


public class Cell {
    private int x,y;  //细胞位置
    private boolean isLive;  //细胞状态（true:存活  false:死亡）

    public Cell(int x,int y){
        this.x=x;
        this.y=y;
        isLive =false;
    }

    public int getX() {
        return x;
    }

    public boolean setX(int x) {
        if(x<0)
            return false;
        this.x = x;
        return true;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean getIsLive() {
        return isLive;
    }

    public void setIsLive(boolean live) {
        isLive = live;
    }
}