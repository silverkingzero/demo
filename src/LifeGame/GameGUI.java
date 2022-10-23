package LifeGame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class GameGUI extends JFrame implements ActionListener {
    int lx,ly;
    private final World world;
    private  JButton[][] TWorld;
    private JLabel NowGeneration;
    private JButton randomInit,BeginAndOver,StopAndContinue,Next,Exit;
    private boolean isRunning;

    public GameGUI(String name,World world){
        super(name);
        this.lx=world.getLx();
        this.ly=world.getLy();
        this.world=world;
        initGameGUI();
    }

    public void initGameGUI(){
        JPanel backPanel,bottomPanel,centerPanel;
        backPanel= new JPanel(new BorderLayout());
        bottomPanel=new JPanel();
        centerPanel=new JPanel(new GridLayout(lx,ly));
        this.setContentPane(backPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        backPanel.add(centerPanel,"Center");
        backPanel.add(bottomPanel,"South");

        TWorld=new JButton[lx][ly];
        NowGeneration=new JLabel("当前代数：0");
        randomInit=new JButton("随机生成细胞");
        BeginAndOver=new JButton("开始游戏");
        StopAndContinue=new JButton("暂停游戏");
        Next=new JButton("下一代");
        Exit=new JButton("退出");
        for(int x=0;x<lx;x++){
            for(int y=0;y<ly;y++){
                TWorld[x][y]=new JButton("");
                TWorld[x][y].setBackground(Color.white);
                centerPanel.add(TWorld[x][y]);
                TWorld[x][y].addActionListener(this);
            }
        }
        bottomPanel.add(NowGeneration);
        bottomPanel.add(randomInit);
        bottomPanel.add(BeginAndOver);
        bottomPanel.add(StopAndContinue);
        bottomPanel.add(Next);
        bottomPanel.add(Exit);

        //设置窗口
        int sizelx,sizely;
        sizelx=Math.min((lx+1)*40,800);
        sizely=Math.min(ly*40,1500);
        sizely=Math.max(ly*40,500);
        this.setSize(sizely,sizelx);
        this.setResizable(true);
        this.setLocationRelativeTo(null);//居中显示
        this.setVisible(true);

        //注册监听器
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e){
                System.exit(0);
            }
        });
        randomInit.addActionListener(this);
        BeginAndOver.addActionListener(this);
        StopAndContinue.addActionListener(this);
        Next.addActionListener(this);
        Exit.addActionListener(this);
    }
    public JButton getBeginAndOver()
    {
        return this.BeginAndOver;
    }
    public JButton getRandomInit()
    {
        return this.randomInit;
    }
    public void actionPerformed(ActionEvent e) {

        Thread thread;
        if (e.getSource() == randomInit&& Objects.equals(BeginAndOver.getText(), "开始游戏")) {//随机生成第一代
            world.randonInitCell();
            showWorld();
            isRunning = false;
            thread = null;
            randomInit.setText("重新生成");
        } else if (e.getSource() == BeginAndOver && Objects.equals(BeginAndOver.getText(), "开始游戏")) {//开始游戏&&randomInit.getText()=="重新生成"
            isRunning = true;
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isRunning) {
                        Change();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
            BeginAndOver.setText("结束游戏");
        } else if (e.getSource() == BeginAndOver && Objects.equals(BeginAndOver.getText(), "结束游戏")) {//结束游戏
            isRunning = false;
            thread = null;
            world.deleteAllCell();
            showWorld();
            BeginAndOver.setText("开始游戏");
            StopAndContinue.setText("暂停游戏");
            randomInit.setText("随机生成细胞");
            NowGeneration.setText("当前代数：0");
        } else if (e.getSource() == StopAndContinue && Objects.equals(StopAndContinue.getText(), "暂停游戏")) {//暂停
            isRunning = false;
            thread = null;
            StopAndContinue.setText("继续游戏");
        } else if (e.getSource() == StopAndContinue && Objects.equals(StopAndContinue.getText(), "继续游戏")) {//继续
            isRunning = true;
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isRunning) {
                        Change();
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
            StopAndContinue.setText("暂停游戏");
        } else if (e.getSource() == Next && StopAndContinue.getText() == "继续游戏") {//下一代
            Change();
            isRunning = false;
            thread = null;
        }else if(e.getSource()==Exit){//退出游戏
            isRunning = false;
            thread = null;
            this.dispose();
            System.exit(0);
        }

        for(int x=0;x<16;x++){
            for(int y=0;y<16;y++){
                if(e.getSource()==TWorld[x][y]){
                    world.change(x,y);
                    showWorld();
                    x=16;y=16;
                }
            }
        }
    }

    public void Change(){
        world.updateOfCell();
        showWorld();
        NowGeneration.setText("当前代数："+world.getNowGeneration());
    }

    public void showWorld(){
        for(int x=0;x<lx;x++){
            for(int y=0;y<ly;y++){
                if(world.getCellXY(x,y)){
                    TWorld[x][y].setBackground(Color.blue);
                }
                else{
                    TWorld[x][y].setBackground(Color.white);
                }
            }
        }
    }
}